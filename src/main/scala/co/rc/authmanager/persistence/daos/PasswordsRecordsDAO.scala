package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for PasswordsRecords
 */
class PasswordsRecordsDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = PasswordRecord
  override type EntityTable = PasswordRecords

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ PasswordRecord, Option[ Int ] ] = lens { element: PasswordRecord => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ PasswordRecords ] = PasswordRecords

  override def $id( table: PasswordRecords ): Rep[ Int ] = table.id

}
