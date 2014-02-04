/*
 * product-collections is distributed under the 2-Clause BSD license. See the 
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 Mark Lister
 */

package org.catch22
import collections.immutable.{CollSeq1,CollSeq2}
import collections.util.{Stats,WeightedStats}
//import scala.language.implicitConversions //scala 2.9.2 doesn't like this

/**
 * ==A strongly typed tabular data framework.==
 *
 *  Note: Due to a bug in sbt-boilerplate some of the details in this
 *  Scaladoc are inaccurate.  If something doesn't make sense please
 *  look at the full repl session on github.
 * 
 *  [[collections.CollSeq]] is an IndexedSeq[Product] that also implements
 *  Product itself.  
 *  
 *  Specialized versions of CollSeq exist for arities 1 to 22.  Each is an 
 *  IndexedSeq[ProductN] and also implements ProductN
 *  
 *  ===In action===
 *  {{{import org.catch22.collections.io._
 *  import org.catch22.collections._
 *  Welcome to Scala version 2.10.1 (OpenJDK Server VM, Java 1.7.0_21).
 *  Type in expressions to have them evaluated.
 *  Type :help for more information.
 *  
 *  scala> CollSeq(("Jan",10,20),("Feb",33,44),("Mar",77,33))
 *  res0: org.catch22.collections.immutable.CollSeq3[String,Int,Int] = 
 *  CollSeq((Jan,10,20),
 *          (Feb,33,44),
 *          (Mar,77,33))
 * 
 *  scala> //Extract column one
 *  
 *  scala> res0._1
 *  res1: Seq[String] = List(Jan, Feb, Mar)
 *  
 *  scala> //Join Column one and column 3 as a new collection:
 *  
 *  scala> res0._1 flatZip res0._3
 *  res2: org.catch22.collections.immutable.CollSeq2[String,Int] = 
 *  CollSeq((Jan,20),
 *          (Feb,44),
 *          (Mar,33))}}}
 *  
 *  ===I/O===
 *  
 *  [[io.CsvParser]] is a very easy way to read CollSeqs from the File System.
 *  
 *  You use the factory to select a parser:
 *  
 *  {{{val parser= CsvParser[String, Int, Double]}}}
 *  
 *  and read your file like this:
 *  
 *  {{{val data= parser.parseFile("example.csv")}}}
 *  
 *  You wind up with CollSeq3[String,Int,Double]
 *  
 *  ===Positioning===
 *  
 *  product-collections aims to be simple and productive:  you should be 
 *  producing answers from your data in 20 minutes or less.  There is no 
 *  new api to learn -- everything works like a scala collection and a Tuple
 *  at the same time.  There's no matrix arithmetic: do everything in idomatic 
 *  scala.  
 *  
 *  Columns don't lose their type if you include a column of another type.  
 *  '
 *  Learn by example: take a look (or clone) the 
 *  simple example project on Gitub that does some simple processing of 
 *  stock prices.
 *  
 *  ===Alternatives===
 *  
 *  ====Saddle====
 *  A heavy duty solution.  Custom api based around Vectors 
 *  Matrixes and Scalars.  Trying to mix types in a Saddle matrix results in
 *  a Matrix[Any] which means not much type safety.  Saddle seems to
 *  have garnered some support from Typesafe and may feature in GSOC.
 *  
 *  Saddle has heavy emphasis on specialization and (presumably) performance.
 *  
 *  ====Breeze====
 *  
 *  Breeze also has matrix and vector implementations similar to Saddle.  Also 
 *  some other stuff that looks pretty useful.
 *  
 */
package object collections {
  
  //--------------------------Type aliases---------------------------------//

  type CollSeq=immutable.CollSeq
  val CollSeq=immutable.CollSeq
  type CollSeq1[T1]=immutable.CollSeq1[T1] 
  val CollSeq1=immutable.CollSeq1
  type CollSeq2[T1, T2]=immutable.CollSeq2[T1, T2] 
  val CollSeq2=immutable.CollSeq2
  type CollSeq3[T1, T2, T3]=immutable.CollSeq3[T1, T2, T3] 
  val CollSeq3=immutable.CollSeq3
  type CollSeq4[T1, T2, T3, T4]=immutable.CollSeq4[T1, T2, T3, T4] 
  val CollSeq4=immutable.CollSeq4
  type CollSeq5[T1, T2, T3, T4, T5]=immutable.CollSeq5[T1, T2, T3, T4, T5] 
  val CollSeq5=immutable.CollSeq5
  type CollSeq6[T1, T2, T3, T4, T5, T6]=immutable.CollSeq6[T1, T2, T3, T4, T5, T6] 
  val CollSeq6=immutable.CollSeq6
  type CollSeq7[T1, T2, T3, T4, T5, T6, T7]=immutable.CollSeq7[T1, T2, T3, T4, T5, T6, T7] 
  val CollSeq7=immutable.CollSeq7
  type CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8]=immutable.CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8] 
  val CollSeq8=immutable.CollSeq8
  type CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9]=immutable.CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9] 
  val CollSeq9=immutable.CollSeq9
  type CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]=immutable.CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] 
  val CollSeq10=immutable.CollSeq10
  type CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]=immutable.CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] 
  val CollSeq11=immutable.CollSeq11
  type CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]=immutable.CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] 
  val CollSeq12=immutable.CollSeq12
  type CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]=immutable.CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] 
  val CollSeq13=immutable.CollSeq13
  type CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]=immutable.CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] 
  val CollSeq14=immutable.CollSeq14
  type CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]=immutable.CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] 
  val CollSeq15=immutable.CollSeq15
  type CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]=immutable.CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] 
  val CollSeq16=immutable.CollSeq16
  type CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]=immutable.CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] 
  val CollSeq17=immutable.CollSeq17
  type CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]=immutable.CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] 
  val CollSeq18=immutable.CollSeq18
  type CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]=immutable.CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] 
  val CollSeq19=immutable.CollSeq19
  type CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]=immutable.CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] 
  val CollSeq20=immutable.CollSeq20
  type CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]=immutable.CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] 
  val CollSeq21=immutable.CollSeq21
  type CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]=immutable.CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] 
  val CollSeq22=immutable.CollSeq22

  /**Convert a Seq[Product1] to a CollSeq1*/
  implicit def SeqToCollSeqTa[T](s:Seq[Product1[T]]):CollSeq1[T]=
    immutable.CollSeq1[T](s)
  
  /**Convert a Seq[Product2] to a CollSeq2*/
  implicit def SeqToCollSeqTb[Ta,Tb](s:Seq[Product2[Ta,Tb]]):CollSeq2[Ta,Tb]=
    immutable.CollSeq2[Ta,Tb](s)
  
  /**Convert a Seq[Any] to a CollSeq*/
  implicit def SeqToCollSeqTc[T](s:Seq[T]):CollSeq1[T]=
    immutable.CollSeq1(s.map(Tuple1[T](_)))
  
  
  
  /**Convert a Seq[Numeric] to a Stats object*/
  implicit def SeqAToStatsA[A](s:Iterable[A])(implicit num:Numeric[A])= new Stats[A](s)
  
  /**Convert a Seq[(Numeric,Numeric)] to a WeightedStats object*/
  implicit def SeqABToWeightedStatsAB[A,B](s:Iterable[Product2[A,B]])(implicit numA:Numeric[A], numB:Numeric[B])= new WeightedStats[A,B](s)



}