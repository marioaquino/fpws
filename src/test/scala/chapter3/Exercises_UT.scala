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
    it ( "can concatenate a few chars") {
      foldLeft(List('a','b','c','d'),"")(_ + _) should equal("abcd")
    }

    it("cannot concatenate a really long string if not tail recursive") {
      val lotsOfChars = util.Random.alphanumeric.take(8000).toArray
      println("This is a long string:" + new String(lotsOfChars))

      //lazy val barf: String = throw new RuntimeException("I want to see the stack trace")
      //List.foldLeft(List(lotsOfChars:_*),barf)(_+_) should equal(new String(lotsOfChars).reverse)

      val thrown = evaluating { List.foldLeftNonTailRecursive(List(lotsOfChars:_*),"")(_+_) } should produce[StackOverflowError]

      println("I got a SOE all right. stack length = " + thrown.getStackTrace.length)
    }

    it("can concatenate a really long string using tail recursion") {
      val lotsOfChars = util.Random.alphanumeric.take(8000).toArray
      val expectedString = new String(lotsOfChars)

      val output = List.foldLeft(List(lotsOfChars:_*),"")(_+_)

      output should equal(expectedString)
    }

  }

  describe("Exercise 11") {
    import ListUsingFoldleft._
    it("can take a sum using foldleft") {
       sum(List(1,2,3,4)) should equal(10)
    }
    it("can take a sum using foldleft, trivial case") {
      sum(List()) should equal(0)
    }
    it("can take a sum using foldleft, trivial case 2") {
      sum(List(0)) should equal(0)
    }
  }

  describe("Exercise 12") {
    import ListUsingAnyFold._
    it("reverses a list with stuff inside") {
      reverse(List(1,2,3,4)) should equal(List(4,3,2,1))
    }
    it("doesnt bork when you give it an empty list") {
      reverse(List()) should equal(List())
    }
    it("does just fine with a one item list") {
      reverse(List(0)) should equal(List(0))
    }
  }
}
