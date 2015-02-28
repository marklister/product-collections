/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.github.marklister
package collections.io

import java.io.{BufferedReader, IOException}

import scala.collection.mutable.ArrayBuffer

/**
 * Csv parser.  I used OpenCSV for a long time but the advent of scala.ja means that a pure scala
 * solution now makes more sense.  Not a parser combinator as I'd like to maximize performance in future.
 *
 * A BufferedReader performs substantially better than a Reader even when using read()
 */
class CSVReader(reader: java.io.Reader, delimiter: Char = ',', quoteChar: Char = '\"', headerRows: Int = 0) extends Iterator[Array[String]] {

  private[this] val br = if (reader.isInstanceOf[BufferedReader]) reader.asInstanceOf[BufferedReader] else new BufferedReader(reader)
  private[this] var lastChar: Char = 0.toChar

  private[this] def eoFile = lastChar == -1.toChar

  private[this] var currentOutput: ArrayBuffer[String] = ArrayBuffer()
  private[this] val currentField = new StringBuffer
  private[this] var quoting: Boolean = false
  (1 to headerRows).foreach(dumpLine(_))

  override def next: Array[String] = {
    currentOutput.clear()
    currentField.setLength(0)
    lastChar = 0.toChar

    def eoLine = !quoting && lastChar == '\n'
    def eoLine2 = !quoting && currentField.lastIndexOf("\r\n") == currentField.length()-2
    def nxtChar: Char = {
      lastChar = br.read.toChar; lastChar
    }

    def processRow: Unit = {
      while (!eoLine && !eoFile) {
        nxtChar
        if (hasNext) {
          if (quoting) {
            if (lastChar == quoteChar) {
              br.mark(1)
              if (nxtChar == quoteChar) currentField.append(quoteChar)
              else {
                br.reset()
                quoting = false
                forceNext(delimiter)
              }
            }
            else currentField.append(lastChar.toChar)
          } else //Not Quoting {
          if (lastChar == quoteChar) {
            br.mark(1)
            if (nxtChar == quoteChar) currentField.append(quoteChar)
            else {
              br.reset
              quoting = true
              if (currentField.toString.trim != "") throw new IOException("Quote not expected here")
              currentField.setLength(0)
            }
          }
          else if (lastChar == delimiter) {
            currentOutput.append(currentField.toString)
            currentField.setLength(0)
          }
          else currentField.append(lastChar.toChar)
        }
      }

      def forceNext(c: Char) = {
        while (nxtChar == ' ') {}
        if (!eoFile && !eoLine && lastChar != c) throw new Exception("Expected delimiter")
        currentOutput.append(currentField.toString)
        currentField.setLength(0)
      }
    }

  processRow
  if (quoting) throw new IOException("Unclosed quote")
  if (eoLine2) currentField.setLength(Math.max(0, currentField.length() - 2)) //drop \r\n
  else if (eoLine) currentField.setLength(Math.max(0, currentField.length() - 1)) //drop \n
  currentOutput.append(currentField.toString)
  currentOutput.toArray
}

override def hasNext = ! eoFile

private[this] def dumpLine (i: Int): Unit = br.readLine ()

}
