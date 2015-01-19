/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

import utest._
import utest.ExecutionContext.RunNow
import com.github.marklister.collections.io._
import com.github.marklister.collections._

object IOSuite extends TestSuite {

  val testData = """10,20,30
                   |20,30,40""".stripMargin

  val testData2 = """10,20,
                    |20,30,40""".stripMargin


  val r = new java.io.StringReader(testData)
  val r2 = new java.io.StringReader(testData2)

  val result = CsvParser[Int, Int, Int].parse(r)
  val result2 = CsvParser[Int, Int, Option[Int]].parse(r2)

  val tests = TestSuite{
    'ParseTestData {
      result == CollSeq((10, 20, 30), (20, 30, 40))
    }
    'ParseTestData2 {
      result2 == CollSeq((10, 20, None), (20, 30, Some(40)))
    }
    'TestData2Iterator {
      CsvParser[Int, Int, Option[Int]].iterator(new java.io.StringReader(testData2)).next() ==(10, 20, None)

    }

    'CsvIterator {
      result.csvIterator.next == testData.split("\n")(0)
    }


    'WriteCsv {
      val w = new java.io.StringWriter
      result.writeCsv(w)
      w.close
      w.toString.replaceAll("\r", "").replaceAll("\n", "") == testData.replaceAll("\n", "")
    }

    'writeCsv2 {
      val w = new java.io.StringWriter
      result2.writeCsv(w)
      w.close
      w.toString.replaceAll("\r", "").replaceAll("\n", "") == testData2.replaceAll("\n", "")
    }


    'SingleQuoteRenderer {

      Seq(Tuple1("hello")).csvIterator(renderer = Utils.singleQuoteRenderer).toList == List("'hello'")

    }
    'SingleQuoteRenderer {


      Seq(Tuple1("hello 'quoted' stuff")).csvIterator(renderer = Utils.singleQuoteRenderer).toList == List("'hello ''quoted'' stuff'")

    }
    'NaRenderer {

      Seq(Tuple1(None)).csvIterator(renderer = Utils.naRenderer).toList == List("NA")
    }
  }
}