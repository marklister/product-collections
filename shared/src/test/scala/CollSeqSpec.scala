/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

import utest._
import utest.ExecutionContext.RunNow
import com.github.marklister.collections.immutable._


object CollSeqSuite extends TestSuite{

  val testData = CollSeq(("Jan", 10, 22.44, 11.7),
    ("Feb", 33, 55.77, 23.4),
    ("Mar", 23, 56.77, 23.4))

  val tests = TestSuite{


  'Test1 {
    'Size3 {
      assert(testData.size == 3)
    }
    'Col1 {
      testData._1 == Seq("Jan", "Feb", "Mar")
    }
    'Col3 {
      testData._3 == Seq(22.44, 55.77, 56.77)
    }
    'Map2 {
      testData.map(_._2) == Seq(10, 33, 23)
    }
    'Sum {
      testData.map(_._2).sum == 66
    }
    'SumCol {
      testData._2.sum == 66
    }
  }

    'InstanceOf {
      val res = testData match {
        case _: CollSeq4[String, Int, Double, Double] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      res == true
    }
    'MapToCollSeq {
      val res = testData.map(i => (i._1, i._2, i._3, i._4)) match {
        case _: CollSeq4[String, Int, Double, Double] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      res == true
    }

    'ComplexTypeMap {
      val res = testData.map(i => (i._1 + "Stuff", i._2 + 1, i._3 - 1, i._4 * 2)) match {
        case _: CollSeq4[String, Int, Double, Double] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      res == true
    }

    'Intermediate  {
      val res = testData.map(i => (i._1, i._2, i._3.toFloat, i._4.toFloat)) match {
        case _: CollSeq4[String, Int, Float, Float] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      res == true
    }

    'TypeChange {
      val res = testData.map(i => (i._4, i._3, i._2, i._1)) match {
        case _: CollSeq4[Double, Double, Int, String] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      res == true
    }

    'FlatZip {
      val res = testData.flatZip(testData._1) match {
        case _: CollSeq5[String, Int, Double, Double, String] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      res == true
    }
  }
}