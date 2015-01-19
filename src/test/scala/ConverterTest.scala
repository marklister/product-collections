/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import utest._
import utest.ExecutionContext.RunNow
import com.github.marklister.collections.io._
import com.github.marklister.collections._

object ConverterTest extends TestSuite {

  def convert[T](s:String)(implicit c:GeneralConverter[T])=c.convert(s)

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