import collection.immutable.Stack
import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class StackSpec extends FlatSpec with ShouldMatchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    val stackOf2 = stack.push(1).push(2)
    val (first, stackOf1) = stackOf2.pop2
    first should equal (2)
    stackOf1.pop2._1 should equal (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    evaluating { emptyStack.pop } should produce [NoSuchElementException]
  }
}

