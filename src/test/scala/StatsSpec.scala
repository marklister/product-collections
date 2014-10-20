/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

import org.specs2.mutable._
import com.github.marklister.collections._

class StatsSpec extends Specification {


  "Mean of 1,2,3" should {
    "equal 2.0" in {
      Seq(1, 2, 3).mean must_== 2.0
    }
  }
  "Variance of 1,2,3,4,5" should {
    "equal 2.0" in {
      Seq(1, 2, 3, 4, 5).variance must_== 2.0
    }
  }
  "StdDev of 0,6" should {
    "equal 3.0" in {
      Seq(0, 6).stdDev must_== 3.0
    }
  }
}