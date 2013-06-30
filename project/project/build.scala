import sbt._
object PluginDef extends Build {
	override lazy val projects = Seq(root)
	lazy val root = Project("plugins", file(".")) dependsOn( webPlugin )
	lazy val webPlugin = uri("git://github.com/marklister/sbt-boilerplate.git#v0.5.2")
}
