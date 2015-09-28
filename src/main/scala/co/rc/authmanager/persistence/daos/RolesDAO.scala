package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for Roles
 */
class RolesDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = Role
  override type EntityTable = Roles

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ Role, Option[ Int ] ] = lens { element: Role => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ Roles ] = Roles

  override def $id( table: Roles ): Rep[ Int ] = table.id

}
