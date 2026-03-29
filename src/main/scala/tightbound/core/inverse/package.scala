package tightbound.core

import tightbound.math.aliases.*
import tightbound.math.{One, Zero}
import tightbound.Matrix

package object inverse:
  trait InverseAlgorithm[Size <: Int]:
    def inv[A: Div: Mul: Sub: Add: Zero: One: Eq](matrix: Matrix[Size, Size, A]): Option[Matrix[Size, Size, A]]
