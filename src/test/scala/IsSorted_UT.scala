import org.scalatest._
import Sorter._

class IsSortedUT extends FunSpec with ShouldMatchers {
  describe("sorting Arrays"){
    def alwaysReturnTrue[A] = (a:A, b:A) => { true }
    it("returns true for an empty Array") {
      val arr = Array()
      isSorted(arr, alwaysReturnTrue) should equal(true)
    }

    it("returns true for a list of one element") {
      val arr = Array(4)
      isSorted(arr, alwaysReturnTrue) should equal(true)
    }

    it("returns false for a 2-elem array when lte returns false") {
      val arr = Array(3,3)
      isSorted[Int](arr, (_,_) => false) should equal(false)
    }
  }
}
