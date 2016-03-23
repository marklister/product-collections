/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

import utest._
import com.github.marklister.collections.io._
import com.github.marklister.collections._

object IOSuite extends TestSuite {

  case class Foo(a: Int, b: Int, c: Int)

  case class FooOption(a: Int, b: Int, c: Option[Int])

  val testData = """10,20,30
                   |20,30,40""".stripMargin

  val testData2 = """10,20,
                    |20,30,40""".stripMargin

  val testData3 =
    """a,b,c
                     |10,20,30
                     |30,40,50""".stripMargin

  def r = new java.io.

  StringReader(testData)
  def r2 = new java.io.

  StringReader(testData2)
  def r3 = new java.io.StringReader(testData3)

  val result = CsvParser[Int, Int, Int].parse(r)
  val result2 = CsvParser[Int, Int, Option[Int]].parse(r2)
  val result3 = CsvParser(Foo).parse(r)
  val result4 = CsvParser(FooOption).parse(r2)

  val tests = TestSuite{
    'ParseTestData {
      assert(result == CollSeq((10, 20, 30), (20, 30, 40)))
    }
    'ParseTestData2 {
      assert(result2 == CollSeq((10, 20, None), (20, 30, Some(40))))
    }
    'TestData2Iterator {
      assert(CsvParser[Int, Int, Option[Int]].iterator(new java.io.StringReader(testData2)).next() ==(10, 20, None))

    }

    'CsvIterator {
      assert(result.csvIterator.next == testData.split("\n")(0))
    }

    'ParseFunction3 {
      assert(result3 == List(Foo(10,20,30),Foo(20,30,40)))
    }

    'ParseFunction4 {
      assert(result4 == List(FooOption(10,20, None),FooOption(20,30,Some(40))))
    }


    'WriteCsv {
      val w = new java.io.StringWriter
      result.writeCsv(w)
      w.close
      assert(w.toString.replaceAll("\r", "").replaceAll("\n", "") == testData.replaceAll("\n", ""))
    }

    'writeCsv2 {
      val w = new java.io.StringWriter
      result2.writeCsv(w)
      w.close
      assert(w.toString.replaceAll("\r", "").replaceAll("\n", "") == testData2.replaceAll("\n", ""))
    }


    'SingleQuoteRenderer {

      assert(Seq(Tuple1("hello")).csvIterator(renderer = Utils.singleQuoteRenderer).toList == List("'hello'"))

    }
    'SingleQuoteRenderer {


      assert(Seq(Tuple1("hello 'quoted' stuff")).csvIterator(renderer = Utils.singleQuoteRenderer).toList == List("'hello ''quoted'' stuff'"))

    }
    'NaRenderer {

      assert(Seq(Tuple1(None)).csvIterator(renderer = Utils.naRenderer).toList == List("NA"))
    }
    'ParseWithHeaders{
        val h = CsvParser[Int,Int,Int].parse(r3,hasHeader=true)
        assert (h.length == 2)
        assert (h.headers == Seq("a","b","c"))
        assert (h.collMap("a") == Seq(10,30))
        assert (h._2 == Seq(20,40))
      }

}
  }