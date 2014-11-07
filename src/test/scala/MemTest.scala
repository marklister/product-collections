/*
 * Copyright (c) 2014. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/**
 * Created by mark on 11/6/14.
 */
package com.github.marklister.collections.io
import Utils._

object MemTest {

  def main (args:Array[String]):Unit={
    println("Attach monitor, press enter")
    readLine()
    var f = new java.io.FileWriter("/dev/null")
    def st= Stream.continually((1,2))
    st.take(10000000).writeCsv(f)
    f.close
    f=null
    System.gc
  }
}
