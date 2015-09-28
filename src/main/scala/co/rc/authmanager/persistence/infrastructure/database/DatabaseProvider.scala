package co.rc.authmanager.persistence.infrastructure.database

import com.typesafe.config.ConfigFactory

import scala.concurrent.Future

import scalacache.ScalaCache
import scalacache.memoization.memoize

import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

/**
 * Trait that defines a database provider for common use in the application
 */
trait DatabaseProvider {

  /**
   * Loads and return default database jdbc profile
   */
  def defaultProfile: JdbcProfile = ConfigFactory.load().getString( "co.rc.authmanager.persistence.default-db.driver" ) match {
    case "slick.driver.DerbyDriver" | "slick.driver.DerbyDriver$"           => slick.driver.DerbyDriver
    case "slick.driver.H2Driver" | "slick.driver.H2Driver$"                 => slick.driver.H2Driver
    case "slick.driver.HsqldbDriver" | "slick.driver.HsqldbDriver$"         => slick.driver.HsqldbDriver
    case "slick.driver.MySQLDriver" | "slick.driver.MySQLDriver$"           => slick.driver.MySQLDriver
    case "slick.driver.SQLiteDriver" | "slick.driver.SQLiteDriver$"         => slick.driver.SQLiteDriver
    case "slick.driver.PostgresDriver" | "slick.driver.PostgresDriver$" | _ => slick.driver.PostgresDriver
  }

  /**
   * Provides application default database configuration to internal context.
   * @param f A function that needs database config
   */
  def withDefaultDatabase[ A ]( f: DatabaseConfig[ JdbcProfile ] => Future[ A ] )( implicit cache: ScalaCache ): Future[ A ] = memoize {
    f( DatabaseConfig.forConfig[ JdbcProfile ]( "co.rc.authmanager.persistence.default-db" ) )
  }

  /**
   * Loads and return default JDBC profile of a named database
   */
  def namedProfile( dbName: String ) = ConfigFactory.load().getString( s"co.rc.authmanager.persistence.$dbName.driver" ) match {
    case "slick.driver.DerbyDriver" | "slick.driver.DerbyDriver$"           => slick.driver.DerbyDriver
    case "slick.driver.H2Driver" | "slick.driver.H2Driver$"                 => slick.driver.H2Driver
    case "slick.driver.HsqldbDriver" | "slick.driver.HsqldbDriver$"         => slick.driver.HsqldbDriver
    case "slick.driver.MySQLDriver" | "slick.driver.MySQLDriver$"           => slick.driver.MySQLDriver
    case "slick.driver.SQLiteDriver" | "slick.driver.SQLiteDriver$"         => slick.driver.SQLiteDriver
    case "slick.driver.PostgresDriver" | "slick.driver.PostgresDriver$" | _ => slick.driver.PostgresDriver
  }

  /**
   * Provides default database configuration to internal context.
   * @param dbName Database name to provide
   * @param f A function that needs database config
   */
  def withNamedDatabase[ A ]( dbName: String )( f: DatabaseConfig[ JdbcProfile ] => Future[ A ] )( implicit cache: ScalaCache ): Future[ A ] = memoize {
    f( DatabaseConfig.forConfig[ JdbcProfile ]( s"co.rc.authmanager.persistence.$dbName" ) )
  }

}

/**
 * Database provider object
 */
object DB extends DatabaseProvider
