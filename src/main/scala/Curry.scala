object Exercise4 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a:A) => (b:B) => f(a, b)
}

object Foober {

  def uncurry1[A, B, C](f: A => B => C): (A, B) => C = (a:A, b:B) => f(a)(b)

  def wacko[Z, B, C, Y](f: Z => B => C => Y, bc: B => C): Z => B => Y =
    (z: Z) => (b: B) => f(z)(b)(bc(b))



}
