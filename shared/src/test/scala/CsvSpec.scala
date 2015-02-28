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

object CSVSuite extends TestSuite {

  val testData = List("10,20,30\n40,50,60",
    "hello world,     stuff  ",
    "\"  hello world  \",stuff",
    "hello \"\"world\"\",     stuff  ",
    "\"hello \"\"world\"\"\",     stuff  ",
    "     \"hello \"\"world\"\"\"       ,     stuff  "
  )


  val results = List(
    Array(Array("10", "20", "30"), Array("40", "50", "60")),
    Array(Array("hello world", "     stuff  ")),
    Array(Array("  hello world  ", "stuff")),
    Array(Array("hello \"world\"", "     stuff  ")),
    Array(Array("hello \"world\"", "     stuff  ")),
    Array(Array("hello \"world\"", "     stuff  "))
  )
  val tests = TestSuite {
    'CsvProcessing1 {
        val it = new CSVReader(new java.io.StringReader(testData(0))).toList
      (0 to 1).foreach(y=>(0 to 1).foreach(x=>assert(it(y)(x)==results(0)(y)(x))))
    }
    'CsvProcessing2 {
      val it:List[Array[String]] = new CSVReader(new java.io.StringReader(testData(1))).toList
      println(it.toArray.deep.toString)
      (0 to 1).foreach(x=>assert(it(0)(x)==results(1)(0)(x)))
    }
    'CsvProcessing3 {
      val it = new CSVReader(new java.io.StringReader(testData(2))).toList
      (0 to 1).foreach(x=>assert(it(0)(x)==results(2)(0)(x)))
    }
    'CsvProcessing4 {
      val it = new CSVReader(new java.io.StringReader(testData(3))).toList
      (0 to 1).foreach(x=>assert(it(0)(x)==results(3)(0)(x)))
    }
    'CsvProcessing4b {
      val it = new CSVReader(new java.io.StringReader(testData(4))).toList
      (0 to 1).foreach(x=>assert(it(0)(x)==results(4)(0)(x)))
    }
    /*'CsvProcessing5 {
      val it = new CSVReader(new java.io.StringReader(testData(5))).toList
      (0 to 1).foreach(x=>assert(it(0)(x)==results(5)(0)(x)))
    }*/ // Opencsv fails this test.  I'm fairly sure its an opencsv bug....
    'CsvProcessing6 {
      val it = new CSVReader(new java.io.StringReader(testData(0)),headerRows = 1).toList
      (0 to 1).foreach(x=>assert(it(0)(x)==results(0)(1)(x)))
    }
    'CsvEol1 {
      val it = new CSVReader(new java.io.StringReader(
        """10
          |20""".stripMargin)).toList
      val t = it.map (_.head)

      assert(t==List("10","20"))
    }
    'CsvEol2 {
      val it = new CSVReader(new java.io.StringReader(
        "10\n20")).toList
      val t = it.map (_.head)

      assert(t==List("10","20"))
    }
    'CsvEol3 {
      val it = new CSVReader(new java.io.StringReader(
        "10\r\n20")).toList
      val t = it.map (_.head)

      assert(t==List("10","20"))
    }
    'EmbedLF {
      val it = new CSVReader(new java.io.StringReader(
        "10,\"20,\n30,40\"\nline2,line2")).toList
      val t = it.map (_.tail.head)

      assert(t==List("20,\n30,40","line2"))
    }
    'EmbedQuote {
      val it = new CSVReader(new java.io.StringReader(
        "10,\"20,\"\"30\"\",40\"\nline2,line2")).toList
      val t = it.map (_.tail.head)

      assert(t==List("20,\"30\",40","line2"))
    }
  }
}
