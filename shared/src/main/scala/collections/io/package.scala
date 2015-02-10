/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
 */

package com.github.marklister.collections

/**
 * ==I/O==
 *
 * A very simple csv file reader / parser
 *
 * Construct a parser:
 *
 * {{{
 * scala> val parser=CsvParser[String,Int,Double]
 * parser: com.github.marklister.collections.io.CsvParser3[String,Int,Double] = com.github.marklister.collections.io.CsvParser3@1d9d859
 * }}}
 *
 * Read a file:
 *
 * {{{
 * scala> val data=parser.parseFile("sample.csv")
 * data: com.github.marklister.collections.immutable.CollSeq3[String,Int,Double] =
 * CollSeq((Jan,10,22.33),
 *         (Feb,20,44.2),
 *         (Mar,25,55.1))
 * }}}
 *
 */

import scala.language.implicitConversions

package object io {

  implicit def csvOutput(s: Seq[Product]) = io.Utils.CsvOutput(s)

  /**
   * A CsvRenderer is a partial function (T) => String
   * You can supply a custom renderer for any of your types that require special handling
   * Have a look at the NaRenderer in Utils for inspiration:
   *
   * `lazy val NaRenderer: CsvRenderer = {case None => "NA"}`
   *
   * You can chain Renderers using orElse
   */
  type CsvRenderer = PartialFunction[Any, String]
}