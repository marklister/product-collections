/*
 * product-collections is distributed under the 2-Clause BSD license. See the 
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 Mark Lister
 */

package org.catch22.collections.io
import au.com.bytecode.opencsv.CSVReader
import scala.collection.JavaConverters._
/**
 * A thin wrapper around opencsv CsvReader
 */
private [io] object OpenCsv{
  
  def read(
    filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false):Seq[Seq[String]] = {
     
    val reader = new CSVReader(new java.io.FileReader(filename),
                               delimiter.toCharArray.head,
                               quoteChar,
                               if(hasHeader)1 else 0);
    reader.readAll.asScala.map(_.toSeq).toSeq
  }
}