/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2015 Mark Lister
 */

import utest._
import com.github.marklister.collections.io._
import com.github.marklister.collections._

object ConverterTest extends TestSuite {

  def convert[T](s:String)(implicit c:GeneralConverter[T])=c(s)

  val tests = TestSuite{
   'Int {
     assert(convert[Int]("123")==123)
   }
    'Double{
      assert(convert[Double]("123")==123.0)
    }
    'String{
      assert(convert[String]("123")=="123")
    }
    'Long{
      assert(convert[Long]("123")==123l)
    }
    'OptionStringNone{
      assert(convert[Option[String]]("")==None)
    }
    'OptionStringSome{
      assert(convert[Option[String]]("abc")==Some("abc"))
    }
    'OptionInt {
      assert(convert[Option[Int]]("123")==Some(123))
    }
    'OptionDouble{
      assert(convert[Option[Double]]("123")==Some(123.0))
    }
    'OptionLong{
      assert(convert[Option[Long]]("123")==Some(123l))
    }
  }
}