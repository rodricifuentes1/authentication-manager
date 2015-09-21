package co.rc.authmanager.commons.enumerations

/**
 * Object that defines user valid statuses
 */
object UserStatus extends Enumeration( 1 ) {

  type UserStatus = Value

  val ACTIVE = Value( "ACTIVE" ) // 1
  val INACTIVE = Value( "INACTIVE" ) // 2
  val EMAIL_NOT_CONFIRMED = Value( "EMAIL NOT CONFIRMED" ) // 3
  val PASSWORD_BLOCKED = Value( "PASSWORD BLOCKED" ) // 4
}
