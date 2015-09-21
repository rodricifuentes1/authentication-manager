import sbt._

object Dependencies {

  /**
  * Defines repository resolvers
  */
  val resolvers = Seq(
    "jBCrypt releases" at "http://repo1.maven.org/maven2/org/",
    "RoundEights releases" at "http://maven.spikemark.net/roundeights",
    "Scalaz releases" at "http://dl.bintray.com/scalaz/releases",
    "Sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
    "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
    "Typesafe releases" at "http://repo.typesafe.com/typesafe/releases/",
    Resolver.bintrayRepo("rodricifuentes1", "RC-releases")
  )

  // -----------------------------------
  // VERSIONS
  // -----------------------------------

  // co.rc
  val tokenManagerVersion: String = "1.0"
  val smServiceClientVersion: String = "1.0"

  // Logging
  val logbackVersion: String = "1.1.3"
  val scalaloggingVersion: String = "3.1.0"

  // Utils
  val ficusVersion: String = "1.1.2"
  val nScalaTimeVersion: String = "2.2.0"
  val scalazVersion: String = "7.1.3"
  val scalaCacheVersion: String = "0.6.4"
  
  // Persistence
  val slickVersion: String = "3.0.3"
  val slickPostgresVersion: String = "0.9.1"
  val activeSlickVersion: String = "0.3.1"
  val postgresVersion: String = "9.4-1202-jdbc42"
  val h2DatabaseVersion: String = "1.4.189"
  val hikariCPVersion: String = "2.4.1"

  // Crypto
  val hasherVersion: String = "1.2.0"
  val jbcryptVersion: String = "0.3m"

  // Testing
  val specs2Version: String = "3.6.4"
  

  // -----------------------------------
  // DEPENDENCIES
  // -----------------------------------
  val all = Seq(
    "co.rc" %% "token-manager" % tokenManagerVersion,
    "co.rc" %% "session-manager-service-client" % tokenManagerVersion,

    "ch.qos.logback" % "logback-classic" % logbackVersion,
    "com.typesafe.scala-logging" %% "scala-logging" % scalaloggingVersion,

    "net.ceedubs" %% "ficus" % ficusVersion,
    "com.github.nscala-time" %% "nscala-time" % nScalaTimeVersion,
    "org.scalaz" %% "scalaz-core" % scalazVersion,
    "com.github.cb372" %% "scalacache-lrumap" % scalaCacheVersion,

    "com.typesafe.slick" %% "slick" % slickVersion,
    "com.typesafe.slick" %% "slick-codegen" % slickVersion,
    "com.github.tminglei" %% "slick-pg" % slickPostgresVersion,
    "io.strongtyped" %% "active-slick" % activeSlickVersion,
    "org.postgresql" % "postgresql" % postgresVersion,
    "com.h2database" % "h2" % h2DatabaseVersion,
    "com.zaxxer" % "HikariCP" % hikariCPVersion,

    "com.roundeights" %% "hasher" % hasherVersion,
    "org.mindrot" % "jbcrypt" % jbcryptVersion,

    "org.specs2" %% "specs2-core" % specs2Version % "test"
  )

}
