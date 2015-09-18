package co.rc.authmanager.persistence.utils.mappers

import java.sql.Timestamp
import org.joda.time.DateTime
import slick.driver.JdbcProfile

/**
 * Object that implements slick mapper for joda time
 */
object JodaTimeMapper {

  /**
   * Joda time mapper implementation
   * @param profile slick jdbc driver
   * @return JodaTime mapper
   */
  implicit def mapper()( implicit profile: JdbcProfile ): profile.BaseColumnType[ DateTime ] = {
    import profile.api._
    MappedColumnType.base[ DateTime, Timestamp ](
      dt => new Timestamp( dt.getMillis ),
      ts => new DateTime( ts.getTime )
    )
  }

}
