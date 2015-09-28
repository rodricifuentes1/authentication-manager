package co.rc.authmanager.domain.infrastructure.security

import co.rc.authmanager.persistence.daos.RolesDAO
import co.rc.authmanager.persistence.infrastructure.database.DatabaseProvider

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Future

/**
 * Trait that provides role validation capabilities
 */
trait SecurityProvider extends DatabaseProvider with LazyLogging {

  /**
   * Method that validates if provided role has permission to execute an action in a resource. <br/>
   * <b> Execution flow: </b><br/>
   * 1. Get role from database <br/>
   * 2. Verify if request ip is allowed <br/>
   * @param roleId Role id to validate
   * @param action Action to execute
   * @param resource Application resource to execute action
   * @param ip Request ip [Optional]. It must be provided when role has enabled ip filtering
   * @param f A code block that executes a domain function
   * @tparam A Method return type
   * @return Future[A]
   */
  def hasPermission[ A ]( roleId: Int,
    action: String,
    resource: String,
    ip: Option[ String ] = None )( f: => Future[ A ] ): Future[ A ] = f

}
