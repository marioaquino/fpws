object Mathy {
  def fib(n: Int): Int = {
    predictBasedOnPrevious2(0, 1, _ + _).take(n + 1).last
  }

  // a way to map over a stream that gets the previous two elements
  def predictBasedOnPrevious2( firstSeed: Int, secondSeed: Int, f: (Int, Int) => Int): Iterable[Int] = {
    new Iterable[Int] {
      def iterator: Iterator[Int] = new Iterator[Int] {
        var nextResult = firstSeed
        var nextNextResult = secondSeed

        def hasNext = true
        def next():Int = {
          val tempResult = nextResult
          nextResult = nextNextResult
          nextNextResult = f(tempResult, nextResult)
          tempResult
        }
      }
    }
  }
}
