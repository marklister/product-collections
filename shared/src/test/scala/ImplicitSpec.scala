/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */
import utest._
import utest.ExecutionContext.RunNow
import com.github.marklister.collections._

/* 
 * Although implicit resolution is at compile time, some tests are possible
 * at runtime.  Issue 7 is a case in point.
 */

object ImplicitSuite extends TestSuite{
  val tests = TestSuite{


  'Test1{

      assert (Seq(1, 2, 3)._1 == Seq(1, 2, 3))
    }
    'Test2 {
      assert((Seq(1, 2, 3) flatZip Seq(9, 8, 7)) == CollSeq((1, 9), (2, 8), (3, 7)))
    }

  }
}