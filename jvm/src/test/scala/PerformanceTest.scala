/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
/*
import utest._
import com.github.marklister.collections.io._

object PerformanceTest extends TestSuite {

  val tests = TestSuite {

    'BasicPerformance1 {
      val f= new java.io.FileReader("../csv-parsers-comparison/src/main/resources/worldcitiespop_huge.txt")
      val it= new CSVReader(f,headerRows=1)
      var d:Array[String] = Array.empty
      val start = new java.util.Date().getTime()
      var cnt=0l
      it.foreach(x=>cnt+=1)
      val stop = new java.util.Date().getTime
      println ("Parse time_huge:" + (stop-start))
      assert (cnt==3173959l)
    }
    'BasicPerformance2 {
      val f= new java.io.FileReader("../csv-parsers-comparison/src/main/resources/worldcitiespop.txt")
      val it= new CSVReader(f,headerRows=1)
      var d:Array[String] = Array.empty
      val start = new java.util.Date().getTime()
      var cnt=0l
      it.foreach(x=>cnt+=1)
      val stop = new java.util.Date().getTime
      println ("Parse time:" + (stop-start))
      assert (cnt==3173959l)
    }

  }
}*/
