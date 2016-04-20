name := "sillycat-tool"

version := "1.0"

organization := "com.sillycat"

scalaVersion := "2.10.4"

libraryDependencies ++= List(
  "org.slf4j" % "slf4j-api" % "1.7.12" % "provided",
  "org.slf4j" % "slf4j-log4j12" % "1.7.12",
  "com.typesafe" % "config" % "1.3.0",                        // Apache v2
  "org.scalatest" %% "scalatest" % "2.2.0" % "test",          // Apache v2
  "org.mockito" % "mockito-all" % "1.9.5" % "test"            // MIT
)
