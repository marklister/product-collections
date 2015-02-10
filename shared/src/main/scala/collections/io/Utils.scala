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

  private lazy val stdRenderer: CsvRenderer = {
    case s: String => "\"" + s.replaceAllLiterally("\"", "\"\"") + "\""
    case None => ""
    case Some(x: Any) => stdRenderer(x)
    case a: Any => a.toString
  }
  /**
   * An alternative renderer that renders Strings in single quotes.
   */
  lazy val singleQuoteRenderer: CsvRenderer = {case s: String => "'" + s.replaceAllLiterally("'", "''") + "'"}
  /**
   * A renderer that renders None as "NA"
   */
  lazy val naRenderer: CsvRenderer = {case None => "NA"}

  /**
   * Adds method csvIterator:Iterator[String] and writeCsv(w:java.io.Writer) to a CollSeq
   */

  implicit class CsvOutput(c: => Iterable[Product]) {

    /**
     * @return an Iterator[String] filled with this iterable[Product] converted to csv.
     */
    def csvIterator: Iterator[String] = csvIterator()

    /**
     * @param delimiter The delimiter used to separate csv data items.  Default is comma.
     * @param renderer A partial function used to change individual data items to a String.  If the function
     *                 you supply does not match an item the default stdRenderer is applied.  A single quote
     *                 renderer and renderer that converts None to "NA" is available in the Utils package.
     * @return an Iterator[String] filled with this iterable[Product] converted to csv.
     */
    def csvIterator(delimiter: String = ",", renderer: CsvRenderer = stdRenderer): Iterator[String] = {
      val s = renderer orElse stdRenderer
      def productToCsv(p: Product): String = p.productIterator.map(s(_)).mkString(delimiter)
      c.iterator.map(productToCsv(_))
    }

    /**
     *
     * @param writer A java.io.Writer to output the csv data to.
     * @param delimiter The delimiter used to separate csv data items.  Default is comma.
     * @param renderer A partial function used to change individual data items to a String.  If the function
     *                 you supply does not match an item the default stdRenderer is applied.  A single quote
     *                 renderer and renderer that converts None to "NA" is available in the Utils package.
     */
    def writeCsv(writer: java.io.Writer, delimiter: String = ",", renderer: CsvRenderer = stdRenderer): Unit = {
      csvIterator(delimiter, renderer).map(_ + "\r\n").foreach(writer.write(_))
    }

  }
}