package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for Permissions
 */
class PermissionsDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = Permission
  override type EntityTable = Permissions

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ Permission, Option[ Int ] ] = lens { element: Permission => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ Permissions ] = Permissions

  override def $id( table: Permissions ): Rep[ Int ] = table.id

}
