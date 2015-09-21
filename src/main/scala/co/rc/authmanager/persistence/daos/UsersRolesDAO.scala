package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO
import co.rc.authmanager.persistence.utils.extensions.ActiveSlickExtensions

import io.strongtyped.active.slick.{ Lens, EntityActions }
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType
import slick.driver.JdbcProfile

/**
 * Class that defines DAO implementation for UsersRoles
 */
class UsersRolesDAO( val profile: JdbcProfile ) extends EntityActions( profile )
    with DAO with ActiveSlickExtensions {

  override type EntityTable = UsersRoles
  override type Entity = UserRole
  override type Id = Int

  override def baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override def idLens: Lens[ UserRole, Option[ Int ] ] = lens { element: UserRole => element.id } { ( element, id ) => element.copy( id = id ) }
  override def $id( table: UsersRoles ): jdbcProfile.api.Rep[ Int ] = table.id
  override def tableQuery: jdbcProfile.api.TableQuery[ UsersRoles ] = UsersRoles

}
