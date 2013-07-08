import org.scalatest._
import List._

class Ch3ExercisesTest extends FunSpec with ShouldMatchers {
  describe("a tail function for Lists") {
    tail(List(1, 2, 3, 4)) should equal(List(2, 3, 4))
  }

  describe("a drop function that removes n-items from the beginning of a List") {
    drop(2, List(1, 2, 3, 4)) should equal(List(3, 4))
  }
}

