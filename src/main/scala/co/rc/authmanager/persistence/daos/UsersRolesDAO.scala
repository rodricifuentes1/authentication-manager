package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for UsersRoles
 */
class UsersRolesDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = UserRole
  override type EntityTable = UsersRoles

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ UserRole, Option[ Int ] ] = lens { element: UserRole => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ UsersRoles ] = UsersRoles

  override def $id( table: UsersRoles ): Rep[ Int ] = table.id

}
