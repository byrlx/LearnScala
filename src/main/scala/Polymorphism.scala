/**
  * Created by lx on 13/11/2016.
  */
object Polymorphism extends App {
  var x = List(1, 2)


  var nil = new LxNil
  //  nil.head
  //  nil.tail

  var lxlist = new LxCons(1, new LxCons(2, new LxCons(3, new LxCons(4, new LxNil))))

  println(lxlist.head)
  println(lxlist.tail)
  println(lxlist.isEmpty)
  println(lxlist.nth(2, lxlist))
//  println(lxlist.nth(-1, lxlist))
//  println(lxlist.nth(4, lxlist))
}

abstract class IntList {
  def head: Int

  def tail: IntList

  def isEmpty: Boolean

  def nth(n: Int, list: IntList): Int = {
    if (list.isEmpty) throw new IndexOutOfBoundsException("out of bounds")

    if (n == 0) list.head
    else nth(n - 1, list.tail)
  }
}

class LxNil extends IntList {
  override def isEmpty: Boolean = true

  override def head: Int = throw new Error("LxNil no head")

  override def tail: IntList = throw new Error("LxNil no head")
}

class LxCons(var h: Int, var t: IntList) extends IntList {
  override def isEmpty: Boolean = false

  override def head: Int = h

  override def tail: IntList = t

}
