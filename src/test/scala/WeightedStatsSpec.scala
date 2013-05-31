import org.specs2.mutable._
import org.catch22.collections._

  class WeightedStatsSpec extends Specification {
  
  
    "Weighted Mean of (1,1),(2,1),(3,1)" should {
      "equal 2.0" in {
        Seq((1,1),(2,1),(3,1)).mean must_== 2.0
      }
    } 
    "Variance of (1,1),(2,1),(3,1),(4,1),(5,1)" should {
      "equal 2.0" in {
        Seq((1,1),(2,1),(3,1),(4,1),(5,1)).variance must_== 2.0
      }
    } 
     "StdDev of (0,1),(6,1)" should {
      "equal 3.0" in {
        Seq((0,1),(6,1)).stdDev must_== 3.0
      }
    } 
  }