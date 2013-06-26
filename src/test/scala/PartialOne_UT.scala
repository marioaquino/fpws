import org.scalatest._
import Exercise3._

class PartialOneTest extends FunSpec with ShouldMatchers {
  describe("Using the return value of the partial function") {
    partial1(1, (a:Int, b:String) => {b.substring(0, a)})("Mario") should equal("M")
  }

}
