package co.rc.authmanager.domain.infrastructure.security

import scala.concurrent.Future

/**
 * Trait that provides role validation functionalities
 */
trait SecurityProvider {

  /**
   * Method that validates if provided role has permission to execute an action in a resource
   * @param roleId Role id to validate
   * @param action Action to execute
   * @param resource Application resource to execute action
   * @param ip Request ip [Optional]. It must be provided when role has enabled ip filtering
   * @param f A code block that executes a domain function
   * @tparam A Method return type
   * @return Future[A]
   */
  def hasPermission[A](roleId: Int,
                      action: String,
                      resource: String,
                      ip: Option[String] = None )( f: => Future[A] ): Future[A] = {
    // Execution flow:
    //  1. Get role from DB.
    //  1.1 Verify role allowed ips if it is set in role properties
    //  1.2
    //  2. Get role allowed ips if is defined in role properties
    //  3. Verify ip validity
    f
  }

  def getRole(roleId: Int, ip: Option[String])

}
