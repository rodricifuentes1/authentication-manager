package co.rc.authmanager.persistence.infrastructure.database

import scala.concurrent.Future

import scalacache.ScalaCache
import scalacache.memoization.memoize

import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

/**
 * Trait that defines a database provider for common use in the application
 */
trait DatabaseConfigProvider {

  /**
   * Provides application default database configuration to internal context.
   * @param f A function that needs database config
   */
  def withDatabase[ A ]( f: DatabaseConfig[ JdbcProfile ] => Future[ A ] )( implicit cache: ScalaCache ): Future[ A ] = memoize {
    f( DatabaseConfig.forConfig[ JdbcProfile ]( "co.rc.authmanager.persistence.default-db" ) )
  }

  /**
   * Provides default database configuration to internal context.
   * @param dbName Database name to provide
   * @param f A function that needs database config
   */
  def withDatabase[ A ]( dbName: String )( f: DatabaseConfig[ JdbcProfile ] => Future[ A ] )( implicit cache: ScalaCache ): Future[ A ] = memoize {
    f( DatabaseConfig.forConfig[ JdbcProfile ]( s"co.rc.authmanager.persistence.$dbName" ) )
  }

}
