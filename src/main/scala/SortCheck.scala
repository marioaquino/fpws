
object Sorter {
  def isSorted[A](arr: Array[A], lte: (A,A) => Boolean): Boolean = {
    arr match {
      case Array() => true
      case Array(_) => true
      case Array(one, two) => lte(one, two)
    }
  }
}
