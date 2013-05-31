package org.catch22.collections
package io

/**
 * A General Converter is a wrapper for a function (s:String)=>t:T
 * 
 * This function is used by the CsvParser to parse fields of type T
 * 
 * There are several default converters defined or you can make your own
 * and make them available as implict parameters.
 * 
 * The reason we use a wrapper is to avoid any old (String)=>T function
 * being selected by mistake.  If you made a GeneralConverter then you 
 * almost certainly intended that the parser use it to convert type T.
 * 
 * Example:{{{
 *   implicit object ymd extends GeneralConverter[java.util.Date]{
 *     val f= new java.text.SimpleDateFormat("yy-MM-dd")
 *     def convert(x:String)=f.parse(x.trim)
 *   }
 *   }}}
 *   
 *   Note the above example is a bit contrived because a pre-existing
 *   DateConverter class exists.  See the [[DateConverter]] docs.
 */

abstract class GeneralConverter[A] {
      def convert(x: String): A
    }
    
/**
 * A converter for dates (intended to be used by CsvParser) using an underlying 
 * java.text.SimpleDateFormat.
 * 
 * You can create one like so:
 * {{{
 * implicit val ymd=new DateConverter("yyyy-MM-dd")
 * }}}
 * 
 * The compiler will then provide this converter to CsvParser whenever
 * you try to parse a java.util.Date
 */
class DateConverter(pattern:String) extends GeneralConverter[java.util.Date]{
        val sdf=new java.text.SimpleDateFormat(pattern)
        def convert (x:String)= sdf.parse(x.trim)
      }

/**
 * The companion class for GeneralConverter.  It contains several default
 * converters used by [[CsvParser]]
 */
    object GeneralConverter {
      /**
       * A [[GeneralConverter]] that converts a String to a String
       */
      implicit object StringConverter extends GeneralConverter[String] {
        def convert(x: String): String = x
      }
      /**
       * A [[GeneralConverter]] that converts a String to an Int
       */
      implicit object IntConverter extends GeneralConverter[Int] {
        def convert(x: String): Int = x.trim.toInt
      }
      /**
       * A [[GeneralConverter]] that converts a String to a Long
       */
      implicit object LongConverter extends GeneralConverter[Long] {
        def convert(x: String) = x.trim.toLong
      }
      /**
       * A [[GeneralConverter]] that converts a String to a Byte
       */
      implicit object ByteConverter extends GeneralConverter[Byte] {
        def convert(x: String) = x.trim.toByte
      }
      /**
       * A [[GeneralConverter]] that converts a String to a Short
       */
      implicit object ShortConverter extends GeneralConverter[Short] {
        def convert(x: String) = x.trim.toShort
      }
      /**
       * A [[GeneralConverter]] that converts a String to a Float
       */
      implicit object FloatConverter extends GeneralConverter[Float] {
        def convert(x: String): Float = x.trim.toFloat
      }
      /**
       * A [[GeneralConverter]] that converts a String to a Double
       */
      implicit object DoubleConverter extends GeneralConverter[Double] {
        def convert(x: String): Double = x.trim.toDouble
      }
      /**
       *A [[GeneralConverter]] that converts a String to a Boolean
       */
      implicit object BooleanConverter extends GeneralConverter[Boolean] {
        def convert(x: String): Boolean = x.trim.toBoolean
      }
      /**
       * A [[GeneralConverter]] that converts a String to a Date
       * 
       * This is provided as a prebuild example:  use it like this:
       * 
       * {{{
       * implicit val dmy=GeneralConverter.DMYConverter
       * }}}
       * 
       * The pattern used is dd-MM-yy
       */
      val DMYConverter = new DateConverter("dd-MM-yy")
    
    }
