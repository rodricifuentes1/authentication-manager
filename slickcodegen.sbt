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
/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait ${container}${parentType.map(t => s" extends $t").getOrElse("")} { this: io.strongtyped.active.slick.JdbcProfileProvider =>
  import jdbcProfile.api._
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
slickCodegenDatabaseUrl := "jdbc:postgresql://192.168.59.103/postgres"

// Database user
slickCodegenDatabaseUser := "postgres"

// Database password
slickCodegenDatabasePassword := "pg"

// Output directory -> src/main/scala
slickCodegenOutputDir := baseDirectory.value / "src" / "main" / "scala"

// Output package name
slickCodegenOutputPackage := "co.rc.authmanager.persistence.infrastructure.tables"

// Excluded tables
slickCodegenExcludedTables in Compile := Seq()