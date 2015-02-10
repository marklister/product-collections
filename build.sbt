import spray.boilerplate.BoilerplatePlugin._
import spray.boilerplate.BoilerplatePlugin.Boilerplate._

name := "product-collections"

lazy val root = project.in(file(".")).
  aggregate(productCollectionsJS, productCollectionsJVM).
  settings(
    publish := {},
    publishLocal := {},
    crossScalaVersions := Seq("2.11.5", "2.10.4")


)

lazy val pc = crossProject.in(file(".")).
  settings(
    libraryDependencies += "com.lihaoyi" %%% "utest" % "0.3.0",
    testFrameworks += new TestFramework("utest.runner.Framework"),
    scalaVersion := "2.11.5",
    crossScalaVersions := Seq("2.11.5", "2.10.4"),
    sourceDirectories in Compile += new File("./shared/src/"),
    name := "product-collections",
    organization :="com.github.marklister",
    version := "v1.3.0",
    scalaVersion := "2.11.5",
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
  ).settings(Boilerplate.settings: _ *)
  //.settings(bintraySettings:_*)  //REMOVE FROM PUBLISHED build.sbt

  .jvmSettings(
    libraryDependencies ++= Seq("net.sf.opencsv" % "opencsv" % "2.3"),
    initialCommands in console := """
  import com.github.marklister.collections.io._
  import com.github.marklister.collections._
                                  """
  )
  .jsSettings(

  )

lazy val productCollectionsJVM = pc.jvm
lazy val productCollectionsJS = pc.js
