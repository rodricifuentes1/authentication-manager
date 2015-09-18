#!/bin/bash
set -e

if [ "$DB_NAME" ] && [ "$DB_USER" ] && [ "$DB_USER_PW" ]; then
	db_name=$DB_NAME
	db_user=$DB_USER
	db_user_pw=$DB_USER_PW

	# Create user and database
	gosu postgres psql --user postgres <<-EOSQL
	    CREATE USER "$db_user" WITH PASSWORD '$db_user_pw';
	    CREATE DATABASE $db_name WITH OWNER="$db_user";
	    GRANT ALL PRIVILEGES ON DATABASE $db_name TO $db_user;
	EOSQL

	# Create a new copy of sql file
	cp /docker-entrypoint-initdb.d/createSchema.sql.bak /docker-entrypoint-initdb.d/createSchema.sql
	# Replace sql tables owner ocurrences
	sed -i -e "s/OWNER TO postgres/OWNER TO ${db_user}/g" /docker-entrypoint-initdb.d/createSchema.sql
	# Load sql file into database
	gosu postgres psql --user postgres $db_name < /docker-entrypoint-initdb.d/createSchema.sql
	# Delete generated sql file
	rm /docker-entrypoint-initdb.d/createSchema.sql

	# Execute .sql files
	if [ -d /docker-entrypoint-initdb.d ]; then
		for f in /docker-entrypoint-initdb.d/sql/*.sql; do
			gosu postgres psql --user postgres $db_name < $f
		done
	fi

else
	echo "ERROR: NO VALUES WERE DEFINED FOR DB_NAME, DB_USER OR DB_USER_PW VARIABLES. ITS REQUIRED TO DEFINE ALL OF THEM"
	exit 1
fi