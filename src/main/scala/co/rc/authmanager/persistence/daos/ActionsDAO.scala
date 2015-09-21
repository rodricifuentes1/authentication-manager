package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO
import co.rc.authmanager.persistence.utils.extensions.ActiveSlickExtensions

import io.strongtyped.active.slick.{ Lens, EntityActions }
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType
import slick.driver.JdbcProfile

/**
 * Class that defines DAO implementation for Actions
 */
class ActionsDAO( val profile: JdbcProfile ) extends EntityActions( profile )
    with DAO with ActiveSlickExtensions {

  override type EntityTable = Actions
  override type Entity = Action
  override type Id = Int

  override def baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override def idLens: Lens[ Action, Option[ Int ] ] = lens { element: Action => element.id } { ( element, id ) => element.copy( id = id ) }
  override def $id( table: Actions ): jdbcProfile.api.Rep[ Int ] = table.id
  override def tableQuery: jdbcProfile.api.TableQuery[ Actions ] = Actions

}
