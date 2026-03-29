package tightbound

import scala.compiletime.ops.boolean.*
import scala.compiletime.ops.int.*

type Evidence[Condition <: Boolean] = Condition =:= true

infix type IsIndexFor[I <: Int, Size <: Int] = I >= 0 && Size > I

private[tightbound] def guaranteed[Condition <: Boolean]: Evidence[Condition] =
  <:<.refl.asInstanceOf[Evidence[Condition]]

private[tightbound] def sameGuaranteed[A, B]: =:=[A, B] = <:<.refl.asInstanceOf
