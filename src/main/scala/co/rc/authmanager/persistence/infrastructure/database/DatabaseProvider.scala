package co.rc.authmanager.persistence.infrastructure.database

import com.twitter.util.NonFatal
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.{ ExecutionContext, Future }

import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

/**
 * Trait that defines a database provider for common use in the application
 */
trait DatabaseProvider extends LazyLogging {

  /**
   * Method that connects to the default database
   * @return Default database config
   */
  private val dbConfig: DatabaseConfig[ JdbcProfile ] =
    DatabaseConfig.forConfig[ JdbcProfile ]( "co.rc.authmanager.persistence.authentication-db" )

  /**
   * Return default database jdbc profile
   */
  val profile: JdbcProfile = dbConfig.driver

  /**
   * Return default database
   */
  val db: JdbcBackend#DatabaseDef = dbConfig.db

  /**
   * Provides application default database configuration to internal context.
   * @param f A function that takes application database config and returns A future
   */
  def withConfig[ A ]( f: DatabaseConfig[ JdbcProfile ] => Future[ A ] )( implicit ec: ExecutionContext ): Future[ A ] = f( dbConfig ).recover {
    case NonFatal( ex ) =>
      logger.error( "There was an exception executing database operation", ex )
      throw ex
  }

  /**
   * Provides application default database to internal context.
   * @param f A function that takes application database and returns A future
   */
  def withDatabase[ A ]( f: JdbcBackend#DatabaseDef => Future[ A ] )( implicit ec: ExecutionContext ): Future[ A ] = f( dbConfig.db ).recover {
    case NonFatal( ex ) =>
      logger.error( "There was an exception executing database operation", ex )
      throw ex
  }

}

/**
 * Database provider object
 */
object DB extends DatabaseProvider
