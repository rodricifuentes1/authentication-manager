package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.infrastructure.database.DB
import co.rc.authmanager.persistence.infrastructure.tables.Tables

import org.specs2.mutable.{ BeforeAfter, Specification }

import scala.concurrent.ExecutionContext.Implicits
import scala.concurrent.{ ExecutionContext, Future, Await }
import scala.concurrent.duration._

/**
 * Tests specification for Object RolesDAO
 */
class RolesDAOTest extends Specification with BeforeAfter {
  sequential

  implicit val exc: ExecutionContext = Implicits.global

  override def before = DB.withDatabase { db =>
    val creationF = db.run( Tables.createSchema )
    Await.ready( creationF, 30.seconds )
  }

  override def after = {}

  "RolesDAO specification" should {

    "Get roles by user" in {
      val rolesFuture: Future[ Seq[ Tables.Role ] ] = DB.withDatabase { db =>
        db.run( RolesDAO.getUserRoles( 1 ) )
      }
      val futureResult: Seq[ Tables.Role ] = Await.result( rolesFuture, 10.seconds )
      futureResult.size must_== 0
    }

  }

}
