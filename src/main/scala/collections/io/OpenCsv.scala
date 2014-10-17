/*
 * product-collections is distributed under the 2-Clause BSD license. See the 
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 Mark Lister
 */

package com.github.marklister.collections.io
import au.com.bytecode.opencsv.CSVReader
import scala.collection.JavaConverters._
/**
 * A thin wrapper around opencsv CsvReader
 */
private [io] object OpenCsv{
    
  def read(
    reader: java.io.Reader,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false):Seq[Seq[String]] = {
     
    val csvReader = new CSVReader(reader,
                               delimiter.toCharArray.head,
                               quoteChar,
                               if(hasHeader)1 else 0);
    csvReader.readAll.asScala.map(_.toSeq).toSeq
  }
}