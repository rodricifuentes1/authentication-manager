package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for RolesRoles
 */
class RolesRolesDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = RoleRole
  override type EntityTable = RolesRoles

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ RoleRole, Option[ Int ] ] = lens { element: RoleRole => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ RolesRoles ] = RolesRoles

  override def $id( table: RolesRoles ): Rep[ Int ] = table.id

}