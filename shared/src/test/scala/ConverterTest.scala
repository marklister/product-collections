/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2015 Mark Lister
 */

import utest._
import utest.ExecutionContext.RunNow
import com.github.marklister.collections.io._
import com.github.marklister.collections._

object ConverterTest extends TestSuite {

  def convert[T](s:String)(implicit c:GeneralConverter[T])=c(s)

  val tests = TestSuite{
   'Int {
     convert[Int]("123")==123
   }
    'Double{
      convert[Double]("123")==123.0
    }
    'String{
      convert[String]("123")=="123"
    }
    'Long{
      convert[Long]("123")==123l
    }
    'OptionInt {
      convert[Option[Int]]("123")==Some(123)
    }
    'OptionDouble{
      convert[Option[Double]]("123")==Some(123.0)
    }
    'OptionLong{
      convert[Option[Long]]("123")==Some(123l)
    }
  }
}