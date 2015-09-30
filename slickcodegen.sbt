import slick.codegen.SourceCodeGenerator
import slick.{ model => m }

slickCodegenSettings

// Custom code generator
slickCodegenCodeGenerator := { ( model: m.Model ) => new SourceCodeGenerator( model ) {

  // Maps database table name to entity case class name
  override def entityName = {
    case "ACTIONS"              => "Action"
    case "GENDERS"              => "Gender"
    case "IDENTIFICATION_TYPES" => "IdentificationType"
    case "PASSWORD_RECORDS"     => "PasswordRecord"
    case "PERMISSIONS"          => "Permission"
    case "RESOURCES"            => "Resource"
    case "ROLES"                => "Role"
    case "ROLES_IPS"            => "RoleIp"
    case "ROLES_PERMISSIONS"    => "RolePermission"
    case "ROLES_ROLES"          => "RoleRole"
    case "USERS"                => "User"
    case "USERS_ROLES"          => "UserRole"
    case x                      => x
  }

  // Generates code for the complete model (not wrapped in a package yet)
  override def code = {
    s"\n" +
      s"// ------- CUSTOM CODE start ---------\n" +
      s"import org.joda.time.DateTime\n" +
      s"import co.rc.authmanager.persistence.utils.mappers.JodaTimeMapper\n" +
      s"implicit val jodaMapper = JodaTimeMapper.mapper()\n" +
      s"// ------- CUSTOM CODE end ---------\n" +
      s"\n" +
      s"${super.code}\n"
  }

  override def packageCode(profile: String, pkg: String, container: String, parentType: Option[String]) : String = {
    s"""
package ${pkg}
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile: slick.driver.JdbcProfile = com.typesafe.config.ConfigFactory.load().getString( "co.rc.authmanager.persistence.authentication-db.driver" ) match {
    case "slick.driver.DerbyDriver" | "slick.driver.DerbyDriver$$"           => slick.driver.DerbyDriver
    case "slick.driver.H2Driver" | "slick.driver.H2Driver$$"                 => slick.driver.H2Driver
    case "slick.driver.HsqldbDriver" | "slick.driver.HsqldbDriver$$"         => slick.driver.HsqldbDriver
    case "slick.driver.MySQLDriver" | "slick.driver.MySQLDriver$$"           => slick.driver.MySQLDriver
    case "slick.driver.SQLiteDriver" | "slick.driver.SQLiteDriver$$"         => slick.driver.SQLiteDriver
    case "slick.driver.PostgresDriver" | "slick.driver.PostgresDriver$$" | _ => slick.driver.PostgresDriver
  }
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait ${container}${parentType.map(t => s" extends $t").getOrElse("")} {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  ${indent(code)}
}
      """.trim()
  }

  // Table generator factory.
  override def Table = new Table( _ ) {

    // Indicates whether auto increment columns should be put last and made an Option with a None default.
    override def autoIncLastAsOption = true

    // Column generator factory.
    override def Column = new Column( _ ) {
      // use the data model member of this column to change the Scala type,
      override def rawType = model.tpe match {
        case "java.sql.Timestamp" => "DateTime"
        case _                    => super.rawType
      }
    }

  }

}}

// Slick driver
slickCodegenDriver := slick.driver.PostgresDriver

// JDBC driver name
slickCodegenJdbcDriver := "org.postgresql.Driver"

// Database URL
slickCodegenDatabaseUrl := "jdbc:postgresql://authenticationdb.rc.co:5433/authentication"

// Database user
slickCodegenDatabaseUser := "authentication"

// Database password
slickCodegenDatabasePassword := "authentication_db_pw"

// Output directory -> src/main/scala
slickCodegenOutputDir := baseDirectory.value / "src" / "main" / "scala"

// Output package name
slickCodegenOutputPackage := "co.rc.authmanager.persistence.infrastructure.tables"

// Excluded tables
slickCodegenExcludedTables in Compile := Seq()