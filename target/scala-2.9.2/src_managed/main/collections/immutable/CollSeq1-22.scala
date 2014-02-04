/*
 * product-collections is distributed under the 2-Clause BSD license. See the 
 * LICENSE file in the root of the repository.
 *
 * Copyright (c) 2013 Mark Lister
 */

package org.catch22.collections
package immutable
 
import collection.IndexedSeqLike
import collection.mutable.Builder
import collection.generic.CanBuildFrom
import collection.immutable.VectorBuilder
import collection.GenIterable
import collection.GenTraversableOnce
import collection.TraversableOnce
import org.catch22.collections.util.Tuple23

/**
 * A CollSeq holds 2D Typed Data.
 * A CollSeq is both an IndexedSeq[Product] and a Product (Tuple)
 * 
 */
 
sealed abstract class CollSeq extends IndexedSeq[Product] 
{
    override def toString= "CollSeq("+
      this.mkString(",\n        ")+")"
}

object CollSeq {
  def apply[T1](s:Product1[T1] *)= CollSeq1(s)
  def apply[T1, T2](s:Product2[T1, T2] *)= CollSeq2(s)
  def apply[T1, T2, T3](s:Product3[T1, T2, T3] *)= CollSeq3(s)
  def apply[T1, T2, T3, T4](s:Product4[T1, T2, T3, T4] *)= CollSeq4(s)
  def apply[T1, T2, T3, T4, T5](s:Product5[T1, T2, T3, T4, T5] *)= CollSeq5(s)
  def apply[T1, T2, T3, T4, T5, T6](s:Product6[T1, T2, T3, T4, T5, T6] *)= CollSeq6(s)
  def apply[T1, T2, T3, T4, T5, T6, T7](s:Product7[T1, T2, T3, T4, T5, T6, T7] *)= CollSeq7(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8](s:Product8[T1, T2, T3, T4, T5, T6, T7, T8] *)= CollSeq8(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9](s:Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9] *)= CollSeq9(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](s:Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] *)= CollSeq10(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11](s:Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] *)= CollSeq11(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12](s:Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] *)= CollSeq12(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13](s:Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] *)= CollSeq13(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14](s:Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] *)= CollSeq14(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15](s:Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] *)= CollSeq15(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16](s:Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] *)= CollSeq16(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17](s:Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] *)= CollSeq17(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18](s:Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] *)= CollSeq18(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19](s:Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] *)= CollSeq19(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20](s:Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] *)= CollSeq20(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21](s:Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] *)= CollSeq21(s)
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22](s:Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] *)= CollSeq22(s)


implicit def canBuildFrom1[T1]: CanBuildFrom[IndexedSeq[Product], Product1[T1], CollSeq1[T1]] = 
    new CanBuildFrom[IndexedSeq[Product], Product1[T1], CollSeq1[T1]] {
      def apply(): Builder[Product1[T1], CollSeq1[T1]] = CollSeq1.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product1[T1], CollSeq1[T1]] = CollSeq1.newBuilder
    }
  
implicit def canBuildFrom2[T1, T2]: CanBuildFrom[IndexedSeq[Product], Product2[T1, T2], CollSeq2[T1, T2]] = 
    new CanBuildFrom[IndexedSeq[Product], Product2[T1, T2], CollSeq2[T1, T2]] {
      def apply(): Builder[Product2[T1, T2], CollSeq2[T1, T2]] = CollSeq2.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product2[T1, T2], CollSeq2[T1, T2]] = CollSeq2.newBuilder
    }
  
implicit def canBuildFrom3[T1, T2, T3]: CanBuildFrom[IndexedSeq[Product], Product3[T1, T2, T3], CollSeq3[T1, T2, T3]] = 
    new CanBuildFrom[IndexedSeq[Product], Product3[T1, T2, T3], CollSeq3[T1, T2, T3]] {
      def apply(): Builder[Product3[T1, T2, T3], CollSeq3[T1, T2, T3]] = CollSeq3.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product3[T1, T2, T3], CollSeq3[T1, T2, T3]] = CollSeq3.newBuilder
    }
  
implicit def canBuildFrom4[T1, T2, T3, T4]: CanBuildFrom[IndexedSeq[Product], Product4[T1, T2, T3, T4], CollSeq4[T1, T2, T3, T4]] = 
    new CanBuildFrom[IndexedSeq[Product], Product4[T1, T2, T3, T4], CollSeq4[T1, T2, T3, T4]] {
      def apply(): Builder[Product4[T1, T2, T3, T4], CollSeq4[T1, T2, T3, T4]] = CollSeq4.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product4[T1, T2, T3, T4], CollSeq4[T1, T2, T3, T4]] = CollSeq4.newBuilder
    }
  
implicit def canBuildFrom5[T1, T2, T3, T4, T5]: CanBuildFrom[IndexedSeq[Product], Product5[T1, T2, T3, T4, T5], CollSeq5[T1, T2, T3, T4, T5]] = 
    new CanBuildFrom[IndexedSeq[Product], Product5[T1, T2, T3, T4, T5], CollSeq5[T1, T2, T3, T4, T5]] {
      def apply(): Builder[Product5[T1, T2, T3, T4, T5], CollSeq5[T1, T2, T3, T4, T5]] = CollSeq5.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product5[T1, T2, T3, T4, T5], CollSeq5[T1, T2, T3, T4, T5]] = CollSeq5.newBuilder
    }
  
