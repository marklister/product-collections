package org.catch22
import collections.immutable.{CollSeq1,CollSeq2}
import collections.util.Stats

package object collections {
  implicit def SeqToCollSeqTa[T](s:Seq[Product1[T]])=CollSeq1[T](s)
  implicit def SeqToCollSeqTb[Ta,Tb](s:Seq[Product2[Ta,Tb]])=CollSeq2[Ta,Tb](s)
  implicit def SeqToCollSeqTc[T](s:Seq[T])=CollSeq1(s.map(Tuple1[T](_)))
  
  type CollSeq=immutable.CollSeq
  val CollSeq=immutable.CollSeq
  
  implicit def SeqAToStatsA[A](s:Iterable[A])(implicit num:Numeric[A])= new Stats[A](s)
}
