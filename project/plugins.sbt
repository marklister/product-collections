//resolvers += Resolver.file("Local repo", file("/home/mark/.ivy2/local"))(Resolver.ivyStylePatterns)

resolvers += "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"

resolvers += "sbt-plugin-releases" at "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"

resolvers += "sbt-plugin-snapshots" at "http://repo.scala-sbt.org/scalasbt/plugins-snapshots/scalasbt/sbt-plugin-snapshots/"

//addSbtPlugin("com.typesafe.sbt" % "sbt-pgp" % "0.8")

//addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.1.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.8.4")

addSbtPlugin("io.spray" % "sbt-boilerplate" % "0.5.1") //alternatively we use the source in git see project/project/build.scala

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "0.6.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.5.1")
