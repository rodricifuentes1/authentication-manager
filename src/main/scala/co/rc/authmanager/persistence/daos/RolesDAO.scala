package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO
import co.rc.authmanager.persistence.utils.extensions.ActiveSlickExtensions

import io.strongtyped.active.slick.{ Lens, EntityActions }
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType
import slick.driver.JdbcProfile

/**
 * Class that defines DAO implementation for Roles
 */
class RolesDAO( val profile: JdbcProfile ) extends EntityActions( profile )
    with DAO with ActiveSlickExtensions {

  override type EntityTable = Roles
  override type Entity = Role
  override type Id = Int

  override def baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override def $id( table: Roles ): jdbcProfile.api.Rep[ Int ] = table.id
  override def idLens: Lens[ Role, Option[ Int ] ] = lens { element: Role => element.id } { ( element, id ) => element.copy( id = id ) }
  override def tableQuery: jdbcProfile.api.TableQuery[ Roles ] = Roles

}
