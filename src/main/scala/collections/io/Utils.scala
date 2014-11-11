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

  val stdRenderer:CsvRenderer = {
    case s: String => "\"" + s.replaceAll("\"", "\"\"") + "\""
    case None => ""
    case Some(x: Any) => stdRenderer(x)
    case a: Any => a.toString
  }
  lazy val nullRenderer: CsvRenderer = PartialFunction.empty
  lazy val singleQuoteRenderer: CsvRenderer = {case s: String => "'" + s.replaceAll("'", "''") + "'"}
  lazy val NaRenderer: CsvRenderer = {case None => "NA"}

  /**
   * Adds method csvIterator:Iterator[String] and
   * writeCsv(w:java.io.Writer) to a CollSeq
   */

  implicit class CsvOutput(c: => Iterable[Product]) {

    def csvIterator: Iterator[String] = csvIterator()

    def csvIterator(delimiter: String = ",", renderer: CsvRenderer=nullRenderer): Iterator[String] = {
      val s = renderer orElse stdRenderer
      def productToCsv(p: Product): String = p.productIterator.map(s(_)).mkString(delimiter)
      c.iterator.map(productToCsv(_))
    }

    def writeCsv(w: java.io.Writer, delimiter: String = ",", renderer: CsvRenderer = nullRenderer): Unit = {
      csvIterator(delimiter, renderer).map(_ + "\r\n")
        .foreach(w.write(_))
    }

    def toCsvString: String = csvIterator.mkString("\r\n")

  }

}