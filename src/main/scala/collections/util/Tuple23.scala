package org.catch22.collections
package util
/**
 * A Tuple23 is a stub that simply throws exceptions when you try to use it.
 * It exists because we use a very simple code generator.
 */
private[collections] class Tuple23 [+T1, +T2, +T3, +T4, +T5, +T6, +T7, +T8, +T9, +T10, +T11, +T12, +T13, +T14, +T15, +T16, +T17, +T18, +T19, +T20, +T21, +T22, +T23]
  extends Product {
  throw new Exception("Tuples with more than 22 elements not supported")
  val productArity=23
  def productElement(n:Int) = throw new Exception("Tuples with more than 22 elements not supported")
  def canEqual(that:Any) = throw new Exception("Tuples with more than 22 elements not supported")
}
/**
 * The Tuple23 companion object
 */
private[collections] object Tuple23{
  def apply (a1:Any *)=throw new Exception("Tuples with more than 22 elements not supported")
  
}
