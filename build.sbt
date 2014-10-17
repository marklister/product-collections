//import SiteKeys._

Boilerplate.settings

libraryDependencies ++= Seq(
      "org.specs2" %% "specs2" % "2.3.11"% "test"
)

libraryDependencies ++= Seq("net.sf.opencsv" % "opencsv" % "2.3")

scalaVersion:="2.11.2"

crossScalaVersions := Seq("2.10.4", "2.11.2")

scalacOptions ++= Seq("-deprecation", "-feature")

version := "1.0-RC1"

name := "product-collections"

organization :="com.github.marklister"

publishTo := Some(Resolver.file("file", new File("src/site")))

initialCommands in console := """
  import com.github.marklister.collections.io._
  import com.github.marklister.collections._
  """

