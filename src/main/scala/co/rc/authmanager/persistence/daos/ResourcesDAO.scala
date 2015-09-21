package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO
import co.rc.authmanager.persistence.utils.extensions.ActiveSlickExtensions

import io.strongtyped.active.slick.{ Lens, EntityActions }
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType
import slick.driver.JdbcProfile

/**
 * Class that defines DAO implementation for Resources
 */
class ResourcesDAO( val profile: JdbcProfile ) extends EntityActions( profile )
    with DAO with ActiveSlickExtensions {

  override type EntityTable = Resources
  override type Entity = Resource
  override type Id = Int

  override def baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override def idLens: Lens[ Resource, Option[ Int ] ] = lens { element: Resource => element.id } { ( element, id ) => element.copy( id = id ) }
  override def $id( table: Resources ): jdbcProfile.api.Rep[ Int ] = table.id
  override def tableQuery: jdbcProfile.api.TableQuery[ Resources ] = Resources

}
