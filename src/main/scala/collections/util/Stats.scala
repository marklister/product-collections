package org.catch22.collections
package util
/**

 * A very simple class wrapping an `Iterable` and providing basic statistics
 * like mean and variance.
 * 
 * There is an implicit conversion from a `Seq[A]` to a `Stats[A]` imported
 * with [[org.catch22.collections]].  So you do not need to do anything
 * to use this class.  Simply use the `mean`, `stdDev` or `variance`
 * methods on an appropriate sequence:
 * 
 * {{{
 * import org.catch22.collections.io._
 * import org.catch22.collections._
 * Welcome to Scala version 2.10.1 (OpenJDK Server VM, Java 1.7.0_21).
 * Type in expressions to have them evaluated.
 * Type :help for more information.
 * 
 * scala> Seq(1,2,3).mean
 * res0: Double = 2.0
 * }}} 
 * 
 * If you know of a library that performs this function please raise an 
 * issue on GitHub
 */

class Stats[A](underlying:Iterable[A])(implicit val num:Numeric[A]) {
  if(underlying.isEmpty) throw new Exception("Empty Seq")
  
  /**
   * The arithmetic mean of all the elements
   */ 
  lazy val mean :Double= num.toDouble(underlying.sum)/underlying.size.toDouble
  
  /**
   * The variance of all the elements (the one divided by n not n-1)
   */
  lazy val variance :Double = 
    underlying.foldLeft (0.0)((a,b)=>a+(num.toDouble(b)-mean)*
                              (num.toDouble(b)-mean))/(underlying.size)
  
  /**
   * The standard deviation of all the elements
   */
  lazy val stdDev:Double= math.sqrt(variance)
}
