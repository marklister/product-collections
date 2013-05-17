package org.catch22.collections
package io

import org.catch22.collections.immutable._
     
/*
 * Strongly typed Csv to Product[T22,T23,...Tn] Parser.
 */
abstract sealed class CsvParser


object CsvParser{
  def apply[T1]= new CsvParser1[T1]
  def apply[T1,T2]= new CsvParser2[T1,T2]
  def apply[T1,T2,T3]= new CsvParser3[T1,T2,T3]
  def apply[T1,T2,T3,T4]= new CsvParser4[T1,T2,T3,T4]
  def apply[T1,T2,T3,T4,T5]= new CsvParser5[T1,T2,T3,T4,T5]
  def apply[T1,T2,T3,T4,T5,T6]= new CsvParser6[T1,T2,T3,T4,T5,T6]
  def apply[T1,T2,T3,T4,T5,T6,T7]= new CsvParser7[T1,T2,T3,T4,T5,T6,T7]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8]= new CsvParser8[T1,T2,T3,T4,T5,T6,T7,T8]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9]= new CsvParser9[T1,T2,T3,T4,T5,T6,T7,T8,T9]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]= new CsvParser10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]= new CsvParser11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]= new CsvParser12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]= new CsvParser13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]= new CsvParser14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]= new CsvParser15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]= new CsvParser16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]= new CsvParser17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]= new CsvParser18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]= new CsvParser19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]= new CsvParser20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]= new CsvParser21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
  def apply[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]= new CsvParser22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
}

/*
 * A file -> Tuple1 parser
 */

class CsvParser1[T1] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1]):CollSeq1[T1]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple1(c1.convert (x(0)))) 
    CollSeq1[T1](q.toSeq)
  }
  
}

/*
 * A file -> Tuple2 parser
 */

class CsvParser2[T1,T2] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2]):CollSeq2[T1,T2]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple2(c1.convert (x(0)), c2.convert (x(1)))) 
    CollSeq2[T1,T2](q.toSeq)
  }
  
}

/*
 * A file -> Tuple3 parser
 */

class CsvParser3[T1,T2,T3] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3]):CollSeq3[T1,T2,T3]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple3(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)))) 
    CollSeq3[T1,T2,T3](q.toSeq)
  }
  
}

/*
 * A file -> Tuple4 parser
 */

class CsvParser4[T1,T2,T3,T4] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4]):CollSeq4[T1,T2,T3,T4]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple4(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)))) 
    CollSeq4[T1,T2,T3,T4](q.toSeq)
  }
  
}

/*
 * A file -> Tuple5 parser
 */

class CsvParser5[T1,T2,T3,T4,T5] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5]):CollSeq5[T1,T2,T3,T4,T5]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple5(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)))) 
    CollSeq5[T1,T2,T3,T4,T5](q.toSeq)
  }
  
}

/*
 * A file -> Tuple6 parser
 */

class CsvParser6[T1,T2,T3,T4,T5,T6] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6]):CollSeq6[T1,T2,T3,T4,T5,T6]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple6(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)))) 
    CollSeq6[T1,T2,T3,T4,T5,T6](q.toSeq)
  }
  
}

/*
 * A file -> Tuple7 parser
 */

class CsvParser7[T1,T2,T3,T4,T5,T6,T7] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7]):CollSeq7[T1,T2,T3,T4,T5,T6,T7]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple7(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)))) 
    CollSeq7[T1,T2,T3,T4,T5,T6,T7](q.toSeq)
  }
  
}

/*
 * A file -> Tuple8 parser
 */

class CsvParser8[T1,T2,T3,T4,T5,T6,T7,T8] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8]):CollSeq8[T1,T2,T3,T4,T5,T6,T7,T8]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple8(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)))) 
    CollSeq8[T1,T2,T3,T4,T5,T6,T7,T8](q.toSeq)
  }
  
}

/*
 * A file -> Tuple9 parser
 */

class CsvParser9[T1,T2,T3,T4,T5,T6,T7,T8,T9] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9]):CollSeq9[T1,T2,T3,T4,T5,T6,T7,T8,T9]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple9(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)))) 
    CollSeq9[T1,T2,T3,T4,T5,T6,T7,T8,T9](q.toSeq)
  }
  
}

/*
 * A file -> Tuple10 parser
 */

