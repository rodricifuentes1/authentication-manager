package co.rc.authmanager.persistence.database

import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

/**
 * Trait that defines defines provider for database context
 */
trait DatabaseConfigProvider {

  /**
   * Current application database config
   */
  def dbConfig: DatabaseConfig[ JdbcProfile ]
}

/**
 * Companion object for DatabaseConfigProvider
 */
object DatabaseConfigProvider extends DatabaseConfigProvider {

  /**
   * Current application database config
   */
  override val dbConfig: DatabaseConfig[ JdbcProfile ] =
    DatabaseConfig.forConfig[ JdbcProfile ]( s"co.rc.authmanager.persistence.default-db" )
}
