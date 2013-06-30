import org.scalatest._

class Fib_UT extends FunSpec with ShouldMatchers {
  import Mathy._

  describe("fib") {
    it("returns 0 for 0") {
      fib(0) should equal (0)
    }

    it("returns 1 for the first one") {
      fib(1) should equal (1)
    }

    it("returns 1 for the second one") {
      fib(2) should equal (1)
    }

    it("returns 2 for the next one") {
      fib(3) should equal (2)
    }

    it("returns 3 for the next one") {
      fib(4) should equal (3)
    }

    it("returns 5 for the next one") {
      fib(5) should equal (5)
    }
  }
}
