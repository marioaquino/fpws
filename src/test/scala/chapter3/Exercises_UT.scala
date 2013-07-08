import org.scalatest._
import List._

class Ch3ExercisesTest extends FunSpec with ShouldMatchers {
  describe("a tail function for Lists") {
    tail(List(1, 2, 3, 4)) should equal(List(2, 3, 4))
  }
}

