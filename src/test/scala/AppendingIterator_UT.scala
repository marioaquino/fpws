import org.scalatest._

class AppendingIterator_UT extends FunSpec {
  describe("constructed with one item") {
    val item = "I'm first"
    def subject = AppendingIterator.of(item) 
    it("returns that one item from next") { 
       subject.next() should equal (item)
    }
    it("has no more after the first item") {
      val iterator = subject
      iterator.next()
      iterator.hasNext should equal (false)
    }
  }

  describe("appending an iterator") {
     val firstItem = "I'm first"
     val secondItem = "I'm second"
     val secondIterator = Seq(secondItem).iterator
     def subject = AppendingIterator.of(firstItem) andThen secondIterator

     it("Returns the first item first") {
        subject.next() should equal (firstItem)
     }

     it("Returns the second item second") {
        val iterator = subject
	iterator.next()
	iterator.next() should equal (secondItem)
     }

     it("is done after the second iterator is empty") {
        val iterator = subject
	iterator.next()
	iterator.next() 
        iterator.hasNext() should equal (false)
     }
  }

}