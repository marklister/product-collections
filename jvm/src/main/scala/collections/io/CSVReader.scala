/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.github.marklister
package collections.io


/**
 * A shim around opencsv.  In future, once it's stable, we'll switch to the CsvReader in js/src/main/scala/collections/io
 */
class CSVReader(reader: java.io.Reader, delimiter: Char = ',', quoteChar: Char = '\"', headerRows: Int = 0) extends Iterator[Array[String]] {

  val underlying = new au.com.bytecode.opencsv.CSVReader (reader,delimiter,quoteChar,headerRows)
  var peek = underlying.readNext

  override def next = {
    if (!hasNext) Iterator.empty.next() else {
      val r= peek
      peek = underlying.readNext
      r
    }
  }
    override def hasNext = null != peek
}
