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

  lazy val nullRenderer: CsvRenderer = PartialFunction.empty
  lazy val singleQuoteRenderer: CsvRenderer = {
    case s: String => "'" + s.replaceAll("'", "''") + "'"
  }
  lazy val NaRenderer: CsvRenderer = {
    case None => "NA"
  }

  /**
   * Adds method csvIterator:Iterator[String] and
   * writeCsv(w:java.io.Writer) to a CollSeq
   */

  implicit class CsvOutput(c: => Iterable[Product]) {

    private def stringify(a: Any): String = {
      a match {
        case s: String => "\"" + s.replaceAll("\"", "\"\"") + "\""
        case None => ""
        case Some(x: Any) => stringify(x)
        case a: Any => a.toString
      }
    }

    private val stdRenderer: CsvRenderer = {
      case a => stringify(a)
    }

    def csvIterator: Iterator[String] = csvIterator(",", nullRenderer)

    def csvIterator(separator: String = ",", renderer: CsvRenderer): Iterator[String] = {
      val s = renderer orElse stdRenderer
      def productToCsv(p: Product): String = p.productIterator.map(s(_)).mkString(separator)
      c.iterator.map(productToCsv(_))
    }

    def writeCsv(w: java.io.Writer, separator: String = ",", renderer: CsvRenderer = nullRenderer): Unit = {
      csvIterator(separator, renderer).map(_ + "\r\n")
        .foreach(w.write(_))
    }

    def toCsvString: String = csvIterator.mkString("\r\n")

  }

}