
object Sorter {
  def isSorted[A](arr: Array[A], lte: (A,A) => Boolean): Boolean = {
    val g:Array[A] => Boolean = { case Array(one, two) => lte(one, two) }

    arr match {
      case Array() => true
      case Array(_) => true
      case arrayOfMoreThanOne => arrayOfMoreThanOne.sliding(2, 1).forall(g)
    }
  }
}
