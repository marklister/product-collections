/*
 * product-collections is distributed under the 2-Clause BSD license. See the 
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 Mark Lister
 */

package org.catch22.collections
package io

import org.catch22.collections.immutable._
     
/**
 * A Strongly typed Csv to CollSeq[T##1,T##2,...Tn] Parser.
 * Use the companion object to instantiate the correct parser:
 * {{{
 * scala> val p = CsvParser[String,Int,Double]
 * p: org.catch22.collections.io.CsvParser3[String,Int,Double] = org.catch22.collections.io.CsvParser3@1d8073f
 * 
 * scala> p.parseFile("sample.csv")
 * res2: org.catch22.collections.immutable.CollSeq3[String,Int,Double] = 
 * CollSeq((Jan,10,22.33),
 *         (Feb,20,44.2),
 *         (Mar,25,55.1))
 * }}}
 */
abstract sealed class CsvParser

/**
 * The companion object for [[CsvParser]]
 */
object CsvParser{
  /**
 * A CsvParser of arity 1
 */
def apply[T1]= new CsvParser1[T1]
  /**
 * A CsvParser of arity 2
 */
def apply[T1,T2]= new CsvParser2[T1,T2]
  /**
 * A CsvParser of arity 3
 */
def apply[T1,T2,T3]= new CsvParser3[T1,T2,T3]
  /**
 * A CsvParser of arity 4
 */
def apply[T1,T2,T3,T4]= new CsvParser4[T1,T2,T3,T4]
  /**
 * A CsvParser of arity 5
 */
def apply[T1,T2,T3,T4,T5]= new CsvParser5[T1,T2,T3,T4,T5]
  /**
 * A CsvParser of arity 6
 */
def apply[T1,T2,T3,T4,T5,T6]= new CsvParser6[T1,T2,T3,T4,T5,T6]
  /**
 * A CsvParser of arity 7
 */
def apply[T1,T2,T3,T4,T5,T6,T7]= new CsvParser7[T1,T2,T3,T4,T5,T6,T7]
  /**
 * A CsvParser of arity 8
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8]= new CsvParser8[T1,T2,T3,T4,T5,T6,T7,T8]
  /**
 * A CsvParser of arity 9
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9]= new CsvParser9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
  /**
 * A CsvParser of arity 10
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]= new CsvParser10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
  /**
 * A CsvParser of arity 11
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]= new CsvParser11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
  /**
 * A CsvParser of arity 12
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]= new CsvParser12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
  /**
 * A CsvParser of arity 13
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]= new CsvParser13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
  /**
 * A CsvParser of arity 14
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]= new CsvParser14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
  /**
 * A CsvParser of arity 15
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]= new CsvParser15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
  /**
 * A CsvParser of arity 16
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]= new CsvParser16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
  /**
 * A CsvParser of arity 17
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]= new CsvParser17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
  /**
 * A CsvParser of arity 18
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]= new CsvParser18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
  /**
 * A CsvParser of arity 19
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]= new CsvParser19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
  /**
 * A CsvParser of arity 20
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]= new CsvParser20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
  /**
 * A CsvParser of arity 21
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]= new CsvParser21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
  /**
 * A CsvParser of arity 22
 */
def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]= new CsvParser22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
}

/**
 * A file to CollSeq1 parser
 */
class CsvParser1[T1] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq1 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1]):CollSeq1[T1]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple1(c1.convert (x(0)))) 
    CollSeq1[T1](q.toSeq)
  }
  
}

/**
 * A file to CollSeq2 parser
 */
class CsvParser2[T1,T2] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq2 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2]):CollSeq2[T1,T2]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple2(c1.convert (x(0)), c2.convert (x(1)))) 
    CollSeq2[T1,T2](q.toSeq)
  }
  
}

/**
 * A file to CollSeq3 parser
 */
class CsvParser3[T1,T2,T3] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq3 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3]):CollSeq3[T1,T2,T3]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple3(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)))) 
    CollSeq3[T1,T2,T3](q.toSeq)
  }
  
}

/**
 * A file to CollSeq4 parser
 */
class CsvParser4[T1,T2,T3,T4] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq4 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4]):CollSeq4[T1,T2,T3,T4]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple4(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)))) 
    CollSeq4[T1,T2,T3,T4](q.toSeq)
  }
  
}

/**
 * A file to CollSeq5 parser
 */
class CsvParser5[T1,T2,T3,T4,T5] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq5 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5]):CollSeq5[T1,T2,T3,T4,T5]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple5(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)))) 
    CollSeq5[T1,T2,T3,T4,T5](q.toSeq)
  }
  
}

/**
 * A file to CollSeq6 parser
 */
