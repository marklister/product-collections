package org.catch22.collections
package io

abstract class GeneralConverter[A] {
      def convert(x: String): A
    }
    
class DateConverter(pattern:String) extends GeneralConverter[java.util.Date]{
        val sdf=new java.text.SimpleDateFormat(pattern)
        def convert (x:String)= sdf.parse(x.trim)
      }
      
    object GeneralConverter {
      implicit object StringConverter extends GeneralConverter[String] {
        def convert(x: String): String = x
      }
      implicit object IntConverter extends GeneralConverter[Int] {
        def convert(x: String): Int = x.trim.toInt
      }
      implicit object LongConverter extends GeneralConverter[Long] {
        def convert(x: String) = x.trim.toLong
      }
      implicit object ByteConverter extends GeneralConverter[Byte] {
        def convert(x: String) = x.trim.toByte
      }
      implicit object ShortConverter extends GeneralConverter[Short] {
        def convert(x: String) = x.trim.toShort
      }
      implicit object FloatConverter extends GeneralConverter[Float] {
        def convert(x: String): Float = x.trim.toFloat
      }
      implicit object DoubleConverter extends GeneralConverter[Double] {
        def convert(x: String): Double = x.trim.toDouble
      }
      implicit object BooleanConverter extends GeneralConverter[Boolean] {
        def convert(x: String): Boolean = x.trim.toBoolean
      }
      
      val DMYConverter = new DateConverter("dd-MM-yy")
    
    }
