sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](ls: List[A]): List[A] = ls match {
    case Cons(x, xs) => xs
  }

  def drop[A](l: List[A], num:Int): List[A] = {
    if (num <= 0) l
    else drop(tail(l), num - 1)
  }

  def dropWhile[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Cons(x, xs) => if (f(x)) dropWhile(xs)(f) else l
  }

  def setHead[A](l: List[A], newHead: A): List[A] = l match {
    case Nil => List(newHead)
    case Cons(head, tail) => Cons(newHead, tail)
  }

  def init[A](l : List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(head, Cons(_, Nil)) => Cons(head, Nil)
    case Cons(head, tail) => Cons(head, init(tail))
  }
}


