import org.scalatest._
import Exercise6._

class CompositionTest extends FunSpec with ShouldMatchers {

  describe("function composition") {
    def intToDouble = (a:Int) => a.toDouble
    def doubleToString = (b:Double) => b.toString
    compose(doubleToString, intToDouble)(1) should equal("1.0")
  }
}

