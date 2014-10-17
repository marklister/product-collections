##Product Collections
-------------



[![Build Status](https://travis-ci.org/marklister/product-collections.png)](https://travis-ci.org/marklister/product-collections)

###Introduction

**Product-collections** is a Scala collection designed to hold tuples.  Use it to manipulate 
tabular data while retaining type safety and writing idiomatic scala.  Product-collections is minimalistic and 
marries two existing scala constructs: Products, and Collections, in the obvious way.  Product-collections has a very 
neat and type safe CSV reader/parser.
 
###Contents
 
 - [Introduction](#introduction)
 - [Contents](#contents)
 - [Philosophy](#Philosophy)
 - [Sample Project](#sample-project)
 - [Dependency Info](#dependency-info)
 - [Scaladoc](#scaladoc)
 - [REPL Session](#repl-session)
 - [Using CollSeq](#using-collseq)
    - [TLDR;](#tldr)
    - [Create a CollSeq](#create-a-collseq)
    - [Extract columns](#extract-columns)
    - [Extract rows](#extract-rows)
    - [Add a column](#add-a-column)
    - [Access the row 'above'](#access-the-row-above)
    - [Splice columns together](#splice-columns-together)
    - [Map](#map)
    - [Lookup a row](#lookup-a-row)
 - [I/O](#io)
    - [Construct a Parser](#construct-a-parser)
    - [Read and Parse a file](#read-and-parse-a-file)
    - [Read and parse a java.io.Reader](#read-and-parse-a-java.io.reader)
    - [Parsing additional types](#parsing-additional-types)
    - [Field parse errors](#field-parse-errors)
 - [Examples](#examples)
    - [Read Stock prices and calculate moving average](#read-stock-prices-and-calculate-moving-average)
    - [Read csv that has field parse errors](#read-csv-that-has-field-parse-errors)
    - [Calculate an aircraft's moment in in-lb](#calculate-an-aircrafts-moment-in-in-lb)
 - [Architecture](#Architecture)
    - [CollSeq](#CollSeq)
    - [CollSeqN](#CollSeqN)
    - [CsvParser](#CsvParser)
 - [Status](#Status)
 - [Future](#Future)
 - [Unmanaged jar](#Unmanaged-jar)
 - [Build Dependencies](#Build-Dependencies)
 - [Runtime Dependencies](#Runtime-Dependencies)
 - [Pull Requests](#Pull-Requests)
 - [Licence](#Licence)
 - [Alternatives](#Alternatives)
 - [Testimonials](#Testimonials)

###Philosophy
 
The scala collection library has a logic revolving around `zip` and `unzip`.  Product-collections extends that logic
to arities greater than 2 in a logical and consistent way.  `unzip3` and similar methods seem a bit kludgy compared to
`flatZip` and `_1` ... `_N` which perform the same function but in a consistent way across all arities.
 
The addition of these methods makes the standard collection library a viable and very easy to use 2D data framework.

The learning curve is negligible because you simply need to think of the collection either as a tuple of sequences or
a sequence of tuples, whichever you require at the time.
 . 
###Sample Project

See [product-collections-example](https://github.com/marklister/product-collections-example).  The example is about 
25 lines of code; it loads stock prices from csv and plots these prices against the 250 period moving average.


### Dependency Info
To add **product-collections** to your build, for the moment you'll need to add a new repository.

Using SBT:
```scala
     resolvers += "Bintray Repo marklister" at "https://dl.bintray.com/marklister/maven"

     libraryDependencies += "com.github.marklister" %% "product-collections" % "1.0-RC1"
```
Using Maven:
```xml
  <repositories>
    <repository>
      <id>maven</id>
      <url>https://dl.bintray.com/marklister/</url>
    </repository>
  </repositories>
  ...
  <dependency>
    <groupId>com.github.marklister</groupId>
    <artifactId>product-collections_2.10</artifactId>
    <version>1.0-RC1</version>
  </dependency>
```

#### Scaladoc

View the [Scaladoc](http://marklister.github.io/product-collections/target/scala-2.10/api/#com.github.marklister.collections.package).  
The Scaladoc packages contain examples and REPL sessions.  The scaladoc on github is prefered to a locally generated 
variant:  I've used a hacked version of scala to generate it.  If you want a local copy you can clone the gh-pages branch.

#### Repl Session

This document contains fragments of a REPL session which may not be entirely consistent. The [full repl session](https://github.com/marklister/product-collections/blob/master/doc/repl-output.txt) 
is available.  You can reproduce the repl session by pasting the repl source in the doc directory.

###Using CollSeq
#### TLDR;
You already know how to use a product-collection.  Think of a product-collection as a IndexedSequence of homogeneous 
tuples and, at the same time a tuple of Seqences.  There is only one novel feature to learn: [`flatZip`](#add-a-column)

####Create a CollSeq

Let the compiler infer the appropriate implementation:heavier:
```scala
scala> CollSeq(("A",2,3.1),("B",3,4.0),("C",4,5.2))
res1: com.github.marklister.collections.immutable.CollSeq3[String,Int,Double] = 
CollSeq((A,2,3.1),
        (B,3,4.0),
        (C,4,5.2))
```
Notice that the correct types are inferred for each column.  Consistent Tuple length is guaranteed by the compiler.  You 
can't have a CollSeq comprising mixed Product2 and Product3 types for example.

####Extract columns

A CollSeqN is also a ProductN (essentially a Tuple). To extract a column:
```scala
scala> CollSeq(("A",2,3.1),("B",3,4.0),("C",4,5.2))
res0: com.github.marklister.collections.immutable.CollSeq3[String,Int,Double] = 
CollSeq((A,2,3.1),
        (B,3,4.0),
        (C,4,5.2))

scala> res0._1
res1: Seq[String] = List(A, B, C)
```
####Extract rows

CollSeq is an IndexedSeq so you can extract a row in the normal manner:
```scala
scala> res1(1)
res4: Product3[java.lang.String,Int,Int] = (B,3,4)
```
####Add a column

You can use the flatZip method to add a column:
```scala
scala> res1.flatZip(res1._2.map(_ *2))  //double the second column and append the result as a new column.
res14: com.github.marklister.collections.immutable.CollSeq4[String,Int,Double,Int] = 
CollSeq((A,2,3.1,4),
        (B,3,4.0,6),
        (C,4,5.2,8))
```
####Access the row 'above'

Using scala's sliding method you can access the preceeding n rows.  Here we calculate the difference between the values in the 4th column:
```scala
scala> res14._4.sliding(2).toList.map(z=>z(1)-z(0))
res21: List[Int] = List(2, 2)
```
Append the result:
```scala
scala> res14.flatZip(0::res21)
res22: com.github.marklister.collections.immutable.CollSeq5[java.lang.String,Int,Int,Int,Int] = 
(A,2,3,4,0)
(B,3,4,6,2)
(C,4,5,8,2)
```
####Splice columns together

This uses the implicit conversions in the collections package object.
```scala
scala> CollSeq((1,2,3),(2,3,4),(3,4,5))
res0: com.github.marklister.collections.immutable.CollSeq3[Int,Int,Int] = 
CollSeq((1,2,3),
        (2,3,4),
        (3,4,5))

scala> res0._3 flatZip res0._1 flatZip res0._2
res2: com.github.marklister.collections.immutable.CollSeq3[Int,Int,Int] = 
CollSeq((3,1,2),
        (4,2,3),
        (5,3,4))
```
####Map

Map and similar methods (where possible) produce another CollSeq:
```scala
scala> CollSeq((3,1,2),
     |             (4,2,3),
     |             (5,3,4))
res0: com.github.marklister.collections.immutable.CollSeq3[Int,Int,Int] = 
CollSeq((3,1,2),
        (4,2,3),
        (5,3,4))

scala> res0.map(t=>(t._1+1,t._2-1,t._3.toDouble))
res1: com.github.marklister.collections.immutable.CollSeq3[Int,Int,Double] = 
CollSeq((4,0,2.0),
        (5,1,3.0),
        (6,2,4.0))
```
####Lookup a row

You can lookup values by constructing a Map:

```scala
scala> val data= CollSeq(("Zesa",10,20),
     | ("Eskom",5,11),
     | ("Sars",16,13))
data: com.github.marklister.collections.immutable.CollSeq3[String,Int,Int] = 
CollSeq((Zesa,10,20),
        (Eskom,5,11),
        (Sars,16,13))

scala> val lookup= data._1.zip(data).toMap
lookup: scala.collection.immutable.Map[String,Product3[String,Int,Int]] = 
Map(Zesa -> (Zesa,10,20), Eskom -> (Eskom,5,11), Sars -> (Sars,16,13))

scala> lookup("Sars")
res0: Product3[String,Int,Int] = (Sars,16,13)
```            
###I/O

The CsvParser class (and its concrete sub-classes) allow you to easily read CollSeqs from the filesystem.

####Construct a Parser
```scala
scala> val parser=CsvParser[String,Int,Int,Int]
parser: com.github.marklister.collections.io.CsvParser4[String,Int,Int,Int] = com.github.marklister.collections.io.CsvParser4@1203c6e
```
####Read and Parse a file
```scala
scala> parser.parseFile("abil.csv",hasHeader=true,delimiter="\t")
res2: com.github.marklister.collections.immutable.CollSeq4[String,Int,Int,Int] = 
CollSeq((30-APR-12,3885,3922,3859),
        (02-MAY-12,3880,3915,3857),
        (03-MAY-12,3920,3948,3874),
        (04-MAY-12,3909,3952,3885),
        (07-MAY-12,3853,3900,3825),
        (08-MAY-12,3770,3851,3755),
        (09-MAY-12,3700,3782,3666),
        (10-MAY-12,3732,3745,3658),
        (11-MAY-12,3760,3765,3703),
        (14-MAY-12,3660,3750,3655),
        (15-MAY-12,3650,3685,3627),
        (16-MAY-12,3661,3663,3555),
        (17-MAY-12,3620,3690,3600),
        (18-MAY-12,3545,3595,3542),
        (21-MAY-12,3602,3608,3546),
        (22-MAY-12,3650,3675,3615),
        (23-MAY-12,3566,3655,3566),
        (24-MAY-12,3632,3645,3586),
        (25-MAY-12,3610,3665,3583),
        (28-MAY-12,3591,3647,3582),
     ...
```

####Read and parse a java.io.Reader
```scala
scala> val stringData="""10,20,"hello"
     |                   |20,30,"world"""".stripMargin
stringData: String = 
10,20,"hello"
20,30,"world"

scala> CsvParser[Int,Int,String].parse(new java.io.StringReader(stringData))
res6: com.github.marklister.collections.immutable.CollSeq3[Int,Int,String] = 
CollSeq((10,20,hello),
        (20,30,world))
```

####Parsing additional types
To parse additional types (like dates) simply provide a converter as an implicit parameter.  See the examples.

####Field parse errors
To avoid an exception specify your field type as Option[T] where T is Int, Double etc.

###Examples

####Read Stock prices and calculate moving average
An example REPL session.  Let's read some stock prices and calculate the 5 period moving average:

```scala
scala> import java.util.Date
import java.util.Date

scala> implicit val dmy = new DateConverter("dd-MMM-yy")  // tell the parser how to read your dates
dmy: com.github.marklister.collections.io.DateConverter = com.github.marklister.collections.io.DateConverter@26d606

scala> val p=CsvParser[Date,Int,Int,Int,Int]  //Date, close, High, Low, Volume
p: com.github.marklister.collections.io.CsvParser5[java.util.Date,Int,Int,Int,Int] = com.github.marklister.collections.io.CsvParser5@1584d9

scala> val prices=p.parseFile("abil.csv", hasHeader=true, delimiter="\t")
prices: com.github.marklister.collections.immutable.CollSeq5[java.util.Date,Int,Int,Int,Int] = 
(Mon Apr 30 00:00:00 AST 2012,3885,3922,3859,4296459)
(Wed May 02 00:00:00 AST 2012,3880,3915,3857,3127464)
(Thu May 03 00:00:00 AST 2012,3920,3948,3874,3080823)
(Fri May 04 00:00:00 AST 2012,3909,3952,3885,2313354)
(Mon ....

scala> val ma= prices._2.sliding(5).toList.map(_.mean)
ma: List[Double] = List(3889.4, 3866.4, 3830.4, 3792.8, 3763.0, 3724.4, 3700.4, 3692.6, 3670.2, 3627.2, 3615.6, 3615.6, 3596.6, 3599.0, 3612.0, 3609.8, 3605.6, 3611.0, 3611.0, 3606.0, 3614.2, 3612.4, 3629.0, 3634.6, 3659.4, 3661.0, 3657.2, 3645.2, 3628.4, 3616.4, 3632.8, 3668.8, 3702.6, 3745.4, 3781.0, 3779.6, 3755.4, 3727.4, 3689.4, 3650.2, 3638.8, 3641.8, 3648.2, 3663.2, 3671.0, 3649.4, 3624.4, 3595.0, 3559.0, 3518.0, 3505.8, 3495.8, 3505.8, 3531.2, 3570.8, 3589.0, 3613.0, 3620.8, 3624.4, 3635.4, 3661.0, 3667.0, 3686.6, 3703.6, 3720.0, 3722.4, 3692.4, 3619.0, 3553.4, 3473.4, 3413.2, 3400.0, 3422.8, 3427.4, 3433.6, 3434.0, 3425.6, 3403.8, 3396.6, 3388.6, 3376.0, 3353.6, 3318.6, 3291.8, 3260.6, 3240.0, 3225.0, 3226.0, 3218.2, 3232.2, 3219.6, 3226.0, 3234.0, 3251.0, 3271.0, 3312.4, 3341....

scala> prices._1.drop(5).zip(ma) //moving average zipped with date
res0: Seq[(java.util.Date, Double)] = List((Tue May 08 00:00:00 AST 2012,3889.4), (Wed May 09 00:00:00 AST 2012,3866.4), (Thu May 10 00:00:00 AST 2012,3830.4), (Fri May 11 00:00:00 AST 2012,3792.8), (Mon May 14 00:00:00 AST 2012,3763.0), (Tue May 15 00:00:00 AST 2012,3724.4), (Wed May 16 00:00:00 AST 2012,3700.4), (Thu May 17 00:00:00 AST 2012,3692.6), (Fri May 18 00:00:00 AST 2012,3670.2), (Mon May 21 00:00:00 AST 2012,3627.2), (Tue May 22 00:00:00 AST 2012,3615.6), (Wed May 23 00:00:00 AST 2012,3615.6), (Thu May 24 00:00:00 AST 2012,3596.6), (Fri May 25 00:00:00 AST 2012,3599.0), (Mon May 28 00:00:00 AST 2012,3612.0), (Tue May 29 00:00:00 AST 2012,3609.8), (Wed May 30 00:00:00 AST 2012,3605.6), (Thu May 31 00:00:00 AST 2012,3611.0), (Fri Jun 01 00:00:00 AST 2012,3611.0), (Mon Jun 04 0...
scala> 
```

##### Read csv that has field parse errors

Note: this converter is now provided as standard in the distribution.

```scala
scala> import scala.util.Try
import scala.util.Try

scala> implicit object optionIntConverter extends GeneralConverter[Option[Int]]{
 | def convert(x:String)=Try(x.trim.toInt).toOption
 | }

defined module optionIntConverter

scala> CsvParser[String,Option[Int]].parseFile("badly-formed.csv")
res3: com.github.marklister.collections.immutable.CollSeq2[String,Option[Int]] = 
CollSeq((Jan,Some(10)),
        (Feb,None),
        (Mar,Some(25)))
```

#####Calculate an aircraft's moment in in-lb 
```scala
scala> val aircraftLoading=CollSeq(("Row1",86,214),("Row4",168,314),("FwdCargo",204,378)) //Flight Station, Mass kg, Arm in
aircraftLoading: com.github.marklister.collections.immutable.CollSeq3[java.lang.String,Int,Int] = 
(Row1,86,214)
(Row4,168,314)
(FwdCargo,204,378)

scala> val pounds = aircraftLoading._2.map(_ * 2.2)  //convert kg -> lb
pounds: Seq[Double] = List(189.20000000000002, 369.6, 448.8)

scala> val moment = pounds.zip(aircraftLoading._3).map(x=>x._1*x._2)
moment: Seq[Double] = List(40488.8, 116054.40000000001, 169646.4)

scala> moment.sum
res1: Double = 326189.6
```

###Architecture
-------

#####CollSeq
`CollSeq` is a wrapper around `IndexedSeq[Product]`.    `CollSeq` also implements `Product` itself.

#####CollSeqN
`CollSeqN` are concrete implementations of `CollSeq`.  They extend `IndexedSeq[ProductN[T1,..,TN]]` and implement `ProductN`.  `CollSeqN` has only one novel method: ```flatZip (s:Seq[A]): CollSeqN+1[T1,..TN,A]```

#####CsvParser
`CsvParser` is a simple Csv reader/parser that returns a `CollSeqN.` There are concrete parsers implemented for each arity.  The actual gruntwork is done by [opencsv](http://opencsv.sourceforge.net/).

#####Implicit Conversions
```scala
Seq[Product1[T]] => CollSeq1[T]  
Seq[Product2[T1,T2]] => CollSeq2[T1,T2]
Seq[T] => CollSeq1[T]
```

The methods introduced are few: `flatZip` and `_1` ... `_N`.

###Status

Stable.

###Future

In no particular order:

*  Quantify how a Map of Tuples might be useful.
*  A Proper Stats implementation preferably as a library dependancy.
*  Missing values, NAs etc.
*  How to incorporate classes that implement ProductN (future case classes).
*  Column access by named method (using macros?)  

###Unmanaged jar

[Scala-2.10](http://marklister.github.io/product-collections/org/catch22/product-collections_2.10/0.0.4.4-SNAPSHOT/product-collections_2.10-0.0.4.4-SNAPSHOT.jar) or [Scala-2.11.0](http://marklister.github.io/product-collections/org/catch22/product-collections_2.11.0/0.0.4.4-SNAPSHOT/product-collections_2.11.0-0.0.4.4-SNAPSHOT.jar) or [Scala-2.9.2](http://marklister.github.io/product-collections/org/catch22/product-collections_2.9.2/0.0.4-SNAPSHOT/product-collections_2.9.2-0.0.4-SNAPSHOT.jar)


###Build Dependencies

**product-collections** relies heavily on [sbt-boilerplate](https://github.com/sbt/sbt-boilerplate).  **sbt-boilerplate** is a cleverly designed yet simple code generating sbt-plugin.

###Runtime Dependencies

 - [opencsv](http://opencsv.sourceforge.net/) (Apache 2 licence).  Thanks [opencsv team](http://opencsv.sourceforge.net/#who-maintains)


###Pull Requests

Pull requests are welcome.  Please keep in mind the KISS character if you extend the project.  Feel free to discuss your ideas on the issue tracker.

###Licence

[Two clause BSD Licence.](LICENSE)

###Alternatives

Product-collections is around 400 lines of code (before template expansion).  The alternatives are substantially 
larger and have far more features.

[Shapeless](https://github.com/milessabin/shapeless)

HLists are similar in concept.  Shapeless allows one to abstract over arity.

[Saddle](http://saddle.github.io/)

Backed by arrays.  Heavily specialized.  Matrix operations.

[Framian](https://github.com/pellucidanalytics/framian)

Simple abstractions for working with ordered series data (eg. time series), as well as heterogeneous data tables (similar to R's data frame). Based on Spire and Shapeless.

With Framian you specify the data type at retrieval time.

###Testimonials

<blockquote>The brilliance of [product-collections] is the tight focus on being really good at one or two things, which, in my opinion, includes not just the powerful type-safe column- and row-oriented operations, but the extensible use of implicit string converters. ....

 ... In product-collections you've hit the ultimate sweet-spot from an idiomatic Scala point of view."</blockquote>

Simeon H.K. Fitch, Director of Software Engineering, Elder Research, Inc.