class CsvParser6[T1,T2,T3,T4,T5,T6] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq6 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6]):CollSeq6[T1,T2,T3,T4,T5,T6]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple6(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)))) 
    CollSeq6[T1,T2,T3,T4,T5,T6](q.toSeq)
  }
  
}

/**
 * A file to CollSeq7 parser
 */
class CsvParser7[T1,T2,T3,T4,T5,T6,T7] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq7 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7]):CollSeq7[T1,T2,T3,T4,T5,T6,T7]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple7(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)))) 
    CollSeq7[T1,T2,T3,T4,T5,T6,T7](q.toSeq)
  }
  
}

/**
 * A file to CollSeq8 parser
 */
class CsvParser8[T1,T2,T3,T4,T5,T6,T7,T8] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq8 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8]):CollSeq8[T1,T2,T3,T4,T5,T6,T7,T8]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple8(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)))) 
    CollSeq8[T1,T2,T3,T4,T5,T6,T7,T8](q.toSeq)
  }
  
}

/**
 * A file to CollSeq9 parser
 */
class CsvParser9[T1,T2,T3,T4,T5,T6,T7,T8,T9] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq9 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9]):CollSeq9[T1,T2,T3,T4,T5,T6,T7,T8,T9]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple9(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)))) 
    CollSeq9[T1,T2,T3,T4,T5,T6,T7,T8,T9](q.toSeq)
  }
  
}

/**
 * A file to CollSeq10 parser
 */
class CsvParser10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq10 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10]):CollSeq10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple10(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)))) 
    CollSeq10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](q.toSeq)
  }
  
}

/**
 * A file to CollSeq11 parser
 */
class CsvParser11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq11 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11]):CollSeq11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple11(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)))) 
    CollSeq11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](q.toSeq)
  }
  
}

/**
 * A file to CollSeq12 parser
 */
class CsvParser12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq12 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12]):CollSeq12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple12(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)))) 
    CollSeq12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](q.toSeq)
  }
  
}

/**
 * A file to CollSeq13 parser
 */
class CsvParser13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq13 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13]):CollSeq13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple13(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)))) 
    CollSeq13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](q.toSeq)
  }
  
}

/**
 * A file to CollSeq14 parser
 */
class CsvParser14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq14 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14]):CollSeq14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple14(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)))) 
    CollSeq14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](q.toSeq)
  }
  
}

/**
 * A file to CollSeq15 parser
 */
class CsvParser15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq15 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15]):CollSeq15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple15(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)))) 
    CollSeq15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](q.toSeq)
  }
  
}

/**
 * A file to CollSeq16 parser
 */
class CsvParser16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq16 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16]):CollSeq16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple16(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)))) 
    CollSeq16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](q.toSeq)
  }
  
}

/**
 * A file to CollSeq17 parser
 */
class CsvParser17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq17 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17]):CollSeq17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple17(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)))) 
    CollSeq17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](q.toSeq)
  }
  
}

/**
 * A file to CollSeq18 parser
 */
class CsvParser18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq18 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18]):CollSeq18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple18(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)))) 
    CollSeq18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](q.toSeq)
  }
  
}

/**
 * A file to CollSeq19 parser
 */
class CsvParser19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq19 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18], c19:GeneralConverter[T19]):CollSeq19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple19(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)), c19.convert (x(18)))) 
    CollSeq19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](q.toSeq)
  }
  
}

/**
 * A file to CollSeq20 parser
 */
class CsvParser20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq20 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18], c19:GeneralConverter[T19], c20:GeneralConverter[T20]):CollSeq20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple20(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)), c19.convert (x(18)), c20.convert (x(19)))) 
    CollSeq20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](q.toSeq)
  }
  
}

/**
 * A file to CollSeq21 parser
 */
class CsvParser21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq21 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18], c19:GeneralConverter[T19], c20:GeneralConverter[T20], c21:GeneralConverter[T21]):CollSeq21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple21(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)), c19.convert (x(18)), c20.convert (x(19)), c21.convert (x(20)))) 
    CollSeq21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](q.toSeq)
  }
  
}

/**
 * A file to CollSeq22 parser
 */
class CsvParser22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] extends CsvParser {

/**
 * Parse a csv file.
 * @param filename: The file name
 * @param delimiter: The delimiter. Use \t for tabs
 * @param quoteChar: The character used for quoted text.
 * @param hasHeader: Whether to skip the first line or not.
 *
 * @return a CollSeq22 containing the parsed data
 */
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18], c19:GeneralConverter[T19], c20:GeneralConverter[T20], c21:GeneralConverter[T21], c22:GeneralConverter[T22]):CollSeq22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]={
    val p = Csv2.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple22(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)), c19.convert (x(18)), c20.convert (x(19)), c21.convert (x(20)), c22.convert (x(21)))) 
    CollSeq22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](q.toSeq)
  }
  
} 