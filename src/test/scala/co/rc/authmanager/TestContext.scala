package co.rc.authmanager

import com.typesafe.config.ConfigFactory

import org.specs2.specification.After

import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits

import slick.jdbc.JdbcBackend.Database
import slick.driver.JdbcProfile

/**
 * Abstract class that provides context to tests
 */
abstract class TestContext( folder: String = "", scriptsNames: List[ String ] = Nil ) extends After {

  /**
   * Execution context for futures handling
   */
  implicit val exc: ExecutionContext = Implicits.global

  /**
   * Return default database jdbc profile
   */
  val profile: JdbcProfile = ConfigFactory.load().getString( "co.rc.authmanager.persistence.authentication-db.driver" ) match {
    case "slick.driver.DerbyDriver" | "slick.driver.DerbyDriver$"           => slick.driver.DerbyDriver
    case "slick.driver.H2Driver" | "slick.driver.H2Driver$"                 => slick.driver.H2Driver
    case "slick.driver.HsqldbDriver" | "slick.driver.HsqldbDriver$"         => slick.driver.HsqldbDriver
    case "slick.driver.MySQLDriver" | "slick.driver.MySQLDriver$"           => slick.driver.MySQLDriver
    case "slick.driver.SQLiteDriver" | "slick.driver.SQLiteDriver$"         => slick.driver.SQLiteDriver
    case "slick.driver.PostgresDriver" | "slick.driver.PostgresDriver$" | _ => slick.driver.PostgresDriver
  }

  /**
   * In-memory database connection loaded
   */
  val db: Database = Database.forURL(
    driver = "org.h2.Driver",
    url = buildDBUrl
  )

  /**
   * Close database connection
   */
  override def after = db.close()

  /**
   * Method that builds database url connection
   */
  def buildDBUrl: String = {
    val base: String = "jdbc:h2:mem:authDB;INIT=runscript from './src/test/resources/sql/create-schema.sql'"
    val scriptsUrls: List[ String ] = scriptsNames.map { script =>
      if ( folder != "" ) s"runscript from './src/test/resources/sql/$folder/$script'"
      else s"runscript from './src/test/resources/sql/$script'"
    }
    ( base :: scriptsUrls ).mkString( "\\;" )
  }
}
