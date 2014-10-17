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

scalaVersion:="2.11.2"

crossScalaVersions := Seq("2.10.4", "2.11.2")

scalacOptions ++= Seq("-deprecation", "-feature")

version := "0.0.5-SNAPSHOT"

name := "product-collections"

organization :="com.github.marklister"

publishTo := Some(Resolver.file("file", new File("src/site")))

initialCommands in console := """
  import com.github.marklister.collections.io._
  import com.github.marklister.collections._
  """

//site.settings

//ghpages.settings

//git.remoteRepo := "git@github.com:marklister/product-collections.git"

//includeFilter in makeSite  ~= { f => f ||    "*.jar" || "*"}

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

resolvers += "ibiblio-maven-mirror" at "http://mirrors.ibiblio.org"
