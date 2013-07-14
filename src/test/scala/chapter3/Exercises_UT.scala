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

  describe("init for a list of a single item") {
    init(List(1)) should equal(Nil)
  }

  describe("a function to count the length of a list using foldRight") {
    lengthOfList(List(1, 2, 3, 4)) should equal(4)
  }

  describe("A tail-recursive foldLeft") {
    foldLeft(List('a','b','c','d'),"")(_ + _) should equal("abcd")

    //it("can reverse a really long string") {
      //val lotsOfChars = util.Random.alphanumeric.take(4000).toArray
      //println("This is a long string:" + new String(lotsOfChars))
      //lazy val barf: String = throw new RuntimeException("I want to see the stack trace")
      //List.foldLeft(List(lotsOfChars:_*),barf)(_+_) should equal(new String(lotsOfChars).reverse)
      //val thrown = evaluating { List.foldLeft(List(lotsOfChars:_*),barf)(_+_) } should produce[RuntimeException]
      //thrown.getStackTrace.length should be < (4000)
    //}

  }
}

