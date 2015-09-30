package co.rc.authmanager.persistence.utils.extensions

import io.strongtyped.active.slick.EntityActions

/**
 * Trait that implements some extensions for EntityActions
 */
trait ActiveSlickExtensions extends QueryExtensions { this: EntityActions =>

  import jdbcProfile.api._

  /**
   * Method that lists table records with pagination option
   * @param pageNumber Page number
   * @param pageSize Page size - Elements per page
   * @return DBIO action with entity sequence.
   *         If pageNumber and pageSize are not defined (None), this method will return page 1 with default number (20) of entries
   */
  def fetchPaginated( pageNumber: Option[ Int ] = None, pageSize: Option[ Int ] = None ): DBIO[ Seq[ Entity ] ] =
    tableQuery.page( pageNumber, pageSize ).result

}
