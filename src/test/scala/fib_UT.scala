import org.scalatest._

class Fib_UT extends FunSpec with ShouldMatchers {
  import Mathy._

  describe("fib") {
    it("returns 0 for 0") {
      fib(0) should equal (0)
    }

    it("returns 1 for 1") {
      fib(1) should equal (1)
    }
  }
}
