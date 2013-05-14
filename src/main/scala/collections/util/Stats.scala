package org.catch22.collections
package util
/*
 * A very simple class wrapping an Iterable and providing basic statistics
 * like mean and variance.
 * 
 * I saw something like this on the net but have been unable to locate it since.
 * 
 * When I do find it I will probably remove this class or at least wrap someone's
 * professional implementation  
 */

class Stats[A](underlying:Iterable[A])(implicit val num:Numeric[A]) {
  if(underlying.isEmpty) throw new Exception("Empty Seq")
   
  /**
   * The sum of all the elements
   */
  lazy val sum :A=underlying.foldLeft(num.zero)(num.plus)
  
  /**
   * The arithmetic mean of all the elements
   */ 
  lazy val mean :Double= num.toDouble(sum)/underlying.size.toDouble
  
  /**
   * The variance of all the elements (the one divided by n not n-1)
   */
  lazy val variance :Double = 
    underlying.foldLeft (0.0)((a,b)=>a+(num.toDouble(b)-mean)*(num.toDouble(b)-mean))/(underlying.size)
  
  /**
   * The standard deviation of all the elements
   */
  lazy val stdDev:Double= math.sqrt(variance)
}
