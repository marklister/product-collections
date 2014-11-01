/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */
package com.github.marklister
package collections.io

object Utils {

  /**
   * Adds method csvIterator:Iterator[String] and
   * writeCsv(w:java.io.Writer) to a CollSeq
   */
  implicit class CsvOutput(c: Iterable[Product]) {

    private def stringify(a: Any):String = {
      a match {
        case s: String => "\"" + s.replaceAll("\"", "\"\"") + "\""
        case None=> ""
        case Some(x:Any)=>stringify(x)
        case a: Any => a.toString
      }
    }

    def csvIterator:Iterator[String]=csvIterator()

    def csvIterator(separator: String=","): Iterator[String] = {
      def productToCsv(p: Product):String = p.productIterator.map(stringify(_)).mkString(separator)
      c.iterator.map(productToCsv(_))
    }

    def writeCsv(w: java.io.Writer,separator:String=","):Unit ={
      csvIterator(separator).map(_ + "\r\n")
        .foreach(w.write(_))
    }

    def toCsvString:String=csvIterator.mkString("\r\n")

    def toCsvString(s:String)=csvIterator(s).mkString("\r\n")
  }
}