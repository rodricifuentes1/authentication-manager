package co.rc.authmanager.persistence.daos

import co.rc.authmanager.TestContext
import co.rc.authmanager.persistence.infrastructure.tables.Tables

import org.specs2.mutable.Specification

import scala.concurrent.{ Future, Await }
import scala.concurrent.duration._

/**
 * Tests specification for Object RolesDAO
 */
class RolesDAOTest extends Specification {
  sequential

  "RolesDAO specification" should {

    "Get roles by user" in new TestContext( "", List( "default-data.sql" ) ) {
      val rolesFuture: Future[ Seq[ Tables.Role ] ] = {
        db.run( RolesDAO.getUserRoles( 1 ) )
      }
      val futureResult: Seq[ Tables.Role ] = Await.result( rolesFuture, 10.seconds )
      futureResult.size must_== 1
    }

  }

}
