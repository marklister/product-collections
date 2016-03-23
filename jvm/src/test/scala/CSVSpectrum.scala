/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import utest._
import com.github.marklister.collections.io._

object CSVSpectrum extends TestSuite {

  val tests = TestSuite {

    'CommasInQuotes{
      val f= new java.io.FileReader("./res/csvs/comma_in_quotes.csv")
      val it= new CSVReader(f,headerRows=1)
      val res= it.next
      assert (res.length==5)
      assert (res(0)=="John")
      assert (res(1)=="Doe")
      assert (res(2)=="120 any st.")
      assert (res(3)=="Anytown, WW")
      }

    'Empty{
      val f= new java.io.FileReader("./res/csvs/empty.csv")
      val it= new CSVReader(f,headerRows=1)
      val res= it.next
      assert (res.length==3)
      assert (res(0)=="1")
      assert (res(1)=="")
      assert (res(2)=="")

      val res2= it.next
      assert (res2.length==3)
      assert (res2(0)=="2")
      assert (res2(1)=="3")
      assert (res2(2)=="4")

    }

    'EmptyCrLf{
      val f= new java.io.FileReader("./res/csvs/empty_crlf.csv")
      val it= new CSVReader(f,headerRows=1)
      val res= it.next
      assert (res.length==3)
      assert (res(0)=="1")
      assert (res(1)=="")
      assert (res(2)=="")

      val res2= it.next
      assert (res2.length==3)
      assert (res2(0)=="2")
      assert (res2(1)=="3")
      assert (res2(2)=="4")

    }

    'EmptyCr{
      val f= new java.io.FileReader("./res/csvs/empty_cr.csv")
      val it= new CSVReader(f,headerRows=1)
      val res= it.next
      assert (res.length==3)
      assert (res(0)=="1")
      assert (res(1)=="")
      assert (res(2)=="")

      val res2= it.next
      assert (res2.length==3)
      assert (res2(0)=="2")
      assert (res2(1)=="3")
      assert (res2(2)=="4")

    }

    'Json{
      val f= new java.io.FileReader("./res/csvs/json.csv")
      val it= new CSVReader(f,headerRows=1)
      val res= it.next
      assert (res.length==2)
      assert (res(0)=="1")
      assert (res(1)=="{\"type\": \"Point\", \"coordinates\": [102.0, 0.5]}")

    }


    'NewLines{
      val f= new java.io.FileReader("./res/csvs/newlines.csv")
      val it= new CSVReader(f,headerRows=1)
      val res= it.next
      assert (res.length==3)
      assert (res(0)=="1")
      assert (res(1)=="2")
      assert (res(2)=="3")

      val res2= it.next
      assert (res2.length==3)
      assert (res2(0)=="Once upon \na time")
      assert (res2(1)=="5")
      assert (res2(2)=="6")

      val res3= it.next
      assert (res3.length==3)
      assert (res3(0)=="7")
      assert (res3(1)=="8")
      assert (res3(2)=="9")

    }

    'NewLinesCRLF{
      val f= new java.io.FileReader("./res/csvs/newlines_crlf.csv")
      val it= new CSVReader(f,headerRows=1)
      val res= it.next
      assert (res.length==3)
      assert (res(0)=="1")
      assert (res(1)=="2")
      assert (res(2)=="3")

      val res2= it.next
      assert (res2.length==3)
      assert (res2(0)=="Once upon \r\na time")
      assert (res2(1)=="5")
      assert (res2(2)=="6")

      val res3= it.next
      assert (res3.length==3)
      assert (res3(0)=="7")
      assert (res3(1)=="8")
      assert (res3(2)=="9")

    }

    'NewLinesCR{
      val f= new java.io.FileReader("./res/csvs/newlines_cr.csv")
      val it= new CSVReader(f,headerRows=1)
      val res= it.next
      assert (res.length==3)
      assert (res(0)=="1")
      assert (res(1)=="2")
      assert (res(2)=="3")

      val res2= it.next
      assert (res2.length==3)
      assert (res2(0)=="Once upon \ra time")
      assert (res2(1)=="5")
      assert (res2(2)=="6")

      val res3= it.next
      assert (res3.length==3)
      assert (res3(0)=="7")
      assert (res3(1)=="8")
      assert (res3(2)=="9")

    }

    'QuotesAndNewlines{
      val f= new java.io.FileReader("./res/csvs/quotes_and_newlines.csv")
      val it= new CSVReader(f,headerRows=1)
      val res= it.next
      assert (res.length==2)
      assert (res(0)=="1")
      assert (res(1)=="ha \n\"ha\" \nha")

      val res2= it.next
      assert (res2.length==2)
      assert (res2(0)=="3")
      assert (res2(1)=="4")

    }

    'Simple {
      val f = new java.io.FileReader("./res/csvs/simple.csv")
      val it = new CSVReader(f, headerRows = 1)
      val res = it.next
      assert(res.length == 3)
      assert(res(0) == "1")
      assert(res(1) == "2")
      assert(res(2) == "3")
    }

    'SimpleCrLf {
      val f = new java.io.FileReader("./res/csvs/simple_crlf.csv")
      val it = new CSVReader(f, headerRows = 1)
      val res = it.next
      assert(res.length == 3)
      assert(res(0) == "1")
      assert(res(1) == "2")
      assert(res(2) == "3")
    }

    'SimpleCr {
      val f = new java.io.FileReader("./res/csvs/simple_cr.csv")
      val it = new CSVReader(f, headerRows = 1)
      val res = it.next
      assert(res.length == 3)
      assert(res(0) == "1")
      assert(res(1) == "2")
      assert(res(2) == "3")
    }

    'Utf8 {
      val f = new java.io.FileReader("./res/csvs/utf8.csv")
      val it = new CSVReader(f, headerRows = 1)
      val res = it.next
      assert(res.length == 3)
      assert(res(0) == "1")
      assert(res(1) == "2")
      assert(res(2) == "3")

      val res2 = it.next
      assert(res2.length == 3)
      assert(res2(0) == "4")
      assert(res2(1) == "5")
      assert(res2(2) == "ʤ")
    }

  }
}
