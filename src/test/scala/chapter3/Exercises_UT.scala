import org.scalatest._
import List._

class Ch3ExercisesTest extends FunSpec with ShouldMatchers {
  describe("a tail function for Lists") {
    tail(List(1, 2, 3, 4)) should equal(List(2, 3, 4))
  }

  describe("a drop function that removes n-items from the beginning of a List") {
    drop(List(1, 2, 3, 4), 2) should equal(List(3, 4))
  }

  describe("a dropWhile function that removes elements as long as the function parameter is true") {
    dropWhile(List(1, 2, 3, 4))(a => a < 3) should equal(List(3, 4))
  }

  describe("set head for replacing the first value in a list") {
    setHead(List(1, 2, 3), 2) should equal(List(2, 2, 3))
  }

  describe ("setHead on an empty list returns a list with that element") {
    setHead(List(), 4) should equal (List(4))
  }

  describe("a function that returns all but the last element of a List") {
    init(List(1, 2, 3, 4)) should equal(List(1, 2, 3))
  }

  describe("what is the init of an empty list?") {
     init(Nil) should equal(Nil)
  }

}