implicit def canBuildFrom6[T1, T2, T3, T4, T5, T6]: CanBuildFrom[IndexedSeq[Product], Product6[T1, T2, T3, T4, T5, T6], CollSeq6[T1, T2, T3, T4, T5, T6]] = 
    new CanBuildFrom[IndexedSeq[Product], Product6[T1, T2, T3, T4, T5, T6], CollSeq6[T1, T2, T3, T4, T5, T6]] {
      def apply(): Builder[Product6[T1, T2, T3, T4, T5, T6], CollSeq6[T1, T2, T3, T4, T5, T6]] = CollSeq6.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product6[T1, T2, T3, T4, T5, T6], CollSeq6[T1, T2, T3, T4, T5, T6]] = CollSeq6.newBuilder
    }
  
implicit def canBuildFrom7[T1, T2, T3, T4, T5, T6, T7]: CanBuildFrom[IndexedSeq[Product], Product7[T1, T2, T3, T4, T5, T6, T7], CollSeq7[T1, T2, T3, T4, T5, T6, T7]] = 
    new CanBuildFrom[IndexedSeq[Product], Product7[T1, T2, T3, T4, T5, T6, T7], CollSeq7[T1, T2, T3, T4, T5, T6, T7]] {
      def apply(): Builder[Product7[T1, T2, T3, T4, T5, T6, T7], CollSeq7[T1, T2, T3, T4, T5, T6, T7]] = CollSeq7.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product7[T1, T2, T3, T4, T5, T6, T7], CollSeq7[T1, T2, T3, T4, T5, T6, T7]] = CollSeq7.newBuilder
    }
  
implicit def canBuildFrom8[T1, T2, T3, T4, T5, T6, T7, T8]: CanBuildFrom[IndexedSeq[Product], Product8[T1, T2, T3, T4, T5, T6, T7, T8], CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8]] = 
    new CanBuildFrom[IndexedSeq[Product], Product8[T1, T2, T3, T4, T5, T6, T7, T8], CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8]] {
      def apply(): Builder[Product8[T1, T2, T3, T4, T5, T6, T7, T8], CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8]] = CollSeq8.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product8[T1, T2, T3, T4, T5, T6, T7, T8], CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8]] = CollSeq8.newBuilder
    }
  
implicit def canBuildFrom9[T1, T2, T3, T4, T5, T6, T7, T8, T9]: CanBuildFrom[IndexedSeq[Product], Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9], CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9]] = 
    new CanBuildFrom[IndexedSeq[Product], Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9], CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9]] {
      def apply(): Builder[Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9], CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9]] = CollSeq9.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9], CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9]] = CollSeq9.newBuilder
    }
  
implicit def canBuildFrom10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]: CanBuildFrom[IndexedSeq[Product], Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10], CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]] = 
    new CanBuildFrom[IndexedSeq[Product], Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10], CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]] {
      def apply(): Builder[Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10], CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]] = CollSeq10.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10], CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]] = CollSeq10.newBuilder
    }
  
implicit def canBuildFrom11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]: CanBuildFrom[IndexedSeq[Product], Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11], CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]] = 
    new CanBuildFrom[IndexedSeq[Product], Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11], CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]] {
      def apply(): Builder[Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11], CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]] = CollSeq11.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11], CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]] = CollSeq11.newBuilder
    }
  
implicit def canBuildFrom12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]: CanBuildFrom[IndexedSeq[Product], Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12], CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]] = 
    new CanBuildFrom[IndexedSeq[Product], Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12], CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]] {
      def apply(): Builder[Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12], CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]] = CollSeq12.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12], CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]] = CollSeq12.newBuilder
    }
  
implicit def canBuildFrom13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]: CanBuildFrom[IndexedSeq[Product], Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13], CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]] = 
    new CanBuildFrom[IndexedSeq[Product], Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13], CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]] {
      def apply(): Builder[Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13], CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]] = CollSeq13.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13], CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]] = CollSeq13.newBuilder
    }
  
implicit def canBuildFrom14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]: CanBuildFrom[IndexedSeq[Product], Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14], CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]] = 
    new CanBuildFrom[IndexedSeq[Product], Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14], CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]] {
      def apply(): Builder[Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14], CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]] = CollSeq14.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14], CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]] = CollSeq14.newBuilder
    }
  
implicit def canBuildFrom15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]: CanBuildFrom[IndexedSeq[Product], Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15], CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]] = 
    new CanBuildFrom[IndexedSeq[Product], Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15], CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]] {
      def apply(): Builder[Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15], CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]] = CollSeq15.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15], CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]] = CollSeq15.newBuilder
    }
  
