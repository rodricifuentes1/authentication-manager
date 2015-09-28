package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for RolesPermissions
 */
class RolesPermissionsDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = RolePermission
  override type EntityTable = RolesPermissions

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ RolePermission, Option[ Int ] ] = lens { element: RolePermission => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ RolesPermissions ] = RolesPermissions

  override def $id( table: RolesPermissions ): Rep[ Int ] = table.id

}
