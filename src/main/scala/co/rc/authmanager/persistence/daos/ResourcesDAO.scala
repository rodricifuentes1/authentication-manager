package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for Resources
 */
class ResourcesDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = Resource
  override type EntityTable = Resources

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ Resource, Option[ Int ] ] = lens { element: Resource => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ Resources ] = Resources

  override def $id( table: Resources ): Rep[ Int ] = table.id

}