implicit def canBuildFrom16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]: CanBuildFrom[IndexedSeq[Product], Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16], CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]] = 
    new CanBuildFrom[IndexedSeq[Product], Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16], CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]] {
      def apply(): Builder[Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16], CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]] = CollSeq16.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16], CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]] = CollSeq16.newBuilder
    }
  
implicit def canBuildFrom17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]: CanBuildFrom[IndexedSeq[Product], Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17], CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]] = 
    new CanBuildFrom[IndexedSeq[Product], Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17], CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]] {
      def apply(): Builder[Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17], CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]] = CollSeq17.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17], CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]] = CollSeq17.newBuilder
    }
  
implicit def canBuildFrom18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]: CanBuildFrom[IndexedSeq[Product], Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18], CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]] = 
    new CanBuildFrom[IndexedSeq[Product], Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18], CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]] {
      def apply(): Builder[Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18], CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]] = CollSeq18.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18], CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]] = CollSeq18.newBuilder
    }
  
implicit def canBuildFrom19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]: CanBuildFrom[IndexedSeq[Product], Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19], CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]] = 
    new CanBuildFrom[IndexedSeq[Product], Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19], CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]] {
      def apply(): Builder[Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19], CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]] = CollSeq19.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19], CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]] = CollSeq19.newBuilder
    }
  
implicit def canBuildFrom20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]: CanBuildFrom[IndexedSeq[Product], Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20], CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]] = 
    new CanBuildFrom[IndexedSeq[Product], Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20], CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]] {
      def apply(): Builder[Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20], CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]] = CollSeq20.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20], CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]] = CollSeq20.newBuilder
    }
  
implicit def canBuildFrom21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]: CanBuildFrom[IndexedSeq[Product], Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21], CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]] = 
    new CanBuildFrom[IndexedSeq[Product], Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21], CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]] {
      def apply(): Builder[Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21], CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]] = CollSeq21.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21], CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]] = CollSeq21.newBuilder
    }
  
implicit def canBuildFrom22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]: CanBuildFrom[IndexedSeq[Product], Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22], CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]] = 
    new CanBuildFrom[IndexedSeq[Product], Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22], CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]] {
      def apply(): Builder[Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22], CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]] = CollSeq22.newBuilder
      def apply(from: IndexedSeq[Product]): Builder[Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22], CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]] = CollSeq22.newBuilder
    }
  

}

class CollSeq1[T1] private (val underlying:Seq[Product1[T1]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product1[T1]] 
     with IndexedSeqLike[Product1[T1],CollSeq1[T1]]
     with Product1[Seq[T1]]
{
    override protected [this] def newBuilder: Builder[Product1[T1],CollSeq1[T1]]= CollSeq1.newBuilder
    override def apply(idx: Int): Product1[T1] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq1[T1], Tuple2[T1,B], CollSeq2[T1,B]]): CollSeq2[T1,B] = {
      val b:Builder[Tuple2[T1,B],CollSeq2[T1,B]] = CollSeq2.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple2(t._1 ,those.next)
      }
      b.result
    }

}
object CollSeq1 {
  def apply[T1] (x:Seq[Product1[T1]])= new CollSeq1(x)
  def newBuilder[T1]: Builder[Product1[T1], CollSeq1[T1]] = new VectorBuilder mapResult apply
}


class CollSeq2[T1, T2] private (val underlying:Seq[Product2[T1, T2]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product2[T1, T2]] 
     with IndexedSeqLike[Product2[T1, T2],CollSeq2[T1, T2]]
     with Product2[Seq[T1], Seq[T2]]
{
    override protected [this] def newBuilder: Builder[Product2[T1, T2],CollSeq2[T1, T2]]= CollSeq2.newBuilder
    override def apply(idx: Int): Product2[T1, T2] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq2[T1, T2], Tuple3[T1, T2,B], CollSeq3[T1, T2,B]]): CollSeq3[T1, T2,B] = {
      val b:Builder[Tuple3[T1, T2,B],CollSeq3[T1, T2,B]] = CollSeq3.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple3(t._1, t._2 ,those.next)
      }
      b.result
    }

}
object CollSeq2 {
  def apply[T1, T2] (x:Seq[Product2[T1, T2]])= new CollSeq2(x)
  def newBuilder[T1, T2]: Builder[Product2[T1, T2], CollSeq2[T1, T2]] = new VectorBuilder mapResult apply
}


class CollSeq3[T1, T2, T3] private (val underlying:Seq[Product3[T1, T2, T3]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product3[T1, T2, T3]] 
     with IndexedSeqLike[Product3[T1, T2, T3],CollSeq3[T1, T2, T3]]
     with Product3[Seq[T1], Seq[T2], Seq[T3]]
{
    override protected [this] def newBuilder: Builder[Product3[T1, T2, T3],CollSeq3[T1, T2, T3]]= CollSeq3.newBuilder
    override def apply(idx: Int): Product3[T1, T2, T3] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq3[T1, T2, T3], Tuple4[T1, T2, T3,B], CollSeq4[T1, T2, T3,B]]): CollSeq4[T1, T2, T3,B] = {
      val b:Builder[Tuple4[T1, T2, T3,B],CollSeq4[T1, T2, T3,B]] = CollSeq4.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple4(t._1, t._2, t._3 ,those.next)
      }
      b.result
    }

}
object CollSeq3 {
  def apply[T1, T2, T3] (x:Seq[Product3[T1, T2, T3]])= new CollSeq3(x)
  def newBuilder[T1, T2, T3]: Builder[Product3[T1, T2, T3], CollSeq3[T1, T2, T3]] = new VectorBuilder mapResult apply
}


