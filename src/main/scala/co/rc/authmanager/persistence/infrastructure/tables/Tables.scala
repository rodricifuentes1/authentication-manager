package co.rc.authmanager.persistence.infrastructure.tables
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile: slick.driver.JdbcProfile =
    co.rc.authmanager.persistence.infrastructure.database.DB.profile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._

  // ------- CUSTOM CODE start ---------
  import org.joda.time.DateTime
  import co.rc.authmanager.persistence.utils.mappers.JodaTimeMapper
  implicit val jodaMapper = JodaTimeMapper.mapper()
  // ------- CUSTOM CODE end ---------

  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{ GetResult => GR }

  /** DDL for all tables. Call .create to execute. */
  lazy val schema = Array( Actions.schema, Genders.schema, IdentificationTypes.schema, PasswordRecords.schema, Permissions.schema, Resources.schema, Roles.schema, RolesIps.schema, RolesPermissions.schema, RolesRoles.schema, Users.schema, UsersRoles.schema ).reduceLeft( _ ++ _ )
  @deprecated( "Use .schema instead of .ddl", "3.0" )
  def ddl = schema

  /**
   * Entity class storing rows of table Actions
   *  @param name Database column NAME SqlType(varchar), Length(20,true)
   *  @param description Database column DESCRIPTION SqlType(varchar), Length(255,true), Default(None)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class Action( name: String, description: Option[ String ] = None, id: Option[ Int ] = None )
  /** GetResult implicit for fetching Action objects using plain SQL queries */
  implicit def GetResultAction( implicit e0: GR[ String ], e1: GR[ Option[ String ] ], e2: GR[ Option[ Int ] ] ): GR[ Action ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ String ], <<?[ String ] )
      import r._
      Action.tupled( ( _2, _3, _1 ) ) // putting AutoInc last
  }
  /** Table description of table ACTIONS. Objects of this class serve as prototypes for rows in queries. */
  class Actions( _tableTag: Tag ) extends Table[ Action ]( _tableTag, "ACTIONS" ) {
    def * = ( name, description, Rep.Some( id ) ) <> ( Action.tupled, Action.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( name ), description, Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => Action.tupled( ( _1.get, _2, _3 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column NAME SqlType(varchar), Length(20,true) */
    val name: Rep[ String ] = column[ String ]( "NAME", O.Length( 20, varying = true ) )
    /** Database column DESCRIPTION SqlType(varchar), Length(255,true), Default(None) */
    val description: Rep[ Option[ String ] ] = column[ Option[ String ] ]( "DESCRIPTION", O.Length( 255, varying = true ), O.Default( None ) )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )
  }
  /** Collection-like TableQuery object for table Actions */
  lazy val Actions = new TableQuery( tag => new Actions( tag ) )

  /**
   * Entity class storing rows of table Genders
   *  @param name Database column NAME SqlType(varchar), Length(20,true)
   *  @param description Database column DESCRIPTION SqlType(varchar), Length(255,true), Default(None)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class Gender( name: String, description: Option[ String ] = None, id: Option[ Int ] = None )
  /** GetResult implicit for fetching Gender objects using plain SQL queries */
  implicit def GetResultGender( implicit e0: GR[ String ], e1: GR[ Option[ String ] ], e2: GR[ Option[ Int ] ] ): GR[ Gender ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ String ], <<?[ String ] )
      import r._
      Gender.tupled( ( _2, _3, _1 ) ) // putting AutoInc last
  }
  /** Table description of table GENDERS. Objects of this class serve as prototypes for rows in queries. */
  class Genders( _tableTag: Tag ) extends Table[ Gender ]( _tableTag, "GENDERS" ) {
    def * = ( name, description, Rep.Some( id ) ) <> ( Gender.tupled, Gender.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( name ), description, Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => Gender.tupled( ( _1.get, _2, _3 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column NAME SqlType(varchar), Length(20,true) */
    val name: Rep[ String ] = column[ String ]( "NAME", O.Length( 20, varying = true ) )
    /** Database column DESCRIPTION SqlType(varchar), Length(255,true), Default(None) */
    val description: Rep[ Option[ String ] ] = column[ Option[ String ] ]( "DESCRIPTION", O.Length( 255, varying = true ), O.Default( None ) )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )
  }
  /** Collection-like TableQuery object for table Genders */
  lazy val Genders = new TableQuery( tag => new Genders( tag ) )

  /**
   * Entity class storing rows of table IdentificationTypes
   *  @param name Database column NAME SqlType(varchar), Length(30,true)
   *  @param abbreviation Database column ABBREVIATION SqlType(varchar), Length(5,true)
   *  @param description Database column DESCRIPTION SqlType(varchar), Length(255,true), Default(None)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class IdentificationType( name: String, abbreviation: String, description: Option[ String ] = None, id: Option[ Int ] = None )
  /** GetResult implicit for fetching IdentificationType objects using plain SQL queries */
  implicit def GetResultIdentificationType( implicit e0: GR[ String ], e1: GR[ Option[ String ] ], e2: GR[ Option[ Int ] ] ): GR[ IdentificationType ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ String ], <<[ String ], <<?[ String ] )
      import r._
      IdentificationType.tupled( ( _2, _3, _4, _1 ) ) // putting AutoInc last
  }
  /** Table description of table IDENTIFICATION_TYPES. Objects of this class serve as prototypes for rows in queries. */
  class IdentificationTypes( _tableTag: Tag ) extends Table[ IdentificationType ]( _tableTag, "IDENTIFICATION_TYPES" ) {
    def * = ( name, abbreviation, description, Rep.Some( id ) ) <> ( IdentificationType.tupled, IdentificationType.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( name ), Rep.Some( abbreviation ), description, Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => IdentificationType.tupled( ( _1.get, _2.get, _3, _4 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column NAME SqlType(varchar), Length(30,true) */
    val name: Rep[ String ] = column[ String ]( "NAME", O.Length( 30, varying = true ) )
    /** Database column ABBREVIATION SqlType(varchar), Length(5,true) */
    val abbreviation: Rep[ String ] = column[ String ]( "ABBREVIATION", O.Length( 5, varying = true ) )
    /** Database column DESCRIPTION SqlType(varchar), Length(255,true), Default(None) */
    val description: Rep[ Option[ String ] ] = column[ Option[ String ] ]( "DESCRIPTION", O.Length( 255, varying = true ), O.Default( None ) )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )
  }
  /** Collection-like TableQuery object for table IdentificationTypes */
  lazy val IdentificationTypes = new TableQuery( tag => new IdentificationTypes( tag ) )

  /**
   * Entity class storing rows of table PasswordRecords
   *  @param userId Database column USER_ID SqlType(int4)
   *  @param password Database column PASSWORD SqlType(varchar), Length(255,true)
   *  @param passwordUpdatedAt Database column PASSWORD_UPDATED_AT SqlType(timestamptz)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class PasswordRecord( userId: Int, password: String, passwordUpdatedAt: DateTime, id: Option[ Int ] = None )
  /** GetResult implicit for fetching PasswordRecord objects using plain SQL queries */
  implicit def GetResultPasswordRecord( implicit e0: GR[ Int ], e1: GR[ String ], e2: GR[ DateTime ], e3: GR[ Option[ Int ] ] ): GR[ PasswordRecord ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ Int ], <<[ String ], <<[ DateTime ] )
      import r._
      PasswordRecord.tupled( ( _2, _3, _4, _1 ) ) // putting AutoInc last
  }
  /** Table description of table PASSWORD_RECORDS. Objects of this class serve as prototypes for rows in queries. */
  class PasswordRecords( _tableTag: Tag ) extends Table[ PasswordRecord ]( _tableTag, "PASSWORD_RECORDS" ) {
    def * = ( userId, password, passwordUpdatedAt, Rep.Some( id ) ) <> ( PasswordRecord.tupled, PasswordRecord.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( userId ), Rep.Some( password ), Rep.Some( passwordUpdatedAt ), Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => PasswordRecord.tupled( ( _1.get, _2.get, _3.get, _4 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column USER_ID SqlType(int4) */
    val userId: Rep[ Int ] = column[ Int ]( "USER_ID" )
    /** Database column PASSWORD SqlType(varchar), Length(255,true) */
    val password: Rep[ String ] = column[ String ]( "PASSWORD", O.Length( 255, varying = true ) )
    /** Database column PASSWORD_UPDATED_AT SqlType(timestamptz) */
    val passwordUpdatedAt: Rep[ DateTime ] = column[ DateTime ]( "PASSWORD_UPDATED_AT" )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )

    /** Foreign key referencing Users (database name PASSWORD_RECORDS_USER_ID_FK) */
    lazy val usersFk = foreignKey( "PASSWORD_RECORDS_USER_ID_FK", userId, Users )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
  }
  /** Collection-like TableQuery object for table PasswordRecords */
  lazy val PasswordRecords = new TableQuery( tag => new PasswordRecords( tag ) )

  /**
   * Entity class storing rows of table Permissions
   *  @param actionId Database column ACTION_ID SqlType(int4)
   *  @param resourceId Database column RESOURCE_ID SqlType(int4)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class Permission( actionId: Int, resourceId: Int, id: Option[ Int ] = None )
  /** GetResult implicit for fetching Permission objects using plain SQL queries */
  implicit def GetResultPermission( implicit e0: GR[ Int ], e1: GR[ Option[ Int ] ] ): GR[ Permission ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ Int ], <<[ Int ] )
      import r._
      Permission.tupled( ( _2, _3, _1 ) ) // putting AutoInc last
  }
  /** Table description of table PERMISSIONS. Objects of this class serve as prototypes for rows in queries. */
  class Permissions( _tableTag: Tag ) extends Table[ Permission ]( _tableTag, "PERMISSIONS" ) {
    def * = ( actionId, resourceId, Rep.Some( id ) ) <> ( Permission.tupled, Permission.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( actionId ), Rep.Some( resourceId ), Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => Permission.tupled( ( _1.get, _2.get, _3 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column ACTION_ID SqlType(int4) */
    val actionId: Rep[ Int ] = column[ Int ]( "ACTION_ID" )
    /** Database column RESOURCE_ID SqlType(int4) */
    val resourceId: Rep[ Int ] = column[ Int ]( "RESOURCE_ID" )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )

    /** Foreign key referencing Actions (database name PERMISSIONS_ACTION_ID_FK) */
    lazy val actionsFk = foreignKey( "PERMISSIONS_ACTION_ID_FK", actionId, Actions )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
    /** Foreign key referencing Resources (database name PERMISSIONS_RESOURCE_ID_FK) */
    lazy val resourcesFk = foreignKey( "PERMISSIONS_RESOURCE_ID_FK", resourceId, Resources )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
  }
  /** Collection-like TableQuery object for table Permissions */
  lazy val Permissions = new TableQuery( tag => new Permissions( tag ) )

  /**
   * Entity class storing rows of table Resources
   *  @param name Database column NAME SqlType(varchar), Length(20,true)
   *  @param description Database column DESCRIPTION SqlType(varchar), Length(255,true), Default(None)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class Resource( name: String, description: Option[ String ] = None, id: Option[ Int ] = None )
  /** GetResult implicit for fetching Resource objects using plain SQL queries */
  implicit def GetResultResource( implicit e0: GR[ String ], e1: GR[ Option[ String ] ], e2: GR[ Option[ Int ] ] ): GR[ Resource ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ String ], <<?[ String ] )
      import r._
      Resource.tupled( ( _2, _3, _1 ) ) // putting AutoInc last
  }
  /** Table description of table RESOURCES. Objects of this class serve as prototypes for rows in queries. */
  class Resources( _tableTag: Tag ) extends Table[ Resource ]( _tableTag, "RESOURCES" ) {
    def * = ( name, description, Rep.Some( id ) ) <> ( Resource.tupled, Resource.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( name ), description, Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => Resource.tupled( ( _1.get, _2, _3 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column NAME SqlType(varchar), Length(20,true) */
    val name: Rep[ String ] = column[ String ]( "NAME", O.Length( 20, varying = true ) )
    /** Database column DESCRIPTION SqlType(varchar), Length(255,true), Default(None) */
    val description: Rep[ Option[ String ] ] = column[ Option[ String ] ]( "DESCRIPTION", O.Length( 255, varying = true ), O.Default( None ) )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )
  }
  /** Collection-like TableQuery object for table Resources */
  lazy val Resources = new TableQuery( tag => new Resources( tag ) )

  /**
   * Entity class storing rows of table Roles
   *  @param name Database column NAME SqlType(varchar), Length(20,true)
   *  @param ipFilter Database column IP_FILTER SqlType(bool), Default(false)
   *  @param isSupertype Database column IS_SUPERTYPE SqlType(bool), Default(false)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class Role( name: String, ipFilter: Boolean = false, isSupertype: Boolean = false, id: Option[ Int ] = None )
  /** GetResult implicit for fetching Role objects using plain SQL queries */
  implicit def GetResultRole( implicit e0: GR[ String ], e1: GR[ Boolean ], e2: GR[ Option[ Int ] ] ): GR[ Role ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ String ], <<[ Boolean ], <<[ Boolean ] )
      import r._
      Role.tupled( ( _2, _3, _4, _1 ) ) // putting AutoInc last
  }
  /** Table description of table ROLES. Objects of this class serve as prototypes for rows in queries. */
  class Roles( _tableTag: Tag ) extends Table[ Role ]( _tableTag, "ROLES" ) {
    def * = ( name, ipFilter, isSupertype, Rep.Some( id ) ) <> ( Role.tupled, Role.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( name ), Rep.Some( ipFilter ), Rep.Some( isSupertype ), Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => Role.tupled( ( _1.get, _2.get, _3.get, _4 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column NAME SqlType(varchar), Length(20,true) */
    val name: Rep[ String ] = column[ String ]( "NAME", O.Length( 20, varying = true ) )
    /** Database column IP_FILTER SqlType(bool), Default(false) */
    val ipFilter: Rep[ Boolean ] = column[ Boolean ]( "IP_FILTER", O.Default( false ) )
    /** Database column IS_SUPERTYPE SqlType(bool), Default(false) */
    val isSupertype: Rep[ Boolean ] = column[ Boolean ]( "IS_SUPERTYPE", O.Default( false ) )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )
  }
  /** Collection-like TableQuery object for table Roles */
  lazy val Roles = new TableQuery( tag => new Roles( tag ) )

  /**
   * Entity class storing rows of table RolesIps
   *  @param roleId Database column ROLE_ID SqlType(int4)
   *  @param ip Database column IP SqlType(varchar), Length(45,true)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class RoleIp( roleId: Int, ip: String, id: Option[ Int ] = None )
  /** GetResult implicit for fetching RoleIp objects using plain SQL queries */
  implicit def GetResultRoleIp( implicit e0: GR[ Int ], e1: GR[ String ], e2: GR[ Option[ Int ] ] ): GR[ RoleIp ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ Int ], <<[ String ] )
      import r._
      RoleIp.tupled( ( _2, _3, _1 ) ) // putting AutoInc last
  }
  /** Table description of table ROLES_IPS. Objects of this class serve as prototypes for rows in queries. */
  class RolesIps( _tableTag: Tag ) extends Table[ RoleIp ]( _tableTag, "ROLES_IPS" ) {
    def * = ( roleId, ip, Rep.Some( id ) ) <> ( RoleIp.tupled, RoleIp.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( roleId ), Rep.Some( ip ), Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => RoleIp.tupled( ( _1.get, _2.get, _3 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column ROLE_ID SqlType(int4) */
    val roleId: Rep[ Int ] = column[ Int ]( "ROLE_ID" )
    /** Database column IP SqlType(varchar), Length(45,true) */
    val ip: Rep[ String ] = column[ String ]( "IP", O.Length( 45, varying = true ) )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )

    /** Foreign key referencing Roles (database name ROLES_IPS_ROLE_ID_FK) */
    lazy val rolesFk = foreignKey( "ROLES_IPS_ROLE_ID_FK", roleId, Roles )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
  }
  /** Collection-like TableQuery object for table RolesIps */
  lazy val RolesIps = new TableQuery( tag => new RolesIps( tag ) )

  /**
   * Entity class storing rows of table RolesPermissions
   *  @param roleId Database column ROLE_ID SqlType(int4)
   *  @param permissionId Database column PERMISSION_ID SqlType(int4)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class RolePermission( roleId: Int, permissionId: Int, id: Option[ Int ] = None )
  /** GetResult implicit for fetching RolePermission objects using plain SQL queries */
  implicit def GetResultRolePermission( implicit e0: GR[ Int ], e1: GR[ Option[ Int ] ] ): GR[ RolePermission ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ Int ], <<[ Int ] )
      import r._
      RolePermission.tupled( ( _2, _3, _1 ) ) // putting AutoInc last
  }
  /** Table description of table ROLES_PERMISSIONS. Objects of this class serve as prototypes for rows in queries. */
  class RolesPermissions( _tableTag: Tag ) extends Table[ RolePermission ]( _tableTag, "ROLES_PERMISSIONS" ) {
    def * = ( roleId, permissionId, Rep.Some( id ) ) <> ( RolePermission.tupled, RolePermission.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( roleId ), Rep.Some( permissionId ), Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => RolePermission.tupled( ( _1.get, _2.get, _3 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column ROLE_ID SqlType(int4) */
    val roleId: Rep[ Int ] = column[ Int ]( "ROLE_ID" )
    /** Database column PERMISSION_ID SqlType(int4) */
    val permissionId: Rep[ Int ] = column[ Int ]( "PERMISSION_ID" )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )

    /** Foreign key referencing Permissions (database name ROLES_PERMISSIONS_PERMISSION_ID_FK) */
    lazy val permissionsFk = foreignKey( "ROLES_PERMISSIONS_PERMISSION_ID_FK", permissionId, Permissions )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
    /** Foreign key referencing Roles (database name ROLES_PERMISSIONS_ROLE_ID_FK) */
    lazy val rolesFk = foreignKey( "ROLES_PERMISSIONS_ROLE_ID_FK", roleId, Roles )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
  }
  /** Collection-like TableQuery object for table RolesPermissions */
  lazy val RolesPermissions = new TableQuery( tag => new RolesPermissions( tag ) )

  /**
   * Entity class storing rows of table RolesRoles
   *  @param parentRoleId Database column PARENT_ROLE_ID SqlType(int4)
   *  @param childRoleId Database column CHILD_ROLE_ID SqlType(int4)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class RoleRole( parentRoleId: Int, childRoleId: Int, id: Option[ Int ] = None )
  /** GetResult implicit for fetching RoleRole objects using plain SQL queries */
  implicit def GetResultRoleRole( implicit e0: GR[ Int ], e1: GR[ Option[ Int ] ] ): GR[ RoleRole ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ Int ], <<[ Int ] )
      import r._
      RoleRole.tupled( ( _2, _3, _1 ) ) // putting AutoInc last
  }
  /** Table description of table ROLES_ROLES. Objects of this class serve as prototypes for rows in queries. */
  class RolesRoles( _tableTag: Tag ) extends Table[ RoleRole ]( _tableTag, "ROLES_ROLES" ) {
    def * = ( parentRoleId, childRoleId, Rep.Some( id ) ) <> ( RoleRole.tupled, RoleRole.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( parentRoleId ), Rep.Some( childRoleId ), Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => RoleRole.tupled( ( _1.get, _2.get, _3 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column PARENT_ROLE_ID SqlType(int4) */
    val parentRoleId: Rep[ Int ] = column[ Int ]( "PARENT_ROLE_ID" )
    /** Database column CHILD_ROLE_ID SqlType(int4) */
    val childRoleId: Rep[ Int ] = column[ Int ]( "CHILD_ROLE_ID" )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )

    /** Foreign key referencing Roles (database name ROLES_ROLES_CHILD_ROLE_FK) */
    lazy val rolesFk1 = foreignKey( "ROLES_ROLES_CHILD_ROLE_FK", childRoleId, Roles )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
    /** Foreign key referencing Roles (database name ROLES_ROLES_PARENT_ROLE_FK) */
    lazy val rolesFk2 = foreignKey( "ROLES_ROLES_PARENT_ROLE_FK", parentRoleId, Roles )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
  }
  /** Collection-like TableQuery object for table RolesRoles */
  lazy val RolesRoles = new TableQuery( tag => new RolesRoles( tag ) )

  /**
   * Entity class storing rows of table Users
   *  @param status Database column STATUS SqlType(int4)
   *  @param identification Database column IDENTIFICATION SqlType(varchar), Length(20,true)
   *  @param identificationTypeId Database column IDENTIFICATION_TYPE_ID SqlType(int4)
   *  @param email Database column EMAIL SqlType(varchar), Length(254,true)
   *  @param emailConfirmed Database column EMAIL_CONFIRMED SqlType(bool)
   *  @param username Database column USERNAME SqlType(varchar), Length(30,true)
   *  @param password Database column PASSWORD SqlType(varchar), Length(255,true)
   *  @param passwordUpdatedAt Database column PASSWORD_UPDATED_AT SqlType(timestamptz), Default(None)
   *  @param genderId Database column GENDER_ID SqlType(int4)
   *  @param firstName Database column FIRST_NAME SqlType(varchar), Length(50,true), Default(None)
   *  @param lastName Database column LAST_NAME SqlType(varchar), Length(50,true), Default(None)
   *  @param phone Database column PHONE SqlType(varchar), Length(15,true), Default(None)
   *  @param address Database column ADDRESS SqlType(varchar), Length(255,true), Default(None)
   *  @param createdAt Database column CREATED_AT SqlType(timestamptz)
   *  @param updatedAt Database column UPDATED_AT SqlType(timestamptz), Default(None)
   *  @param loginFailedAttempts Database column LOGIN_FAILED_ATTEMPTS SqlType(int4), Default(0)
   *  @param lastLoginDate Database column LAST_LOGIN_DATE SqlType(timestamptz), Default(None)
   *  @param lastLoginIp Database column LAST_LOGIN_IP SqlType(varchar), Length(45,true), Default(None)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class User( status: Int, identification: String, identificationTypeId: Int, email: String, emailConfirmed: Boolean, username: String, password: String, passwordUpdatedAt: Option[ DateTime ] = None, genderId: Int, firstName: Option[ String ] = None, lastName: Option[ String ] = None, phone: Option[ String ] = None, address: Option[ String ] = None, createdAt: DateTime, updatedAt: Option[ DateTime ] = None, loginFailedAttempts: Int = 0, lastLoginDate: Option[ DateTime ] = None, lastLoginIp: Option[ String ] = None, id: Option[ Int ] = None )
  /** GetResult implicit for fetching User objects using plain SQL queries */
  implicit def GetResultUser( implicit e0: GR[ Int ], e1: GR[ String ], e2: GR[ Boolean ], e3: GR[ Option[ DateTime ] ], e4: GR[ Option[ String ] ], e5: GR[ DateTime ], e6: GR[ Option[ Int ] ] ): GR[ User ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ Int ], <<[ String ], <<[ Int ], <<[ String ], <<[ Boolean ], <<[ String ], <<[ String ], <<?[ DateTime ], <<[ Int ], <<?[ String ], <<?[ String ], <<?[ String ], <<?[ String ], <<[ DateTime ], <<?[ DateTime ], <<[ Int ], <<?[ DateTime ], <<?[ String ] )
      import r._
      User.tupled( ( _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _1 ) ) // putting AutoInc last
  }
  /** Table description of table USERS. Objects of this class serve as prototypes for rows in queries. */
  class Users( _tableTag: Tag ) extends Table[ User ]( _tableTag, "USERS" ) {
    def * = ( status, identification, identificationTypeId, email, emailConfirmed, username, password, passwordUpdatedAt, genderId, firstName, lastName, phone, address, createdAt, updatedAt, loginFailedAttempts, lastLoginDate, lastLoginIp, Rep.Some( id ) ) <> ( User.tupled, User.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( status ), Rep.Some( identification ), Rep.Some( identificationTypeId ), Rep.Some( email ), Rep.Some( emailConfirmed ), Rep.Some( username ), Rep.Some( password ), passwordUpdatedAt, Rep.Some( genderId ), firstName, lastName, phone, address, Rep.Some( createdAt ), updatedAt, Rep.Some( loginFailedAttempts ), lastLoginDate, lastLoginIp, Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => User.tupled( ( _1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9.get, _10, _11, _12, _13, _14.get, _15, _16.get, _17, _18, _19 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column STATUS SqlType(int4) */
    val status: Rep[ Int ] = column[ Int ]( "STATUS" )
    /** Database column IDENTIFICATION SqlType(varchar), Length(20,true) */
    val identification: Rep[ String ] = column[ String ]( "IDENTIFICATION", O.Length( 20, varying = true ) )
    /** Database column IDENTIFICATION_TYPE_ID SqlType(int4) */
    val identificationTypeId: Rep[ Int ] = column[ Int ]( "IDENTIFICATION_TYPE_ID" )
    /** Database column EMAIL SqlType(varchar), Length(254,true) */
    val email: Rep[ String ] = column[ String ]( "EMAIL", O.Length( 254, varying = true ) )
    /** Database column EMAIL_CONFIRMED SqlType(bool) */
    val emailConfirmed: Rep[ Boolean ] = column[ Boolean ]( "EMAIL_CONFIRMED" )
    /** Database column USERNAME SqlType(varchar), Length(30,true) */
    val username: Rep[ String ] = column[ String ]( "USERNAME", O.Length( 30, varying = true ) )
    /** Database column PASSWORD SqlType(varchar), Length(255,true) */
    val password: Rep[ String ] = column[ String ]( "PASSWORD", O.Length( 255, varying = true ) )
    /** Database column PASSWORD_UPDATED_AT SqlType(timestamptz), Default(None) */
    val passwordUpdatedAt: Rep[ Option[ DateTime ] ] = column[ Option[ DateTime ] ]( "PASSWORD_UPDATED_AT", O.Default( None ) )
    /** Database column GENDER_ID SqlType(int4) */
    val genderId: Rep[ Int ] = column[ Int ]( "GENDER_ID" )
    /** Database column FIRST_NAME SqlType(varchar), Length(50,true), Default(None) */
    val firstName: Rep[ Option[ String ] ] = column[ Option[ String ] ]( "FIRST_NAME", O.Length( 50, varying = true ), O.Default( None ) )
    /** Database column LAST_NAME SqlType(varchar), Length(50,true), Default(None) */
    val lastName: Rep[ Option[ String ] ] = column[ Option[ String ] ]( "LAST_NAME", O.Length( 50, varying = true ), O.Default( None ) )
    /** Database column PHONE SqlType(varchar), Length(15,true), Default(None) */
    val phone: Rep[ Option[ String ] ] = column[ Option[ String ] ]( "PHONE", O.Length( 15, varying = true ), O.Default( None ) )
    /** Database column ADDRESS SqlType(varchar), Length(255,true), Default(None) */
    val address: Rep[ Option[ String ] ] = column[ Option[ String ] ]( "ADDRESS", O.Length( 255, varying = true ), O.Default( None ) )
    /** Database column CREATED_AT SqlType(timestamptz) */
    val createdAt: Rep[ DateTime ] = column[ DateTime ]( "CREATED_AT" )
    /** Database column UPDATED_AT SqlType(timestamptz), Default(None) */
    val updatedAt: Rep[ Option[ DateTime ] ] = column[ Option[ DateTime ] ]( "UPDATED_AT", O.Default( None ) )
    /** Database column LOGIN_FAILED_ATTEMPTS SqlType(int4), Default(0) */
    val loginFailedAttempts: Rep[ Int ] = column[ Int ]( "LOGIN_FAILED_ATTEMPTS", O.Default( 0 ) )
    /** Database column LAST_LOGIN_DATE SqlType(timestamptz), Default(None) */
    val lastLoginDate: Rep[ Option[ DateTime ] ] = column[ Option[ DateTime ] ]( "LAST_LOGIN_DATE", O.Default( None ) )
    /** Database column LAST_LOGIN_IP SqlType(varchar), Length(45,true), Default(None) */
    val lastLoginIp: Rep[ Option[ String ] ] = column[ Option[ String ] ]( "LAST_LOGIN_IP", O.Length( 45, varying = true ), O.Default( None ) )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )

    /** Foreign key referencing Genders (database name USERS_GENDER_FK) */
    lazy val gendersFk = foreignKey( "USERS_GENDER_FK", genderId, Genders )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
    /** Foreign key referencing IdentificationTypes (database name USERS_IDENTIFICATION_TYPE_FK) */
    lazy val identificationTypesFk = foreignKey( "USERS_IDENTIFICATION_TYPE_FK", identificationTypeId, IdentificationTypes )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )

    /** Uniqueness Index over (email) (database name USERS_EMAIL_IDX) */
    val index1 = index( "USERS_EMAIL_IDX", email, unique = true )
    /** Uniqueness Index over (identification) (database name USERS_IDENTIFICATION_IDX) */
    val index2 = index( "USERS_IDENTIFICATION_IDX", identification, unique = true )
    /** Index over (status) (database name USERS_STATUS_IDX) */
    val index3 = index( "USERS_STATUS_IDX", status )
    /** Uniqueness Index over (username) (database name USERS_USERNAME_IDX) */
    val index4 = index( "USERS_USERNAME_IDX", username, unique = true )
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery( tag => new Users( tag ) )

  /**
   * Entity class storing rows of table UsersRoles
   *  @param userId Database column USER_ID SqlType(int4)
   *  @param roleId Database column ROLE_ID SqlType(int4)
   *  @param id Database column ID SqlType(serial), AutoInc, PrimaryKey
   */
  case class UserRole( userId: Int, roleId: Int, id: Option[ Int ] = None )
  /** GetResult implicit for fetching UserRole objects using plain SQL queries */
  implicit def GetResultUserRole( implicit e0: GR[ Int ], e1: GR[ Option[ Int ] ] ): GR[ UserRole ] = GR {
    prs =>
      import prs._
      val r = ( <<?[ Int ], <<[ Int ], <<[ Int ] )
      import r._
      UserRole.tupled( ( _2, _3, _1 ) ) // putting AutoInc last
  }
  /** Table description of table USERS_ROLES. Objects of this class serve as prototypes for rows in queries. */
  class UsersRoles( _tableTag: Tag ) extends Table[ UserRole ]( _tableTag, "USERS_ROLES" ) {
    def * = ( userId, roleId, Rep.Some( id ) ) <> ( UserRole.tupled, UserRole.unapply )
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ( Rep.Some( userId ), Rep.Some( roleId ), Rep.Some( id ) ).shaped.<>( { r => import r._; _1.map( _ => UserRole.tupled( ( _1.get, _2.get, _3 ) ) ) }, ( _: Any ) => throw new Exception( "Inserting into ? projection not supported." ) )

    /** Database column USER_ID SqlType(int4) */
    val userId: Rep[ Int ] = column[ Int ]( "USER_ID" )
    /** Database column ROLE_ID SqlType(int4) */
    val roleId: Rep[ Int ] = column[ Int ]( "ROLE_ID" )
    /** Database column ID SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[ Int ] = column[ Int ]( "ID", O.AutoInc, O.PrimaryKey )

    /** Foreign key referencing Roles (database name USERS_ROLES_ROLE_ID_FK) */
    lazy val rolesFk = foreignKey( "USERS_ROLES_ROLE_ID_FK", roleId, Roles )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
    /** Foreign key referencing Users (database name USERS_ROLES_USER_ID_FK) */
    lazy val usersFk = foreignKey( "USERS_ROLES_USER_ID_FK", userId, Users )( r => r.id, onUpdate = ForeignKeyAction.NoAction, onDelete = ForeignKeyAction.NoAction )
  }
  /** Collection-like TableQuery object for table UsersRoles */
  lazy val UsersRoles = new TableQuery( tag => new UsersRoles( tag ) )

  /** Creates schema executing creation sql statements */
  def createSchema = schema.create

  /** Drops schema executing drop sql statements */
  def dropSchema = schema.drop
}
