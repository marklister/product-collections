import collections.annotations.extract
import utest._
import utest.framework.TestSuite
import collections.annotations._


object CaseColSeqTest extends TestSuite{

  @extract case class User(name:String,surname:String)
  val tests = TestSuite{

    "Should create Data Frames from case classes" -{

      val (ann,bob) = (User("Ann","Cute"),User("Bob","Ugly"))
      val frame = User.asFrame(ann,bob)
      val names:Seq[String] = frame.names
      val surnames:Seq[String] = frame.surnames
      assert(names.size==2)
      assert(surnames.size==2)
      assert(names==Seq("Ann","Bob"))
      assert(surnames==Seq("Cute","Ugly"))
    }

  }
}