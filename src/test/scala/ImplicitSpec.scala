/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

import org.specs2.mutable._
import com.github.marklister.collections._

/* 
 * Although implicit resolution is at compile time, some tests are possible
 * at runtime.  Issue 7 is a case in point.
 */

class ImplicitSpec extends Specification {


  "Seq(1,2,3) " should {
    "convert to CollSeq((1),(2),(3))" in {
      Seq(1, 2, 3)._1 must_== Seq(1, 2, 3)
    }
    "flatZip correctly with Seq(9,8,7)" in {
      Seq(1, 2, 3) flatZip Seq(9, 8, 7) must_== CollSeq((1, 9), (2, 8), (3, 7))
    }

  }
}