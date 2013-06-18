object AppendingIterator {
  def of[T](item:T):AppendingIterator[T] = {
    new AppendingIterator(Seq(item).iterator)
  }
}

class AppendingIterator[T](wrapped:Iterator[T]) extends Iterator[T] {
  def next():T = wrapped.next()
  def hasNext = wrapped.hasNext

  def andThen(moreStuff: => Iterator[T]): AppendingIterator[T] = {
    new AppendingIterator(this ++ moreStuff)
  }

}

