/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.github.marklister.collections.io

import java.io.Reader

class InputBuffer(br: Reader, val buffSize: Int = 8194) {

  private [this] var buffer: Array[Char] = Array.fill(buffSize + 3)(0)
  private [this] var bufferPos = 2
  private [this] var bufferMax = 2
  var eoFile = false

  private def readBuf = {
    buffer(0) = buffer(bufferPos - 1)
    buffer(1) = buffer(bufferPos)
    bufferPos = 1
    bufferMax = br.read(buffer, 2, buffSize) + 2

    if (bufferMax == 1) {
      buffer(2) = CSVReader.eof
      bufferMax = 2
      eoFile = true
    }
  }

  def nextChar: Char = {
    if (bufferPos >= bufferMax - 1) readBuf
    bufferPos += 1
    buffer(bufferPos)
  }

  def nextWhile(charMax:Char):Array[Char]={
    if (bufferPos >= bufferMax - 1) readBuf
    bufferPos+=1
    val start=bufferPos
    while (buffer(bufferPos)>charMax && bufferPos<bufferMax) bufferPos+=1
    val dest=new Array[Char](bufferPos-start)
    System.arraycopy(buffer,start,dest,0,bufferPos-start)
    bufferPos -= 1
    if(peek<=charMax || eoFile) dest else dest ++ nextWhile(charMax)
  }

  /*def takeWhile(func:Char=>Boolean):Array[Char]={
    if (bufferPos >= bufferMax - 1) readBuf
    bufferPos+=1
    val start=bufferPos
    while (func(buffer(bufferPos)) && bufferPos<bufferMax) bufferPos+=1
    val dest=new Array[Char](bufferPos-start)
    System.arraycopy(buffer,start,dest,0,bufferPos-start)
    bufferPos -= 1
    if(!func(peek) || eoFile) dest else dest ++ takeWhile(func)
  }*/  //Too slow

  def nextUntil(char:Char):Array[Char]={
    if (bufferPos >= bufferMax - 1) readBuf
    bufferPos+=1
    val start=bufferPos
    while (buffer(bufferPos)!=char && bufferPos<bufferMax) bufferPos+=1
    val dest=new Array[Char](bufferPos-start)
    System.arraycopy(buffer,start,dest,0,bufferPos-start)
    bufferPos -= 1
    if(peek==char || eoFile) dest else dest ++ nextUntil(char)
  }

  def peek: Char = {
    if (bufferPos >= bufferMax - 1) readBuf
    buffer(bufferPos+1)
  }

  def lastChar: Char = buffer(bufferPos)
  def secondLastChar = buffer(bufferPos - 1)
  def eoLine = (lastChar == CSVReader.eol) || eoFile

}
