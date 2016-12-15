package week4

import java.lang.ref.WeakReference

/**
  * Created by lx on 18/11/2016.
  */
object ListsLearn extends App {
  var num = List(1, 2, 3, 4)
  while (num != Nil) {
    println(num.head)
    num = num.tail
  }

  println(1 :: (2 :: Nil))

  //  Nil.head

  List() == Nil

  var num2 = 22 :: 19 :: 9 :: 8 :: Nil

  println(List(5, num2).length)

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => {
      if (x < y) x :: xs
      else y :: insert(x, ys)
    }
  }

  def lxsort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, lxsort(ys))
  }

  println(insert(0, num2))
  println(insert(5, num2))
  println(lxsort(num2))

  //from wire
  class ListenerList[A <: AnyRef] {
    private var listeners = Vector.empty[WeakReference[A]]

    def add(listener: A): Unit = listeners = nonEmptyListeners :+ new WeakReference(listener)

    def remove(listener: A): Unit = listeners = nonEmptyListeners.filter(_.get ne listener)

    //对每一个 listener 执行通知函数
    def notify(f: A => Unit): Unit = {
      listeners = nonEmptyListeners
      listeners.foreach(_.get match {
        case null =>
        case l => {
          println("gotcha")
          f(l)
        }
      })
    }

    def size = listeners.size

    //返回 listener 列表里的所有非null
    private def nonEmptyListeners = if (listeners.exists(_.get eq null)) listeners.filter(_.get ne null) else listeners
  }

  trait UpdateListener {
    def updated()
  }

  private val updateListeners = new ListenerList[UpdateListener]
  updateListeners.add(new UpdateListener {
    override def updated(): Unit = {
      println("Hi")
    }
  })
  updateListeners.notify(_.updated())
}

