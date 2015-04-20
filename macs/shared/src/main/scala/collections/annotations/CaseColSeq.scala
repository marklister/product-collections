package collections.annotations

import scala.collection.immutable.VectorBuilder
import scala.collection.{IndexedSeqLike, mutable}
import scala.language.experimental.macros


class CaseColSeq[T](val underlying: Seq[T] ) extends IndexedSeq[T] with IndexedSeqLike [T, CaseColSeq[T]]
 {
   override protected[this] def newBuilder = CaseColSeq.newBuilder
   override def apply (idx: Int): T = underlying (idx)
   lazy val length: Int = underlying.length
 }

object CaseColSeq {

   def apply[T] (x: Seq[T] ): CaseColSeq[T] = new CaseColSeq(x)
   def newBuilder[T]: mutable.Builder[T, CaseColSeq[T]] = new VectorBuilder mapResult apply
 }