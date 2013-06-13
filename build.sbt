import SiteKeys._

Boilerplate.settings

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "1.12.3" % "test",
    "org.scalacheck" %% "scalacheck" % "1.10.0" % "test",
    "junit" % "junit" % "4.7" % "test",
    "net.sf.opencsv" % "opencsv" % "2.0"
)

scalaVersion:="2.10.1"

crossScalaVersions := Seq("2.9.2", "2.10.1")

version := "0.0.4.2-SNAPSHOT"

name := "product-collections"

organization :="org.catch22"

publishTo := Some(Resolver.file("file", new File("src/site")))

initialCommands in console := """
  import org.catch22.collections.io._
  import org.catch22.collections._
  """

site.settings

ghpages.settings

git.remoteRepo := "git@github.com:marklister/product-collections.git"

includeFilter in makeSite  ~= { f => f ||    "*.jar" || "*"}