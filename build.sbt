organization := "co.rc"

name := "authentication-manager"

scalaVersion := "2.11.7"

description := "Generic purpose authentication manager"

resolvers ++= Dependencies.resolvers

libraryDependencies ++= Dependencies.all

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)