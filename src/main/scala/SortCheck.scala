
object Sorter {
  def isSorted[A](arr: Array[A], lte: (A,A) => Boolean): Boolean = {
    if (arr.length == 0) { true }
    else if (arr.length == 1) { true }
    else { lte(arr(0), arr(1)) }
  }
}