class CollSeq4[T1, T2, T3, T4] private (val underlying:Seq[Product4[T1, T2, T3, T4]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product4[T1, T2, T3, T4]] 
     with IndexedSeqLike[Product4[T1, T2, T3, T4],CollSeq4[T1, T2, T3, T4]]
     with Product4[Seq[T1], Seq[T2], Seq[T3], Seq[T4]]
{
    override protected [this] def newBuilder: Builder[Product4[T1, T2, T3, T4],CollSeq4[T1, T2, T3, T4]]= CollSeq4.newBuilder
    override def apply(idx: Int): Product4[T1, T2, T3, T4] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq4[T1, T2, T3, T4], Tuple5[T1, T2, T3, T4,B], CollSeq5[T1, T2, T3, T4,B]]): CollSeq5[T1, T2, T3, T4,B] = {
      val b:Builder[Tuple5[T1, T2, T3, T4,B],CollSeq5[T1, T2, T3, T4,B]] = CollSeq5.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple5(t._1, t._2, t._3, t._4 ,those.next)
      }
      b.result
    }

}
object CollSeq4 {
  def apply[T1, T2, T3, T4] (x:Seq[Product4[T1, T2, T3, T4]])= new CollSeq4(x)
  def newBuilder[T1, T2, T3, T4]: Builder[Product4[T1, T2, T3, T4], CollSeq4[T1, T2, T3, T4]] = new VectorBuilder mapResult apply
}


class CollSeq5[T1, T2, T3, T4, T5] private (val underlying:Seq[Product5[T1, T2, T3, T4, T5]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product5[T1, T2, T3, T4, T5]] 
     with IndexedSeqLike[Product5[T1, T2, T3, T4, T5],CollSeq5[T1, T2, T3, T4, T5]]
     with Product5[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5]]
{
    override protected [this] def newBuilder: Builder[Product5[T1, T2, T3, T4, T5],CollSeq5[T1, T2, T3, T4, T5]]= CollSeq5.newBuilder
    override def apply(idx: Int): Product5[T1, T2, T3, T4, T5] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq5[T1, T2, T3, T4, T5], Tuple6[T1, T2, T3, T4, T5,B], CollSeq6[T1, T2, T3, T4, T5,B]]): CollSeq6[T1, T2, T3, T4, T5,B] = {
      val b:Builder[Tuple6[T1, T2, T3, T4, T5,B],CollSeq6[T1, T2, T3, T4, T5,B]] = CollSeq6.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple6(t._1, t._2, t._3, t._4, t._5 ,those.next)
      }
      b.result
    }

}
object CollSeq5 {
  def apply[T1, T2, T3, T4, T5] (x:Seq[Product5[T1, T2, T3, T4, T5]])= new CollSeq5(x)
  def newBuilder[T1, T2, T3, T4, T5]: Builder[Product5[T1, T2, T3, T4, T5], CollSeq5[T1, T2, T3, T4, T5]] = new VectorBuilder mapResult apply
}


class CollSeq6[T1, T2, T3, T4, T5, T6] private (val underlying:Seq[Product6[T1, T2, T3, T4, T5, T6]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product6[T1, T2, T3, T4, T5, T6]] 
     with IndexedSeqLike[Product6[T1, T2, T3, T4, T5, T6],CollSeq6[T1, T2, T3, T4, T5, T6]]
     with Product6[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6]]
{
    override protected [this] def newBuilder: Builder[Product6[T1, T2, T3, T4, T5, T6],CollSeq6[T1, T2, T3, T4, T5, T6]]= CollSeq6.newBuilder
    override def apply(idx: Int): Product6[T1, T2, T3, T4, T5, T6] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq6[T1, T2, T3, T4, T5, T6], Tuple7[T1, T2, T3, T4, T5, T6,B], CollSeq7[T1, T2, T3, T4, T5, T6,B]]): CollSeq7[T1, T2, T3, T4, T5, T6,B] = {
      val b:Builder[Tuple7[T1, T2, T3, T4, T5, T6,B],CollSeq7[T1, T2, T3, T4, T5, T6,B]] = CollSeq7.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple7(t._1, t._2, t._3, t._4, t._5, t._6 ,those.next)
      }
      b.result
    }

}
object CollSeq6 {
  def apply[T1, T2, T3, T4, T5, T6] (x:Seq[Product6[T1, T2, T3, T4, T5, T6]])= new CollSeq6(x)
  def newBuilder[T1, T2, T3, T4, T5, T6]: Builder[Product6[T1, T2, T3, T4, T5, T6], CollSeq6[T1, T2, T3, T4, T5, T6]] = new VectorBuilder mapResult apply
}


