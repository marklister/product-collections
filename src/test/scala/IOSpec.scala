import org.specs2.mutable._
import org.catch22.collections._
import org.catch22.collections.io._

  class IOSpec extends Specification {
  
  val testData="""10,20,30
             |20,30,40""".stripMargin
  
  
  val r = new java.io.StringReader(testData)
  
  val result=CsvParser[Int,Int,Int].parse(r)
  
    "Parse of testData" should {
      "equal CollSeq3((10,20,30),(20,30,40))" in {
        result must_== CollSeq((10,20,30),(20,30,40))
      }
    } 
    
  }