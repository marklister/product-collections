/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */
package com.github.marklister
package collections.io

import scala.language.implicitConversions

object Utils {

  /**
   * Adds method csvIterator:Iterator[String] and
   * writeCsv(w:java.io.Writer) to a CollSeq
   */

  implicit class CsvOutput(c: =>Iterable[Product]) {
    implicit val doNothing:CsvRenderer=PartialFunction.empty
    private def stringify(a: Any):String = {
      a match {
        case s: String => "\"" + s.replaceAll("\"", "\"\"") + "\""
        case None=> ""
        case Some(x:Any)=>stringify(x)
        case a: Any => a.toString
      }
    }
    private val sFunc:PartialFunction[Any,String]= {case a=>stringify (a)}

    //def csvIterator(implicit specialCases:CsvRenderer=doNothing):Iterator[String]=csvIterator(",")(specialCases)

    def csvIterator(separator: String=",")(implicit specialCases:CsvRenderer=doNothing): Iterator[String] = {
      val s= specialCases orElse sFunc
      def productToCsv(p: Product):String = p.productIterator.map(s(_)).mkString(separator)
      c.iterator.map(productToCsv(_))
    }

    def writeCsv(w: java.io.Writer,separator:String=",")(implicit specialCases:CsvRenderer=doNothing):Unit ={
      csvIterator(separator)(specialCases).map(_ + "\r\n")
        .foreach(w.write(_))
    }

   // def toCsvString(implicit specialCases:CsvRenderer=doNothing):String=csvIterator()(specialCases).mkString("\r\n")

    def toCsvString(delimiter:String=",")(implicit specialCases:CsvRenderer=doNothing)=csvIterator(delimiter)(specialCases).mkString("\r\n")
  }
}