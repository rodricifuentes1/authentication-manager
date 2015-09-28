package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for Users
 */
class UsersDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = User
  override type EntityTable = Users

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ User, Option[ Int ] ] = lens { element: User => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ Users ] = Users

  override def $id( table: Users ): Rep[ Int ] = table.id

}
