case class Foo(bar: Int, baz: String)

class Carrot(val ho: String)
object Carrot {
   def unapply(c: Carrot) : Option[String] = {
     if (c.ho.isEmpty) None else
     Some(c.ho)
   }
}

