package tightbound.matrix.core.inverse

import tightbound.math.aliases.*
import tightbound.math.syntax.*
import tightbound.math.{One, Zero}
import tightbound.matrix.core.LemmaConversions.{`S1 => S2 > 0`, `Vector[S1 <= S2, A]`}
import tightbound.matrix.core.determinant.{DeterminantAlgorithm, LaplaceExpansion}
import tightbound.matrix.lemmas.given
import tightbound.matrix.{Evidence, Matrix, Vector}

import scala.compiletime.ops.int.*

object DeterminantGaussianElimination:
  def inverse[S <: Int, A: Div: Mul: Sub: Add: Zero: One: Eq](
    matrix: Matrix[S, S, A],
    detAlg: DeterminantAlgorithm[S],
  ): Option[Matrix[S, S, A]] =
    Option.when(matrix.determinant(using detAlg) =!= Zero.of[A]):
      import matrix.heightEvidence as sizeEvidence
      val size: S    = matrix.height
      val augmented  = Matrix.identity[S, A](size).addLeft(matrix)
      val eliminated = augmented.rowEchelon
      eliminated.mapRows(_.drop(size)(using sizeEvidence))

  def on[Size <: Int](detAlg: DeterminantAlgorithm[Size] = LaplaceExpansion.on[Size]): InverseAlgorithm[Size] = new:
    def inv[A: Div: Mul: Sub: Add: Zero: One: Eq](matrix: Matrix[Size, Size, A]): Option[Matrix[Size, Size, A]] =
      inverse[Size, A](matrix, detAlg)
