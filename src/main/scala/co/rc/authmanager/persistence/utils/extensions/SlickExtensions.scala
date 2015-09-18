package co.rc.authmanager.persistence.utils.extensions

import slick.lifted.Query

/**
 * Trait that defines extensions for TableQuery
 */
trait SlickExtensions {

  /**
   * Implicit class that defines extensions for generic Query types
   */
  implicit class QueryExtensions[ E, U, C[ _ ] ]( val q: Query[ E, U, C ] ) {

    /**
     * Method that creates a paginated query
     * @param pageNumberOp Page number option
     * @param pageSizeOp Page size option
     * @return Created paginated query if pageNumberOp and pageSizeOp are defined.
     *         It will return page 1 with defaultSize(20) query otherwise.
     */
    def page( pageNumberOp: Option[ Int ], pageSizeOp: Option[ Int ], defaultSize: Int = 20 ): Query[ E, U, C ] = {
      ( for {
        pageNumber <- pageNumberOp
        pageSize <- pageNumberOp
      } yield q.drop( ( pageNumber - 1 ) * pageSize ).take( pageSize ) ) getOrElse {
        q.take( defaultSize )
      }
    }

  }

}
