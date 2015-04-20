import spray.boilerplate.BoilerplatePlugin._
import spray.boilerplate.BoilerplatePlugin.Boilerplate._

name := "product-collections"

lazy val root = project.in(file(".")).
  aggregate(productCollectionsJS, productCollectionsJVM).
  settings(
    publish := {},
    publishLocal := {},
    crossScalaVersions := Seq("2.11.6", "2.10.4")
)

/**
 * Project for macroses
 */
lazy val macs = crossProject.in(file("macs")).settings(
  scalaVersion := "2.11.6",
  name := "macs",
  version := "0.1",
  crossScalaVersions := Seq("2.11.6", "2.10.4"),
  resolvers += Resolver.sonatypeRepo("releases"),
  libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)
)

lazy val macrosesJVM = macs.jvm
lazy val macrosesJS = macs.js

lazy val pc = crossProject.in(file(".")).
  settings(
    libraryDependencies += "com.lihaoyi" %%% "utest" % "0.3.0",
    testFrameworks += new TestFramework("utest.runner.Framework"),
    scalaVersion := "2.11.6",
    crossScalaVersions := Seq("2.11.6", "2.10.4"),
    sourceDirectories in Compile += new File("./shared/src/"),
    name := "product-collections",
    organization :="com.github.marklister",
    version := "1.4.0",
    scalaVersion := "2.11.6",
    homepage := Some(url("https://github.com/marklister/product-collections")),
    startYear := Some(2013),
    description := "Lightweight 2D Data framework.  Strongly typed CSV I/O.  Statistics.",
    licenses += ("BSD Simplified", url("http://opensource.org/licenses/BSD-SIMPLIFIED")),
    pomExtra := (
      <scm>
        <url>git@github.com:marklister/product-collections.git</url>
        <connection>scm:git:git@github.com:marklister/product-collections.git</connection>
      </scm>
        <developers>
          <developer>
            <id>marklister</id>
            <name>Mark Lister</name>
            <url>https://github.com/marklister</url>
          </developer>
        </developers>),
    scalacOptions in (Compile, doc) ++= Opts.doc.title("product-collections"),
    apiURL := Some(url("http://marklister.github.io/product-collections/target/scala-2.11/api/")),
    scalacOptions in (Compile, doc) ++= Seq("-implicits")
  ).settings(Boilerplate.settings: _ *).dependsOn(macs)
  //.settings(bintraySettings:_*)  //REMOVE FROM PUBLISHED build.sbt
  .jvmSettings(
    libraryDependencies ++= Seq("net.sf.opencsv" % "opencsv" % "2.3"),
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full),
    initialCommands in console := """
  import com.github.marklister.collections.io._
  import com.github.marklister.collections._
                                  """
  )
  .jsSettings(
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)
  )

lazy val productCollectionsJVM = pc.jvm
lazy val productCollectionsJS = pc.js
