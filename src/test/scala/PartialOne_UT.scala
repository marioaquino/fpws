import org.scalatest._
import Exercise3._

class PartialOneTestO extends FunSpec with ShouldMatchers {
  describe("Using the return value of the partial function") {
    partial1(1, (a:Int, b:String) => {b.substring(a)})("Mario") should equal("M")
  }

}
