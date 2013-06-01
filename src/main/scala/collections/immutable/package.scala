package org.catch22.collections

/**
 * ==Immutable product-collection datastructures==
 * 
 * At the moment the only structure available is a CollSeq
 * 
 * ===Creating===
 * Generally you use the companion object to construct the appropriate
 * CollSeq:
 * {{{
 * scala> CollSeq(("Jan",100,200),("Feb",120,230),("Mar",300,330))
 * res0: org.catch22.collections.immutable.CollSeq3[String,Int,Int] = 
 * CollSeq((Jan,100,200),
 *         (Feb,120,230),
 *         (Mar,300,330))
 * }}}
 * ===Extract a column===
 * {{{scala> res0._2
 * res1: Seq[Int] = List(100, 120, 300)
 * }}}
 * ===Assemble columns into a CollSeq===
 * {{{scala> res0._3.flatZip(res0._1).flatZip(res0._2)
 * res3: org.catch22.collections.immutable.CollSeq3[Int,String,Int] = 
 * CollSeq((200,Jan,100),
 *         (230,Feb,120),
 *         (330,Mar,300))}}}
 */
package object immutable {}