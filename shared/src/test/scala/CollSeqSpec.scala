/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

import utest._
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
      assert(testData._1 == Seq("Jan", "Feb", "Mar"))
    }
    'Col3 {
      assert(testData._3 == Seq(22.44, 55.77, 56.77))
    }
    'Map2 {
      assert(testData.map(_._2) == Seq(10, 33, 23))
    }
    'Sum {
      assert(testData.map(_._2).sum == 66)
    }
    'SumCol {
      assert(testData._2.sum == 66)
    }
  }

    'InstanceOf {
      val res = testData match {
        case _: CollSeq4[String, Int, Double, Double] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      assert(res)
    }
    'MapToCollSeq {
      val res = testData.map(i => (i._1, i._2, i._3, i._4)) match {
        case _: CollSeq4[String, Int, Double, Double] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      assert(res)
    }

    'ComplexTypeMap {
      val res = testData.map(i => (i._1 + "Stuff", i._2 + 1, i._3 - 1, i._4 * 2)) match {
        case _: CollSeq4[String, Int, Double, Double] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      assert(res)
    }

    'Intermediate  {
      val res = testData.map(i => (i._1, i._2, i._3.toFloat, i._4.toFloat)) match {
        case _: CollSeq4[String, Int, Float, Float] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      assert(res)
    }

    'TypeChange {
      val res = testData.map(i => (i._4, i._3, i._2, i._1)) match {
        case _: CollSeq4[Double, Double, Int, String] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      assert(res)
    }

    'FlatZip {
      val res = testData.flatZip(testData._1) match {
        case _: CollSeq5[String, Int, Double, Double, String] => true
        //          case _:Any => false  //this line should be unreachable and the compiler should know that
      }
      assert(res)
    }

    'SimpleTypeConvertsToProduct {
      assert(CollSeq(1,2,3) == CollSeq1(Seq(Tuple1(1),Tuple1(2),Tuple1(3))))
    }

    'ProductWrappedInProduct1 {
      case class T(i:Int=1)
      val s= Seq(T,T,T)
      assert(CollSeq(T,T,T) == CollSeq1(Seq(Tuple1(T),Tuple1(T),Tuple1(T))))
    }

    'MixedProductNsDontCCompile{
      compileError("CollSeq((1,2,3),(1,2))")
    }

    'CanAddHeaders{
      assert (CollSeq((1,2)).withHeaders("a","b").headers==Seq("a","b"))
    }

    'CanRetrieveMap{
      assert (CollSeq((1,2)).withHeaders("a","b").collMap("b")==Seq(2))
    }

    /*This test is for a future version
    'FlatZipOfCaseClass {
      case class T(i:Int=1)

      assert((CollSeq(T,T,T) flatZip CollSeq(T,T,T))== CollSeq2(Seq((T,T),(T,T),(T,T))))
    }*/
  }
}