package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for Genders
 */
class GendersDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = Gender
  override type EntityTable = Genders

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ Gender, Option[ Int ] ] = lens { element: Gender => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ Genders ] = Genders

  override def $id( table: Genders ): Rep[ Int ] = table.id

}
