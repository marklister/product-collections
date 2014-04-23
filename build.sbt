//import SiteKeys._

Boilerplate.settings

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
    /*"org.specs2" %% "specs2" % "1.14" % "test",*/
      "org.specs2" %% "specs2" % "2.3.11"% "test",
    "org.scalacheck" %% "scalacheck" % "1.10.0" % "test",
    "junit" % "junit" % "4.7" % "test"    
)

libraryDependencies ++= Seq("net.sf.opencsv" % "opencsv" % "2.3")

scalaVersion:="2.10.3"

crossScalaVersions := Seq("2.10.3", "2.11.0")

version := "0.0.4.4-SNAPSHOT"

name := "product-collections"

organization :="org.catch22"

publishTo := Some(Resolver.file("file", new File("src/site")))

initialCommands in console := """
  import org.catch22.collections.io._
  import org.catch22.collections._
  """

//site.settings

//ghpages.settings

//git.remoteRepo := "git@github.com:marklister/product-collections.git"

//includeFilter in makeSite  ~= { f => f ||    "*.jar" || "*"}

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

resolvers += "ibiblio-maven-mirror" at "http://mirrors.ibiblio.org"
