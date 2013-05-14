package org.catch22.collections
package io

abstract class GeneralConverter[A] {
      def convert(x: String): A
    }

    object GeneralConverter {
      implicit object StringConv extends GeneralConverter[String] {
        def convert(x: String): String = x
      }
      implicit object IntConv extends GeneralConverter[Int] {
        def convert(x: String): Int = x.trim.toInt
      }
      implicit object LongConv extends GeneralConverter[Long] {
        def convert(x: String) = x.trim.toLong
      }
      implicit object ByteConv extends GeneralConverter[Byte] {
        def convert(x: String) = x.trim.toByte
      }
      implicit object ShortConv extends GeneralConverter[Short] {
        def convert(x: String) = x.trim.toShort
      }
      implicit object FloatConv extends GeneralConverter[Float] {
        def convert(x: String): Float = x.trim.toFloat
      }
      implicit object DoubleConv extends GeneralConverter[Double] {
        def convert(x: String): Double = x.trim.toDouble
      }
      implicit object BooleanConv extends GeneralConverter[Boolean] {
        def convert(x: String): Boolean = x.trim.toBoolean
      }
      class DateConv(pattern:String) extends GeneralConverter[java.util.Date]{
        val sdf=new java.text.SimpleDateFormat(pattern)
        def convert (x:String)= sdf.parse(x.trim)
      }
      val DMYConv = new DateConv("dd-MM-yy")
    
    }
