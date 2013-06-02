package org.catch22.collections
package util
import math.pow
/**
 * A very simple class wrapping an `Iterable[Product2[A,B]]` and providing 
 * basic weighted statistics like weighted mean and weighted variance.
 * 
 * The first element of the Pair is the value and the second element the weight.
 * 
 * There is an implicit conversion from a `Seq[Product2[A,B]]` to a 
 * `WeightedStats[A,B]` imported with [[org.catch22.collections]].  So you do 
 * not need to do anything to use this class.  Simply use the `mean`, `stdDev` 
 * or `variance` methods on an appropriate sequence:
 * 
 * {{{import org.catch22.collections.io._
 * import org.catch22.collections._
 * Welcome to Scala version 2.10.1 (OpenJDK Server VM, Java 1.7.0_21).
 * Type in expressions to have them evaluated.
 * Type :help for more information.
 * 
 * scala> CollSeq((1,2),(2,1),(3,3)).mean
 * res1: Double = 2.1666666666666665}}}
 * 
 * I would really prefer to use an external library.  If you know of one please
 * raise an issue on Github
 */

class WeightedStats[A,B](underlying:Iterable[Product2[A,B]])(
  implicit private val numA:Numeric[A], implicit private val numB:Numeric[B]){
  if(underlying.isEmpty) throw new Exception("Empty Seq")
  
  private lazy val u = underlying
  /**
   * The weighted arithmetic mean of all the elements
   */ 
  lazy val mean :Double= 
    u.map(x=>(numA.toDouble(x._1), numB.toDouble(x._2)))
  .map(x=>x._1*x._2).sum / numB.toDouble(u.map(_._2).sum)
                      
  /**
   * The weighted variance of all the elements (the one divided by n not n-1)
   */
  lazy val variance :Double = 
    u.map (x=>pow(numA.toDouble(x._1)-mean,2)*numB.toDouble(x._2)).sum /
  numB.toDouble(u.map(_._2).sum)
  
  /**
   * The weighted standard deviation of all the elements
   */
  lazy val stdDev:Double= math.sqrt(variance)
}