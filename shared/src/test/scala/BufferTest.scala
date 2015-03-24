/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */


import java.io.StringReader

import com.github.marklister.collections.io.InputBuffer
import utest.ExecutionContext.RunNow

import utest._

object BufferTest extends TestSuite {
  val tests = TestSuite {
    val eof=26.toChar

    'StringReader{
      val s=new StringReader("abcd")
      assert(s.read=='a')
      assert(s.read=='b')
      assert(s.read=='c')
      assert(s.read=='d')
    }
    'StringReader2{
      val s=new StringReader("abcd")
      val c:Array[Char]=Array.fill(5)(0)
      val r1=s.read(c,0,5)
      assert(c(0)=='a')
      val r2=s.read(c,0,5)
      assert(r1==4)
      //assert(r2== -1) // See scala-js issue #1560 discovered here
      val r3=s.read(c,0,5)
     // assert(r2== -1) //scalajs fails this test
    }
    'Array{
     var buf:Array[Char]=Array.fill(8197)(0)
      assert(buf(0)==0)
      assert(buf(8196)==0)
    }
    'InstantiateBuffer{
      val b= new InputBuffer(new StringReader("abc"),100)
    }
    'ReadBuffer{
      val b= new InputBuffer(new StringReader("abc"),100)
      assert (b.nextChar=='a')
      assert (!b.eoFile)
      assert (b.lastChar=='a')
      assert (b.nextChar=='b')
      assert (b.lastChar=='b')
      assert (b.nextChar=='c')
    }
    'Buffer1 {
      val b = new InputBuffer(new StringReader("12345"))
      var x = ""
      while (!b.eoFile) x += b.nextChar
      assert(x == ("12345" :+eof))
    }
    'TinyBuffer {
      val b = new InputBuffer(new StringReader("12345"), 2)
      var x = ""
      while (!b.eoFile) x += b.nextChar
      assert(x == "12345"+eof)
    }
    val b = new InputBuffer(new StringReader("12345"),2)
    'NxtFirstLast {


      val x = b.nextChar
      assert(x == '1')
      //val y = b.lastChar
      //assert(y == '1')

      assert(b.nextChar == '2')
      //assert(b.lastChar == '2')
      assert(b.secondLastChar == '1')

      assert(b.nextChar == '3')
      //assert(b.lastChar == '3')
      assert(b.secondLastChar == '2')

      assert(b.nextChar == '4')
      //assert(b.lastChar == '4')
      assert(b.secondLastChar == '3')

      assert(b.nextChar == '5')
      //assert(b.lastChar == '5')
      assert(b.secondLastChar == '4')

      assert(b.nextChar == eof)
      //assert(b.lastChar == 'eof)
      assert(b.secondLastChar == '5')

      assert(b.eoFile)


    }

  }

}