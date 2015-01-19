/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

import utest._
import utest.ExecutionContext.RunNow
import com.github.marklister.collections._

object StatsSpec extends TestSuite {

  val tests = TestSuite {
    'Mean {
      Seq(1, 2, 3).mean == 2.0
    }

    'Variance {
      Seq(1, 2, 3, 4, 5).variance == 2.0
    }
    'StdDev {
      Seq(0, 6).stdDev == 3.0
    }
  }
}