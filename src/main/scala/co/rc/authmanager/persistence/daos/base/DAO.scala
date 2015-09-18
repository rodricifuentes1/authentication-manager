package co.rc.authmanager.persistence.daos.base

import co.rc.authmanager.persistence.infrastructure.tables.Tables
import io.strongtyped.active.slick.JdbcProfileProvider

/**
 * Trait that defines a persistence DAO
 */
trait DAO extends Tables with JdbcProfileProvider
