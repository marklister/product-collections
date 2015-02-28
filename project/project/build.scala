import sbt._

object PluginDef extends Build {
  override def projects = Seq(root)
  lazy val root = Project("plugins", file(".")) dependsOn(boilerplate)
  lazy val boilerplate = uri("https://github.com/marklister/sbt-boilerplate.git#013afd0becf8171c05206e227b2dbe72d98c6344")
}
