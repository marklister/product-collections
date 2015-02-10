/*
 * product-collections is distributed under the 2-Clause BSD license. See the
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 - 2014 Mark Lister
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
