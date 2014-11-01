/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

import org.specs2.mutable._
import com.github.marklister.collections.io._
import com.github.marklister.collections._

class IOSpec extends Specification {

  val testData = """10,20,30
                   |20,30,40""".stripMargin

  val testData2 = """10,20,
                    |20,30,40""".stripMargin


  val r = new java.io.StringReader(testData)
  val r2 = new java.io.StringReader(testData2)

  val result = CsvParser[Int, Int, Int].parse(r)
  val result2 = CsvParser[Int, Int, Option[Int]].parse(r2)

  "Parse of testData" should {
    "equal CollSeq3((10,20,30),(20,30,40))" in {
      result must_== CollSeq((10, 20, 30), (20, 30, 40))
    }
  }
  "Parse of testData2" should {
    "equal CollSeq3((10,20,None),(20,30,Some(40)))" in {
      result2 must_== CollSeq((10, 20, None), (20, 30, Some(40)))
    }
  }
  "Iterator testData2" should {
    "equal (10,20,None)" in {
      CsvParser[Int,Int,Option[Int]].iterator(new java.io.StringReader(testData2)).next() must_== (10, 20, None)
    }
  }

  "csvIterator" should {
    "equal testData head" in {
      result.csvIterator.next must_== testData.split("\n")(0)
    }
  }


  "writeCsv" should {
    val w= new java.io.StringWriter
    "equal testData" in {
      result.writeCsv(w)
      w.close
      w.toString.replaceAll("\r","").replaceAll("\n","") must_== testData.replaceAll("\n","")
    }
  }

  "writeCsv" should {
    val w= new java.io.StringWriter
    "equal testData2" in {
      result2.writeCsv(w)
      w.close
      w.toString.replaceAll("\r","").replaceAll("\n","") must_== testData2.replaceAll("\n","")
    }
  }
}