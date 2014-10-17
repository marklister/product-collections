import org.specs2.mutable._
import com.github.marklister.collections.io._
import com.github.marklister.collections._

  class IOSpec extends Specification {
  
  val testData="""10,20,30
             |20,30,40""".stripMargin
  
  val testData2="""10,20,baddata
             |20,30,40""".stripMargin
  
  
  val r = new java.io.StringReader(testData)
  val r2 = new java.io.StringReader(testData2)
  
  val result=CsvParser[Int,Int,Int].parse(r)
  val result2=CsvParser[Int,Int,Option[Int]].parse(r2)
  
    "Parse of testData" should {
      "equal CollSeq3((10,20,30),(20,30,40))" in {
        result must_== CollSeq((10,20,30),(20,30,40))
      }
    } 
        "Parse of testData2" should {
      "equal CollSeq3((10,20,None),(20,30,Some(40)))" in {
        result2 must_== CollSeq((10,20,None),(20,30,Some(40)))
      }
    }
    
  }