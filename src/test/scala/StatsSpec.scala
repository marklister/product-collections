import org.specs2.mutable._
import org.catch22.collections._

  class StatsSpec extends Specification {
  
  
    "Mean of 1,2,3" should {
      "equal 2.0" in {
        Seq(1,2,3).mean must_== 2.0
      }
    } 
    "Variance of 1,2,3,4,5" should {
      "equal 2.0" in {
        Seq(1,2,3,4,5).variance must_== 2.0
      }
    } 
     "StdDev of 0,6" should {
      "equal 3.0" in {
        Seq(0,6).stdDev must_== 3.0
      }
    } 
  }