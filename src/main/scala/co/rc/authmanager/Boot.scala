package co.rc.authmanager

import co.rc.authmanager.domain.infrastructure.cache.CacheProvider
import co.rc.authmanager.persistence.daos.RolesDAO
import co.rc.authmanager.persistence.infrastructure.database.DatabaseConfigProvider

import scala.concurrent.Future

object Boot extends App with DatabaseConfigProvider {

  import CacheProvider._
  def xxx: Future[ Option[ RolesDAO#Role ] ] = withDatabase { dbConfig =>
    val dao = new RolesDAO( dbConfig.driver )
    dbConfig.db.run( dao.findOptionById( 1 ) )
  }

  xxx

}
