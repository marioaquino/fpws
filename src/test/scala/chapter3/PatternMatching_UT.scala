import org.scalatest._
import List._

class PatternMatchingTest extends FunSpec with ShouldMatchers {
  describe("solving a list with pattern matching") {
    val x = List(1,2,3,4,5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }

    x should equal(3)

  }
}

