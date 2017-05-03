import spray.boilerplate.BoilerplatePlugin._

name := "product-collections"

lazy val root = project.in(file(".")).
  aggregate(productCollectionsJS, productCollectionsJVM).
  settings(
    publish := {},
    publishLocal := {},
    crossScalaVersions := Seq("2.11.8", "2.10.6", "2.12.0")
)


lazy val pc = crossProject.in(file(".")).
  settings(
    libraryDependencies += "com.lihaoyi" %%% "utest" % "0.4.4" % Test,
    testFrameworks += new TestFramework("utest.runner.Framework"),
    crossScalaVersions := Seq("2.11.8", "2.10.6", "2.12.0"),
    sourceDirectories in Compile += new File("./shared/src/"),
    name := "product-collections",
    organization :="com.github.marklister",
    version := "1.4.5",
    scalaVersion := "2.12.0",
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
    scalacOptions in (Compile, doc) ++= Seq("-implicits"),
    boilerplateSource in Compile := baseDirectory.value.getParentFile / "shared" / "src" / "main" / "boilerplate"
  )
  //.settings(bintraySettings:_*)  //REMOVE FROM PUBLISHED build.sbt

  .jvmSettings(
       initialCommands in console := """
  import com.github.marklister.collections.io._
  import com.github.marklister.collections._
                                  """
  )
  .jsSettings(

  )

lazy val productCollectionsJVM = pc.jvm.enablePlugins(spray.boilerplate.BoilerplatePlugin)
lazy val productCollectionsJS = pc.js.enablePlugins(spray.boilerplate.BoilerplatePlugin)
