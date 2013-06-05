/*
 * product-collections is distributed under the 2-Clause BSD license. See the 
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 Mark Lister
 */

package org.catch22.collections
/**
 * ==I/O==
 * 
 * A very simple csv file reader / parser
 * 
 * Construct a parser:
 * 
 * {{{ 
 * scala> val parser=CsvParser[String,Int,Double]
 * parser: org.catch22.collections.io.CsvParser3[String,Int,Double] = org.catch22.collections.io.CsvParser3@1d9d859
 * }}}
 * 
 * Read a file:
 * 
 * {{{
 * scala> val data=parser.parseFile("sample.csv")
 * data: org.catch22.collections.immutable.CollSeq3[String,Int,Double] = 
 * CollSeq((Jan,10,22.33),
 *         (Feb,20,44.2),
 *         (Mar,25,55.1))
 * }}}
 * 
 */

package object io