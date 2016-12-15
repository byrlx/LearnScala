/**
  * Created by lx on 14/11/2016.
  */
object Generalize extends App{

  var lxlistTest = new LxCons[String]("a", new LxCons[String]("b",
    new LxCons[String]("c", new LxCons[String]("d", new LxNil[String]))))

  println(nth(0,lxlistTest))
  println(nth(1,lxlistTest))
  println(nth(-1,lxlistTest))

  def nth[T](n: Int, list: LxList[T]): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException("out of bounds")

    if (n == 0) list.head
    else nth(n - 1, list.tail)
  }

  trait LxList[T] {
    def isEmpty: Boolean

    def head: T

    def tail: LxList[T]
  }

  class LxNil[T] extends LxList[T] {
    override def isEmpty: Boolean = true

    override def tail: Nothing = throw new IllegalArgumentException("shouldn't call tail")

    override def head: Nothing = throw new IllegalArgumentException("should not call head")
  }

  class LxCons[T](val head: T, val tail: LxList[T]) extends LxList[T] {
    override def isEmpty: Boolean = false
  }

}
