#!/bin/bash
set -e

# Replace sql tables owner occurrences from .bak file
TEMPORAL=$(sed -e "s/OWNER TO postgres/OWNER TO ${POSTGRES_USER}/g" /docker-entrypoint-initdb.d/bak/schema.sql.bak)

# Load sql file into database
echo "$TEMPORAL" | psql --username "$POSTGRES_USER" --dbname "$POSTGRES_USER"