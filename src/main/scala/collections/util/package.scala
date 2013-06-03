package org.catch22.collections

/**
 * ==Statistics Classes==
 * 
 * Implicit conversions in package object org.catch22.collections 
 * make the following promotions available:
 * 
 *  - Seq[Numeric] => Stats[Numeric]
 *  - Seq[(Numeric,Numeric)] => WeightedStats[Numeric,Numeric]
 *  
 * The classes [[org.catch22.collections.util.Stats]] and [[org.catch22.collections.util.WeightedStats]] 
 * make methods like mean, variance, and stdDev available. 
 *  
 * ===Example===
 * {{{import org.catch22.collections.io._
 * import org.catch22.collections._
 * Welcome to Scala version 2.10.1 (OpenJDK Server VM, Java 1.7.0_21).
 * Type in expressions to have them evaluated.
 * Type :help for more information.
 * 
 * scala> Seq(1,2,3).mean
 * res0: Double = 2.0
 * 
 * scala> CollSeq((1,2),(2,1),(3,3)).mean
 * res1: Double = 2.1666666666666665
 * 
 * scala> (2.0+2.0+9.0)/6.0
 * res2: Double = 2.1666666666666665}}}
 */
package object util 