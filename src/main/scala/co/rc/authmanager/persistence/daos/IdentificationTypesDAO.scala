package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for IdentificationTypes
 */
class IdentificationTypesDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = IdentificationType
  override type EntityTable = IdentificationTypes

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ IdentificationType, Option[ Int ] ] = lens { element: IdentificationType => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ IdentificationTypes ] = IdentificationTypes

  override def $id( table: IdentificationTypes ): Rep[ Int ] = table.id

}
