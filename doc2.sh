mkdir target/scala-2.10/api
cd target/scala-2.10/api
/home/mark/scalaProjects/scala/dists/latest/bin/scaladoc -feature ../../../src/main/scala/collections/*.scala ../../../src/main/scala/collections/io/*.scala  ../../../src/main/scala/collections/immutable/*.scala ../../../src/main/scala/collections/util/*.scala  ../../../target/scala-2.10/src_managed/main/collections/io/*.scala ../../../target/scala-2.10/src_managed/main/collections/immutable/*.scala
cd ../../..