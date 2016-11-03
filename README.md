#Product-collections

[![Build Status](https://travis-ci.org/marklister/product-collections.png)](https://travis-ci.org/marklister/product-collections)
[![Join the chat at https://gitter.im/marklister/product-collections](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/marklister/product-collections?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

# Quickstart

Using SBT:
     `libraryDependencies += "com.github.marklister" %% "product-collections" % "1.4.5"`
or for scala-js
     `libraryDependencies += "com.github.marklister" %%% "product-collections" % "1.4.5"`

#Documentation

Documentation for current version 1.4.3 has been moved to the [wiki](https://github.com/marklister/product-collections/wiki)  For legacy version v1.3.0 the [old Readme](https://github.com/marklister/product-collections/blob/master/README-old.md) is the correct documentation.

Product-collections is a 2D data manipulation library based on standard scala collections.  Product-collections is also a
strongly typed CSV I/O library that will read a Seq of case classes, tuples or a CollSeq for you, or serialize any of
these structures to CSV.

The data component presents a logical and consistent paradigm to replace the messy and incomplete zip3 and unzip3
scala constructs and operates with arities 1 - 22.

As of version 1.3.0 product-collections is cross-compiled for scala-js and scala-jvm.

[Scaladoc-jvm](http://marklister.github.io/product-collections/jvm/target/scala-2.11/api/#com.github.marklister.collections.package)


[Scaladoc-js](http://marklister.github.io/product-collections/js/target/scala-2.11/api/#com.github.marklister.collections.package) 