class CsvParser10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10]):CollSeq10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple10(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)))) 
    CollSeq10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](q.toSeq)
  }
  
}

/*
 * A file -> Tuple11 parser
 */

class CsvParser11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11]):CollSeq11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple11(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)))) 
    CollSeq11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](q.toSeq)
  }
  
}

/*
 * A file -> Tuple12 parser
 */

class CsvParser12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12]):CollSeq12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple12(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)))) 
    CollSeq12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](q.toSeq)
  }
  
}

/*
 * A file -> Tuple13 parser
 */

class CsvParser13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13]):CollSeq13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple13(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)))) 
    CollSeq13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](q.toSeq)
  }
  
}

/*
 * A file -> Tuple14 parser
 */

class CsvParser14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14]):CollSeq14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple14(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)))) 
    CollSeq14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](q.toSeq)
  }
  
}

/*
 * A file -> Tuple15 parser
 */

class CsvParser15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15]):CollSeq15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple15(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)))) 
    CollSeq15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](q.toSeq)
  }
  
}

/*
 * A file -> Tuple16 parser
 */

class CsvParser16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16]):CollSeq16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple16(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)))) 
    CollSeq16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](q.toSeq)
  }
  
}

/*
 * A file -> Tuple17 parser
 */

class CsvParser17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17]):CollSeq17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple17(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)))) 
    CollSeq17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](q.toSeq)
  }
  
}

/*
 * A file -> Tuple18 parser
 */

class CsvParser18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18]):CollSeq18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple18(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)))) 
    CollSeq18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](q.toSeq)
  }
  
}

/*
 * A file -> Tuple19 parser
 */

class CsvParser19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18], c19:GeneralConverter[T19]):CollSeq19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple19(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)), c19.convert (x(18)))) 
    CollSeq19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](q.toSeq)
  }
  
}

/*
 * A file -> Tuple20 parser
 */

class CsvParser20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18], c19:GeneralConverter[T19], c20:GeneralConverter[T20]):CollSeq20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple20(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)), c19.convert (x(18)), c20.convert (x(19)))) 
    CollSeq20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](q.toSeq)
  }
  
}

/*
 * A file -> Tuple21 parser
 */

class CsvParser21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18], c19:GeneralConverter[T19], c20:GeneralConverter[T20], c21:GeneralConverter[T21]):CollSeq21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple21(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)), c19.convert (x(18)), c20.convert (x(19)), c21.convert (x(20)))) 
    CollSeq21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](q.toSeq)
  }
  
}

/*
 * A file -> Tuple22 parser
 */

class CsvParser22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] extends CsvParser {
  def parseFile (filename: String,
    delimiter: String = ",",
    quoteChar: Char = '"',
    hasHeader: Boolean = false)(implicit c1:GeneralConverter[T1], c2:GeneralConverter[T2], c3:GeneralConverter[T3], c4:GeneralConverter[T4], c5:GeneralConverter[T5], c6:GeneralConverter[T6], c7:GeneralConverter[T7], c8:GeneralConverter[T8], c9:GeneralConverter[T9], c10:GeneralConverter[T10], c11:GeneralConverter[T11], c12:GeneralConverter[T12], c13:GeneralConverter[T13], c14:GeneralConverter[T14], c15:GeneralConverter[T15], c16:GeneralConverter[T16], c17:GeneralConverter[T17], c18:GeneralConverter[T18], c19:GeneralConverter[T19], c20:GeneralConverter[T20], c21:GeneralConverter[T21], c22:GeneralConverter[T22]):CollSeq22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]={
    val p = Csv.read(filename,delimiter,quoteChar,hasHeader)
    val q = p.map(x=>Tuple22(c1.convert (x(0)), c2.convert (x(1)), c3.convert (x(2)), c4.convert (x(3)), c5.convert (x(4)), c6.convert (x(5)), c7.convert (x(6)), c8.convert (x(7)), c9.convert (x(8)), c10.convert (x(9)), c11.convert (x(10)), c12.convert (x(11)), c13.convert (x(12)), c14.convert (x(13)), c15.convert (x(14)), c16.convert (x(15)), c17.convert (x(16)), c18.convert (x(17)), c19.convert (x(18)), c20.convert (x(19)), c21.convert (x(20)), c22.convert (x(21)))) 
    CollSeq22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](q.toSeq)
  }
  
} 