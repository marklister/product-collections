Boilerplate.settings

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
     "org.specs2" %% "specs2" % "1.12.3" % "test",
    "org.scalacheck" %% "scalacheck" % "1.10.0" % "test",
    "junit" % "junit" % "4.7" % "test"
)

//scalaVersion:="2.10.1"

version := "0.0.1-SNAPSHOT"

name := "product-collections"

organization :="org.catch22"

initialCommands in console := """
  import org.catch22.collections.immutable._
  import org.catch22.collections.io
  import org.catch22.collections.util._
  import org.catch22.collections.util.Stats._"""

