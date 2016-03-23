/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

import utest._
import com.github.marklister.collections._

object WeightedStatsSpec extends TestSuite {


  val tests = TestSuite {
    'WeightedMean {
      Seq((1, 1), (2, 1), (3, 1)).mean == 2.0
    }
    'Variance {
      Seq((1, 1), (2, 1), (3, 1), (4, 1), (5, 1)).variance == 2.0
    }
    'StdDev {
      Seq((0, 1), (6, 1)).stdDev == 3.0
    }
    'StdDev2 {
      CollSeq((0, 1), (6, 1)).stdDev == 3.0
    }
  }
}
