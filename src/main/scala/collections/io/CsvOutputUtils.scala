/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */
package com.github.marklister
package collections.io

import java.io.PrintWriter

import com.github.marklister.collections.immutable.CollSeq

object CsvOutputUtils {

  /**
   * Adds method csvIterator:Iterator[String] to a CollSeq
   */
  implicit class CsvOutput(c: CollSeq) {

    private def stringify(a: Any) = {
      a match {
        case s: String => "\"" + s.replaceAll("\"", "\"\"") + "\""
        case a: Any => a.toString
      }
    }

    def csvIterator:Iterator[String]=csvIterator()

    def csvIterator(separator: String=","): Iterator[String] = {
      def productToCsv(p: Product):String = p.productIterator.map(stringify(_)).mkString(separator)
      c.iterator.map(productToCsv(_))
    }

    def writeCsv(w: java.io.Writer) = {
      csvIterator().map(_ + "\r\n")
        .foreach(w.write(_))
    }
  }

}
