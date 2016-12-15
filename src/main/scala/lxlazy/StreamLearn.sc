import java.lang.ref.WeakReference

import scala.collection.immutable.Stream.Empty
import scala.reflect.api.Trees.BlockExtractor
import scala.reflect.api.Trees.FunctionExtractor
import scala.reflect.api.Trees.ValDefExtractor
import scala.reflect.macros.blackbox.Context

object StreamLearn {
  val a = 1 to 10 toStream

  def from(x: Int): Stream[Int] = x #:: from(x + 1)

  val nats = from(0)

  def m4s = nats map (_ * 4)

  m4s take 10 toList

  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
  }

  sieve(from(2)) take 10 toList

  var ss = Set.empty[String]
  ss += "a"
  ss += "c"

  def m(x: String): Unit = println(x)

  ss foreach m

  class lxlistener {
    //    def update(this) = println("hi")
  }

  var am = new lxlistener

  //  am.update(am)


  var xxm = Vector(1, 2)

  def lx10(x: Int) = println(x)

  xxm.filter(_ > 1)

  var xxxm = Option.empty[Int]

  xxxm foreach lx10

  private object KestrelMacro {
    def apply[A](c: Context)(init: c.Tree)(effects: c.Tree) = {
      import c.universe._
      c.untypecheck(effects) match {
        case Function(List(ValDef(_, t: TermName, _, EmptyTree)), b) => q"val $t = $init; $b; $t"
        //相当于,
        case Block(p, Function(List(ValDef(_, t: TermName, _, EmptyTree)), b)) => q"val $t = $init; $p; $b; $t"
        //相当于, 定义 x, 函数处理 x, 返回 x
        case _ /*  no inlining possible or necessary */ => q"val x = $init; $effects(x); x"
      }
    }
  }

  object returning {
    def apply[A](init: A)(effects: A => Unit): A = macro KestrelMacro.apply[A]
  }

  returning('A')
}