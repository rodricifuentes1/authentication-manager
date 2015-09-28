package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for Actions
 */
class ActionsDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = Action
  override type EntityTable = Actions

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ Action, Option[ Int ] ] = lens { element: Action => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ Actions ] = Actions

  override def $id( table: Actions ): Rep[ Int ] = table.id

}
