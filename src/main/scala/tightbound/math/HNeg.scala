package tightbound.math

trait HNeg[-A, +B]:
  def negate(a: A): B

object HNeg:
  type Neg[A] = HNeg[A, A]

  extension [A, B](a: A) def unary_-(using n: HNeg[A, B]): B = n.negate(a)

  import tightbound.math.Zero
  import tightbound.math.aliases.Sub
  import tightbound.math.syntax.*
  given [A](using Zero[A], Sub[A]): Neg[A] = a => Zero.of[A] - a
