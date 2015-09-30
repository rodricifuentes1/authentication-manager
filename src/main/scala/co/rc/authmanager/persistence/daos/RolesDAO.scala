package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.infrastructure.tables.Tables

import slick.dbio.Effect.Read
import slick.profile.FixedSqlStreamingAction

/**
 * Object that implements database operations for roles and related
 */
object RolesDAO {

  import Tables.profile.api._
  import Tables.{ Users, UsersRoles, Roles, Permissions, RolesPermissions, RolesIps, RolesRoles } // TableQueries
  import Tables.{ Role, RoleIp, RoleRole, Permission } // Rows

  /**
   * Method that retrieves all roles of a specific user by its identifier
   * @param userId User identifier
   */
  def getUserRoles( userId: Int ): FixedSqlStreamingAction[ Seq[ Role ], Role, Read ] =
    Users
      .join( UsersRoles ).on( _.id === _.userId ).filter( _._2.userId === userId )
      .join( Roles ).on( _._2.roleId === _.id )
      .map( _._2 )
      .result

  /**
   * Method that retrieves all permissions given to a specific role by its identifier
   * @param roleId Role identifier
   */
  def getRolePermissions( roleId: Int ): FixedSqlStreamingAction[ Seq[ Permission ], Permission, Read ] =
    Roles
      .join( RolesPermissions ).on( _.id === _.roleId ).filter( _._2.roleId === roleId )
      .join( Permissions ).on( _._2.permissionId === _.id )
      .map( _._2 )
      .result

  /**
   * Method that retrieves ips allowed to a specific role by its identifier
   * @param roleId Role identifier
   */
  def getAllowedIps( roleId: Int ): FixedSqlStreamingAction[ Seq[ RoleIp ], RoleIp, Read ] =
    Roles
      .join( RolesIps ).on( _.id === _.roleId ).filter( _._2.roleId === roleId )
      .map( _._2 )
      .result

  /**
   * Method that retrieves parents of a specific role by its identifier
   * @param roleId Role identifier
   */
  def getParents( roleId: Int ): FixedSqlStreamingAction[ Seq[ RoleRole ], RoleRole, Read ] =
    Roles
      .join( RolesRoles ).on( _.id === _.childRoleId ).filter( _._2.childRoleId === roleId )
      .map( _._2 )
      .result

}
