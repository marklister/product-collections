/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.github.marklister.collections.io

import scala.collection.mutable.ArrayBuilder

class CSVReader(val reader: java.io.Reader,
                final val delimiter: Char = ',',
                final val quoteChar: Char = '\"',
                val headerRows: Int = 0) extends Iterator[Array[String]] {

  def this(s: String) = this(new java.io.StringReader(s))

  final val b = new InputBuffer(reader)
  private[this] final val maxChar: Char = Seq(quoteChar, delimiter, CSVReader.cr, CSVReader.eol, CSVReader.eof).max
  val currentOutput: ArrayBuilder[String] = new ArrayBuilder.ofRef[String] {}
  val currentField = new java.lang.StringBuilder(40)
  var line = headerRows

  (1 to headerRows).foreach(dropLine)

  def processQuotedField: Unit = {
      currentField.append(b.nextUntil(quoteChar))
      b.nextChar
      if (b.peek == '"') {
        currentField.append(b.nextChar)
        processQuotedField
      } else {
        //Quote closed
        while (b.nextChar == ' ') {} //ignore whitespace
        if (b.lastChar != delimiter && !b.eoLine && b.lastChar != CSVReader.cr
        ) throw new Exception("Line " + line + " Expected " + delimiter + " got " + b.lastChar.toInt)
        if(b.lastChar==13 && b.peek==10) b.nextChar
      }
  }

  def processUnQuotedField: Unit = {
    do {
      currentField.append(b.nextWhile(maxChar))
      (b.nextChar) match {
        case `quoteChar` =>
          if (b.peek == quoteChar) currentField.append(b.nextChar)
          else currentField.append(b.lastChar)
        case `delimiter`=>
        case CSVReader.eol =>
        case CSVReader.cr =>
          if (b.peek == CSVReader.eol) b.nextChar
        case CSVReader.eof =>
        case _ => currentField.append(b.lastChar)
      }
    }while (b.lastChar != delimiter && !b.eoLine)
  }

  /*Sniff the buffer -- it it starts with whitespace and a quote process as quoted field
   * Other wise process as an unquoted field
   */
  def processField: Unit = {
    while (b.peek == ' ') currentField.append(b.nextChar)
    if (b.peek == quoteChar) {
      currentField.setLength(0)
      b.nextChar
      processQuotedField
    }
    else {
      processUnQuotedField
    }
  }

  override def next: Array[String] = {
    currentOutput.clear()
    currentField.setLength(0)
    line += 1

    do {
      processField
      currentOutput += currentField.toString
      currentField.setLength(0)
    } while (!b.eoLine)

    currentOutput.result() //toArray(new Array[String](currentOutput.size()))
  }

  override def hasNext = !b.eoFile

  private[this] def dropLine(i: Int): Unit = {
    do b.nextChar while (!b.eoLine)
    if (b.lastChar == CSVReader.cr && b.peek == CSVReader.eol) b.nextChar
  }

  def close() = reader.close()

}

object CSVReader {
  final val eol = '\n'
  final val cr = '\r'
  final val eof = 26.toChar

}
