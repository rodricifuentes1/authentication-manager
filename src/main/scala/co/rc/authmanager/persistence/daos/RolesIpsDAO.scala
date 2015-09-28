package co.rc.authmanager.persistence.daos

import co.rc.authmanager.persistence.daos.base.DAO

import io.strongtyped.active.slick.Lens
import io.strongtyped.active.slick.Lens._

import slick.ast.BaseTypedType

/**
 * Class that defines DAO implementation for RolesIps
 */
class RolesIpsDAO extends DAO {

  import jdbcProfile.api._

  override type Id = Int
  override type Entity = RoleIp
  override type EntityTable = RolesIps

  override val baseTypedType: BaseTypedType[ Int ] = implicitly[ BaseTypedType[ Id ] ]
  override val idLens: Lens[ RoleIp, Option[ Int ] ] = lens { element: RoleIp => element.id } { ( element, id ) => element.copy( id = id ) }
  override val tableQuery: TableQuery[ RolesIps ] = RolesIps

  override def $id( table: RolesIps ): Rep[ Int ] = table.id

}

