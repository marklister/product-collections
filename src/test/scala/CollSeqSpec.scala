import org.specs2.mutable._
import com.github.marklister.collections.immutable._



  class CollSeqSpec extends Specification {
  val testData = CollSeq(("Jan",10,22.44,11.7),
                            ("Feb",33,55.77,23.4),
                            ("Mar",23,56.77,23.4))
                          
  
    "CollSeq /Testdata1 " should {
      "size must be 3" in {
        testData.size must_== 3
      }
      "Column one extractor works" in {
        testData._1 must_== Seq("Jan","Feb","Mar")
      }
      "Column three extractor works" in {
        testData._3 must_== Seq(22.44,55.77,56.77)
      }
      "Map function extracts column 2" in {
        testData.map(_._2) must_==Seq(10,33,23)
      }
      "Sum of a mapped seq" in {
        testData.map(_._2).sum must_==66
      }
      "Sum of an extracted column" in {
        testData._2.sum must_==66
      }
      
      "Original data must be instance of CollSeq" in {
        val res= testData match {
          case _:CollSeq4[String,Int,Double,Double]=> true
//          case _:Any => false  //this line should be unreachable and the compiler should know that 
        }
        res must_== true
      }
            "compatible map must be instance of CollSeq" in {
        val res= testData.map(i=>(i._1,i._2,i._3,i._4)) match {
          case _:CollSeq4[String,Int,Double,Double]=> true
//          case _:Any => false  //this line should be unreachable and the compiler should know that 
        }
        res must_== true
      }
      
    "complex compatible map must be instance of CollSeq" in {
        val res= testData.map(i=>(i._1+"Stuff",i._2+1,i._3-1,i._4*2)) match {
          case _:CollSeq4[String,Int,Double,Double]=> true
//          case _:Any => false  //this line should be unreachable and the compiler should know that 
        }
        res must_== true
      }
      
    "intermediate compatible map must be instance of CollSeq" in {
        val res= testData.map(i=>(i._1,i._2,i._3.toFloat,i._4.toFloat)) match {
          case _:CollSeq4[String,Int,Float,Float]=> true
//          case _:Any => false  //this line should be unreachable and the compiler should know that 
        }
        res must_== true
      }
    
    "Mapping to a different type of CollSeq must return a CollSeq" in {
        val res= testData.map(i=>(i._4,i._3,i._2,i._1)) match {
          case _:CollSeq4[Double,Double,Int,String]=> true
//          case _:Any => false  //this line should be unreachable and the compiler should know that 
        }
        res must_== true
      }
      
        "flatZip" in {
        val res= testData.flatZip(testData._1) match {
          case _:CollSeq5[String,Int,Double,Double,String]=> true
//          case _:Any => false  //this line should be unreachable and the compiler should know that 
        }
        res must_== true
      }
    }
  }