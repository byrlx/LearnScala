package week4

/**
  * Created by lx on 18/11/2016.
  */
trait LxList[T] {
  def isEmpty: LxBoolean

  def tail: LxList[T]

  def head: T
}

class LxNil[T] extends LxList[T] {
  override def isEmpty: LxBoolean = LxTrue

  override def tail: Nothing = throw new NoSuchElementException("Nil has no tail")

  override def head: Nothing = throw new NoSuchElementException("Nil has no head")

  override def toString = "{}"
}

class LxCons[T](val head: T, val tail: LxList[T]) extends LxList[T] {
  override def isEmpty: LxBoolean = LxFalse

  override def toString = "{" + head.toString + "  " + tail.toString + "}"
}

object LxList {
  def apply[T](x1: T, x2: T): LxList[T] = new LxCons[T](x1, new LxCons[T](x2, new LxNil[T]))
  def apply[T]() = new LxNil[T]
}

object LxxTest extends App {
  println(LxList(1, 2))
  println(LxList("a", "b"))
}
