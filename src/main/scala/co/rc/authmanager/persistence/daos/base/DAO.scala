package co.rc.authmanager.persistence.daos.base

import co.rc.authmanager.persistence.infrastructure.database.DB
import co.rc.authmanager.persistence.infrastructure.tables.Tables
import co.rc.authmanager.persistence.utils.extensions.ActiveSlickExtensions

import io.strongtyped.active.slick.{ JdbcProfileProvider, EntityActions }

import slick.driver.JdbcProfile

/**
 * A default DAO representation
 */
abstract class DAO( override val jdbcProfile: JdbcProfile = DB.defaultProfile )
  extends EntityActions( jdbcProfile ) with ActiveSlickExtensions with Tables with JdbcProfileProvider