class CollSeq7[T1, T2, T3, T4, T5, T6, T7] private (val underlying:Seq[Product7[T1, T2, T3, T4, T5, T6, T7]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product7[T1, T2, T3, T4, T5, T6, T7]] 
     with IndexedSeqLike[Product7[T1, T2, T3, T4, T5, T6, T7],CollSeq7[T1, T2, T3, T4, T5, T6, T7]]
     with Product7[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7]]
{
    override protected [this] def newBuilder: Builder[Product7[T1, T2, T3, T4, T5, T6, T7],CollSeq7[T1, T2, T3, T4, T5, T6, T7]]= CollSeq7.newBuilder
    override def apply(idx: Int): Product7[T1, T2, T3, T4, T5, T6, T7] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq7[T1, T2, T3, T4, T5, T6, T7], Tuple8[T1, T2, T3, T4, T5, T6, T7,B], CollSeq8[T1, T2, T3, T4, T5, T6, T7,B]]): CollSeq8[T1, T2, T3, T4, T5, T6, T7,B] = {
      val b:Builder[Tuple8[T1, T2, T3, T4, T5, T6, T7,B],CollSeq8[T1, T2, T3, T4, T5, T6, T7,B]] = CollSeq8.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple8(t._1, t._2, t._3, t._4, t._5, t._6, t._7 ,those.next)
      }
      b.result
    }

}
object CollSeq7 {
  def apply[T1, T2, T3, T4, T5, T6, T7] (x:Seq[Product7[T1, T2, T3, T4, T5, T6, T7]])= new CollSeq7(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7]: Builder[Product7[T1, T2, T3, T4, T5, T6, T7], CollSeq7[T1, T2, T3, T4, T5, T6, T7]] = new VectorBuilder mapResult apply
}


class CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8] private (val underlying:Seq[Product8[T1, T2, T3, T4, T5, T6, T7, T8]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product8[T1, T2, T3, T4, T5, T6, T7, T8]] 
     with IndexedSeqLike[Product8[T1, T2, T3, T4, T5, T6, T7, T8],CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8]]
     with Product8[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8]]
{
    override protected [this] def newBuilder: Builder[Product8[T1, T2, T3, T4, T5, T6, T7, T8],CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8]]= CollSeq8.newBuilder
    override def apply(idx: Int): Product8[T1, T2, T3, T4, T5, T6, T7, T8] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8], Tuple9[T1, T2, T3, T4, T5, T6, T7, T8,B], CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8,B]]): CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8,B] = {
      val b:Builder[Tuple9[T1, T2, T3, T4, T5, T6, T7, T8,B],CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8,B]] = CollSeq9.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple9(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8 ,those.next)
      }
      b.result
    }

}
object CollSeq8 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8] (x:Seq[Product8[T1, T2, T3, T4, T5, T6, T7, T8]])= new CollSeq8(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8]: Builder[Product8[T1, T2, T3, T4, T5, T6, T7, T8], CollSeq8[T1, T2, T3, T4, T5, T6, T7, T8]] = new VectorBuilder mapResult apply
}


class CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9] private (val underlying:Seq[Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9]] 
     with IndexedSeqLike[Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9],CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9]]
     with Product9[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9]]
{
    override protected [this] def newBuilder: Builder[Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9],CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9]]= CollSeq9.newBuilder
    override def apply(idx: Int): Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9], Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9,B], CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9,B]]): CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9,B] = {
      val b:Builder[Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9,B],CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9,B]] = CollSeq10.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple10(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9 ,those.next)
      }
      b.result
    }

}
object CollSeq9 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9] (x:Seq[Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9]])= new CollSeq9(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9]: Builder[Product9[T1, T2, T3, T4, T5, T6, T7, T8, T9], CollSeq9[T1, T2, T3, T4, T5, T6, T7, T8, T9]] = new VectorBuilder mapResult apply
}


class CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] private (val underlying:Seq[Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]] 
     with IndexedSeqLike[Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10],CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]]
     with Product10[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10]]
{
    override protected [this] def newBuilder: Builder[Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10],CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]]= CollSeq10.newBuilder
    override def apply(idx: Int): Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10], Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10,B], CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10,B]]): CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10,B] = {
      val b:Builder[Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10,B],CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10,B]] = CollSeq11.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple11(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10 ,those.next)
      }
      b.result
    }

}
object CollSeq10 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10] (x:Seq[Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]])= new CollSeq10(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]: Builder[Product10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10], CollSeq10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]] = new VectorBuilder mapResult apply
}


class CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] private (val underlying:Seq[Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]] 
     with IndexedSeqLike[Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11],CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]]
     with Product11[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11]]
{
    override protected [this] def newBuilder: Builder[Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11],CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]]= CollSeq11.newBuilder
    override def apply(idx: Int): Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11], Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11,B], CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11,B]]): CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11,B] = {
      val b:Builder[Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11,B],CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11,B]] = CollSeq12.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple12(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11 ,those.next)
      }
      b.result
    }

}
object CollSeq11 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11] (x:Seq[Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]])= new CollSeq11(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]: Builder[Product11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11], CollSeq11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]] = new VectorBuilder mapResult apply
}


class CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] private (val underlying:Seq[Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]] 
     with IndexedSeqLike[Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12],CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]]
     with Product12[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12]]
{
    override protected [this] def newBuilder: Builder[Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12],CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]]= CollSeq12.newBuilder
    override def apply(idx: Int): Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12], Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12,B], CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12,B]]): CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12,B] = {
      val b:Builder[Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12,B],CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12,B]] = CollSeq13.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple13(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12 ,those.next)
      }
      b.result
    }

}
object CollSeq12 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12] (x:Seq[Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]])= new CollSeq12(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]: Builder[Product12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12], CollSeq12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]] = new VectorBuilder mapResult apply
}


class CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] private (val underlying:Seq[Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]] 
     with IndexedSeqLike[Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13],CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]]
     with Product13[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13]]
{
    override protected [this] def newBuilder: Builder[Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13],CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]]= CollSeq13.newBuilder
    override def apply(idx: Int): Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13], Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13,B], CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13,B]]): CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13,B] = {
      val b:Builder[Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13,B],CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13,B]] = CollSeq14.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple14(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13 ,those.next)
      }
      b.result
    }

}
object CollSeq13 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13] (x:Seq[Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]])= new CollSeq13(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]: Builder[Product13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13], CollSeq13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]] = new VectorBuilder mapResult apply
}


class CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] private (val underlying:Seq[Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]] 
     with IndexedSeqLike[Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14],CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]]
     with Product14[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13], Seq[T14]]
{
    override protected [this] def newBuilder: Builder[Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14],CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]]= CollSeq14.newBuilder
    override def apply(idx: Int): Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)
    override def _14:Seq[T14]=collection.immutable.Seq(underlying.map(_._14): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14], Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14,B], CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14,B]]): CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14,B] = {
      val b:Builder[Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14,B],CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14,B]] = CollSeq15.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple15(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14 ,those.next)
      }
      b.result
    }

}
object CollSeq14 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14] (x:Seq[Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]])= new CollSeq14(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]: Builder[Product14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14], CollSeq14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]] = new VectorBuilder mapResult apply
}


class CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] private (val underlying:Seq[Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]] 
     with IndexedSeqLike[Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15],CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]]
     with Product15[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13], Seq[T14], Seq[T15]]
{
    override protected [this] def newBuilder: Builder[Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15],CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]]= CollSeq15.newBuilder
    override def apply(idx: Int): Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)
    override def _14:Seq[T14]=collection.immutable.Seq(underlying.map(_._14): _*)
    override def _15:Seq[T15]=collection.immutable.Seq(underlying.map(_._15): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15], Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15,B], CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15,B]]): CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15,B] = {
      val b:Builder[Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15,B],CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15,B]] = CollSeq16.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple16(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15 ,those.next)
      }
      b.result
    }

}
object CollSeq15 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15] (x:Seq[Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]])= new CollSeq15(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]: Builder[Product15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15], CollSeq15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]] = new VectorBuilder mapResult apply
}


class CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] private (val underlying:Seq[Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]] 
     with IndexedSeqLike[Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16],CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]]
     with Product16[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13], Seq[T14], Seq[T15], Seq[T16]]
{
    override protected [this] def newBuilder: Builder[Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16],CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]]= CollSeq16.newBuilder
    override def apply(idx: Int): Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)
    override def _14:Seq[T14]=collection.immutable.Seq(underlying.map(_._14): _*)
    override def _15:Seq[T15]=collection.immutable.Seq(underlying.map(_._15): _*)
    override def _16:Seq[T16]=collection.immutable.Seq(underlying.map(_._16): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16], Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16,B], CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16,B]]): CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16,B] = {
      val b:Builder[Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16,B],CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16,B]] = CollSeq17.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple17(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16 ,those.next)
      }
      b.result
    }

}
object CollSeq16 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16] (x:Seq[Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]])= new CollSeq16(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]: Builder[Product16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16], CollSeq16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]] = new VectorBuilder mapResult apply
}


class CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] private (val underlying:Seq[Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]] 
     with IndexedSeqLike[Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17],CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]]
     with Product17[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13], Seq[T14], Seq[T15], Seq[T16], Seq[T17]]
{
    override protected [this] def newBuilder: Builder[Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17],CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]]= CollSeq17.newBuilder
    override def apply(idx: Int): Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)
    override def _14:Seq[T14]=collection.immutable.Seq(underlying.map(_._14): _*)
    override def _15:Seq[T15]=collection.immutable.Seq(underlying.map(_._15): _*)
    override def _16:Seq[T16]=collection.immutable.Seq(underlying.map(_._16): _*)
    override def _17:Seq[T17]=collection.immutable.Seq(underlying.map(_._17): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17], Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17,B], CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17,B]]): CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17,B] = {
      val b:Builder[Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17,B],CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17,B]] = CollSeq18.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple18(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17 ,those.next)
      }
      b.result
    }

}
object CollSeq17 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17] (x:Seq[Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]])= new CollSeq17(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]: Builder[Product17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17], CollSeq17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]] = new VectorBuilder mapResult apply
}


class CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] private (val underlying:Seq[Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]] 
     with IndexedSeqLike[Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18],CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]]
     with Product18[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13], Seq[T14], Seq[T15], Seq[T16], Seq[T17], Seq[T18]]
{
    override protected [this] def newBuilder: Builder[Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18],CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]]= CollSeq18.newBuilder
    override def apply(idx: Int): Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)
    override def _14:Seq[T14]=collection.immutable.Seq(underlying.map(_._14): _*)
    override def _15:Seq[T15]=collection.immutable.Seq(underlying.map(_._15): _*)
    override def _16:Seq[T16]=collection.immutable.Seq(underlying.map(_._16): _*)
    override def _17:Seq[T17]=collection.immutable.Seq(underlying.map(_._17): _*)
    override def _18:Seq[T18]=collection.immutable.Seq(underlying.map(_._18): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18], Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18,B], CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18,B]]): CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18,B] = {
      val b:Builder[Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18,B],CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18,B]] = CollSeq19.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple19(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18 ,those.next)
      }
      b.result
    }

}
object CollSeq18 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18] (x:Seq[Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]])= new CollSeq18(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]: Builder[Product18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18], CollSeq18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]] = new VectorBuilder mapResult apply
}


class CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] private (val underlying:Seq[Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]] 
     with IndexedSeqLike[Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19],CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]]
     with Product19[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13], Seq[T14], Seq[T15], Seq[T16], Seq[T17], Seq[T18], Seq[T19]]
{
    override protected [this] def newBuilder: Builder[Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19],CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]]= CollSeq19.newBuilder
    override def apply(idx: Int): Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)
    override def _14:Seq[T14]=collection.immutable.Seq(underlying.map(_._14): _*)
    override def _15:Seq[T15]=collection.immutable.Seq(underlying.map(_._15): _*)
    override def _16:Seq[T16]=collection.immutable.Seq(underlying.map(_._16): _*)
    override def _17:Seq[T17]=collection.immutable.Seq(underlying.map(_._17): _*)
    override def _18:Seq[T18]=collection.immutable.Seq(underlying.map(_._18): _*)
    override def _19:Seq[T19]=collection.immutable.Seq(underlying.map(_._19): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19], Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19,B], CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19,B]]): CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19,B] = {
      val b:Builder[Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19,B],CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19,B]] = CollSeq20.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple20(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19 ,those.next)
      }
      b.result
    }

}
object CollSeq19 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19] (x:Seq[Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]])= new CollSeq19(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]: Builder[Product19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19], CollSeq19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]] = new VectorBuilder mapResult apply
}


class CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] private (val underlying:Seq[Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]] 
     with IndexedSeqLike[Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20],CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]]
     with Product20[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13], Seq[T14], Seq[T15], Seq[T16], Seq[T17], Seq[T18], Seq[T19], Seq[T20]]
{
    override protected [this] def newBuilder: Builder[Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20],CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]]= CollSeq20.newBuilder
    override def apply(idx: Int): Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)
    override def _14:Seq[T14]=collection.immutable.Seq(underlying.map(_._14): _*)
    override def _15:Seq[T15]=collection.immutable.Seq(underlying.map(_._15): _*)
    override def _16:Seq[T16]=collection.immutable.Seq(underlying.map(_._16): _*)
    override def _17:Seq[T17]=collection.immutable.Seq(underlying.map(_._17): _*)
    override def _18:Seq[T18]=collection.immutable.Seq(underlying.map(_._18): _*)
    override def _19:Seq[T19]=collection.immutable.Seq(underlying.map(_._19): _*)
    override def _20:Seq[T20]=collection.immutable.Seq(underlying.map(_._20): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20], Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20,B], CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20,B]]): CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20,B] = {
      val b:Builder[Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20,B],CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20,B]] = CollSeq21.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple21(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20 ,those.next)
      }
      b.result
    }

}
object CollSeq20 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20] (x:Seq[Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]])= new CollSeq20(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]: Builder[Product20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20], CollSeq20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]] = new VectorBuilder mapResult apply
}


class CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] private (val underlying:Seq[Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]] 
     with IndexedSeqLike[Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21],CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]]
     with Product21[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13], Seq[T14], Seq[T15], Seq[T16], Seq[T17], Seq[T18], Seq[T19], Seq[T20], Seq[T21]]
{
    override protected [this] def newBuilder: Builder[Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21],CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]]= CollSeq21.newBuilder
    override def apply(idx: Int): Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)
    override def _14:Seq[T14]=collection.immutable.Seq(underlying.map(_._14): _*)
    override def _15:Seq[T15]=collection.immutable.Seq(underlying.map(_._15): _*)
    override def _16:Seq[T16]=collection.immutable.Seq(underlying.map(_._16): _*)
    override def _17:Seq[T17]=collection.immutable.Seq(underlying.map(_._17): _*)
    override def _18:Seq[T18]=collection.immutable.Seq(underlying.map(_._18): _*)
    override def _19:Seq[T19]=collection.immutable.Seq(underlying.map(_._19): _*)
    override def _20:Seq[T20]=collection.immutable.Seq(underlying.map(_._20): _*)
    override def _21:Seq[T21]=collection.immutable.Seq(underlying.map(_._21): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21], Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21,B], CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21,B]]): CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21,B] = {
      val b:Builder[Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21,B],CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21,B]] = CollSeq22.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple22(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20, t._21 ,those.next)
      }
      b.result
    }

}
object CollSeq21 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21] (x:Seq[Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]])= new CollSeq21(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]: Builder[Product21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21], CollSeq21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]] = new VectorBuilder mapResult apply
}


class CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] private (val underlying:Seq[Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]]/*,val headers:Seq[String]*/) 
  extends CollSeq  
     with IndexedSeq[Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]] 
     with IndexedSeqLike[Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22],CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]]
     with Product22[Seq[T1], Seq[T2], Seq[T3], Seq[T4], Seq[T5], Seq[T6], Seq[T7], Seq[T8], Seq[T9], Seq[T10], Seq[T11], Seq[T12], Seq[T13], Seq[T14], Seq[T15], Seq[T16], Seq[T17], Seq[T18], Seq[T19], Seq[T20], Seq[T21], Seq[T22]]
{
    override protected [this] def newBuilder: Builder[Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22],CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]]= CollSeq22.newBuilder
    override def apply(idx: Int): Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] = underlying(idx)
    def length: Int = underlying.length
    override def _1:Seq[T1]=collection.immutable.Seq(underlying.map(_._1): _*)
    override def _2:Seq[T2]=collection.immutable.Seq(underlying.map(_._2): _*)
    override def _3:Seq[T3]=collection.immutable.Seq(underlying.map(_._3): _*)
    override def _4:Seq[T4]=collection.immutable.Seq(underlying.map(_._4): _*)
    override def _5:Seq[T5]=collection.immutable.Seq(underlying.map(_._5): _*)
    override def _6:Seq[T6]=collection.immutable.Seq(underlying.map(_._6): _*)
    override def _7:Seq[T7]=collection.immutable.Seq(underlying.map(_._7): _*)
    override def _8:Seq[T8]=collection.immutable.Seq(underlying.map(_._8): _*)
    override def _9:Seq[T9]=collection.immutable.Seq(underlying.map(_._9): _*)
    override def _10:Seq[T10]=collection.immutable.Seq(underlying.map(_._10): _*)
    override def _11:Seq[T11]=collection.immutable.Seq(underlying.map(_._11): _*)
    override def _12:Seq[T12]=collection.immutable.Seq(underlying.map(_._12): _*)
    override def _13:Seq[T13]=collection.immutable.Seq(underlying.map(_._13): _*)
    override def _14:Seq[T14]=collection.immutable.Seq(underlying.map(_._14): _*)
    override def _15:Seq[T15]=collection.immutable.Seq(underlying.map(_._15): _*)
    override def _16:Seq[T16]=collection.immutable.Seq(underlying.map(_._16): _*)
    override def _17:Seq[T17]=collection.immutable.Seq(underlying.map(_._17): _*)
    override def _18:Seq[T18]=collection.immutable.Seq(underlying.map(_._18): _*)
    override def _19:Seq[T19]=collection.immutable.Seq(underlying.map(_._19): _*)
    override def _20:Seq[T20]=collection.immutable.Seq(underlying.map(_._20): _*)
    override def _21:Seq[T21]=collection.immutable.Seq(underlying.map(_._21): _*)
    override def _22:Seq[T22]=collection.immutable.Seq(underlying.map(_._22): _*)

    def flatZip[B](that: GenIterable[B])(implicit bf: CanBuildFrom[CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22], Tuple23[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22,B], CollSeq23[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22,B]]): CollSeq23[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22,B] = {
      val b:Builder[Tuple23[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22,B],CollSeq23[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22,B]] = CollSeq23.newBuilder
      val these = this.iterator
      val those = that.iterator
      while (these.hasNext && those.hasNext){
        val t=these.next
        b += Tuple23(t._1, t._2, t._3, t._4, t._5, t._6, t._7, t._8, t._9, t._10, t._11, t._12, t._13, t._14, t._15, t._16, t._17, t._18, t._19, t._20, t._21, t._22 ,those.next)
      }
      b.result
    }

}
object CollSeq22 {
  def apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] (x:Seq[Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]])= new CollSeq22(x)
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]: Builder[Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22], CollSeq22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]] = new VectorBuilder mapResult apply
}


class CollSeq23[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23]  
  extends CollSeq  
{ 
  override def apply(idx: Int): Product22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22] =  throw new Exception("Tuples with more than 22 elements not supported")
  override protected [this] def newBuilder= throw new Exception("Tuples with more than 22 elements not supported")
  def length: Int = throw new Exception("Tuples with more than 22 elements not supported") 
}

private object CollSeq23 {
  
  def newBuilder[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23]
      : Builder[Tuple23[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23], 
      CollSeq23[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23]] = 
      throw new Exception("Tuples with more than 22 elements not supported")
}

 