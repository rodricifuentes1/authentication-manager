package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.infrastructure.database.DB
import co.rc.authmanager.persistence.infrastructure.tables.Tables

import slick.dbio.Effect.Read
import slick.profile.FixedSqlStreamingAction

/**
 * Object that implements database operations for roles and related
 */
object RolesDAO {

  import DB.profile.api._

  /**
   * Method that retrieves all roles of a specific user by its identifier
   * @param userId User identifier
   */
  def getUserRoles( userId: Int ): FixedSqlStreamingAction[ Seq[ Tables.Role ], Tables.Role, Read ] =
    Tables.Users
      .join( Tables.UsersRoles ).on( _.id === _.userId ).filter( _._2.userId === userId )
      .join( Tables.Roles ).on( _._2.roleId === _.id )
      .map( _._2 )
      .result

  /**
   * Method that retrieves all permissions given to a specific role by its identifier
   * @param roleId Role identifier
   */
  def getRolePermissions( roleId: Int ): FixedSqlStreamingAction[ Seq[ Tables.Permission ], Tables.Permission, Read ] =
    Tables.Roles
      .join( Tables.RolesPermissions ).on( _.id === _.roleId ).filter( _._2.roleId === roleId )
      .join( Tables.Permissions ).on( _._2.permissionId === _.id )
      .map( _._2 )
      .result

  /**
   * Method that retrieves ips allowed to a specific role by its identifier
   * @param roleId Role identifier
   */
  def getRoleAllowedIps( roleId: Int ): FixedSqlStreamingAction[ Seq[ Tables.RoleIp ], Tables.RoleIp, Read ] =
    Tables.Roles
      .join( Tables.RolesIps ).on( _.id === _.roleId ).filter( _._2.roleId === roleId )
      .map( _._2 )
      .result

  /**
   * Method that retrieves parents of a specific role by its identifier
   * @param roleId Role identifier
   */
  def getRoleParents( roleId: Int ): FixedSqlStreamingAction[ Seq[ Tables.RoleRole ], Tables.RoleRole, Read ] =
    Tables.Roles
      .join( Tables.RolesRoles ).on( _.id === _.childRoleId ).filter( _._2.childRoleId === roleId )
      .map( _._2 )
      .result

}
