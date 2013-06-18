object Mathy {
  def fib(n: Int): Int = {
    predictBasedOnPrevious2(0, 1, _ + _).take(n + 1).max
  }

  // a way to map over a stream that gets the previous two elements
  def predictBasedOnPrevious2( firstSeed: Int, secondSeed: Int, f: (Int, Int) => Int): Iterator[Int] = {
     Seq(firstSeed).iterator ++ predictBasedOnPrevious2(secondSeed, f(firstSeed, secondSeed), f)
  }
}
