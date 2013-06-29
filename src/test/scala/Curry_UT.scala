import org.scalatest._
import Exercise4._
import Exercise3._
import Foober._

class CurryTest extends FunSpec with ShouldMatchers {
  describe("Using the return value of a curried function") {
    curry((a:Int, b:Int) => a * b)(2)(2) should equal(4)
  }

  describe("currying plus one application is the same as partial application") {
    val f = (a: Int, you: String) => you.substring(0, a)
    val curriedAndThenPartiallyApplied = curry(f)(1)
    val partiallyApplied = partial1(1, f)
    curriedAndThenPartiallyApplied("Mario") should equal(partiallyApplied("Mario"))

  }

  describe("sometimes I use a curried style") {
    def formatLine(prefix: String)(message: String) = prefix + ": " + message

    val formatter: String => String = formatLine("Simon says")

    println(formatter("Jump your toes"))
  }

  describe("or we can partially apply ourselves") {
    def formatLine(prefix: String, message: String) = prefix + ": " + message

    val formatter: String => String = formatLine("Simon says", _)

    println(formatter("Jump your toes"))
  }

  describe(".. which is syntax sugar for") {
    def formatLine(prefix: String, message: String) = prefix + ": " + message

    val formatter: String => String = (msg) => formatLine("Simon says", msg)

    println(formatter("Jump your toes"))
  }

  describe("wacko") {
    val f: Int => String => Double => Array[String] = (a) => (b) => (c) => Array(a.toString, b, c.toString)
    val bc: String => Double = (s) => s.length

    val w = wacko(f, bc)

    w(1)("Mario") should equal (Array("1", "Mario", "5.0"))

  }

  describe("uncurrying...") {
    val curried = (a:Int) => (b:Int) => { a + b }
    uncurry1(curried)(1, 2) should equal(curried(1)(2))
  }

}

