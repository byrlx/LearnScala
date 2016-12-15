package week4

/**
  * Created by lx on 18/11/2016.
  */
object LxVariance extends App {

  class Base {
    override def toString = "this is base"
  }

  class LxSub extends Base {
    override def toString = "this is sub"
  }

  class C[T <: Base]

  class D[-T]

  var base = new Base
  var sub = new LxSub
  var cBase = new C[Base]
  var cSub = new C[LxSub]
  var dBase = new D[Base]
  var dSub = new D[LxSub]

  def f1(x: Base): Unit = {
    println("this is " + x)
  }

  def f2(x: C[Base]) = println("c")

  def f3(x: D[LxSub]) = println("d")

  f1(base)
  f1(sub)

  f2(cBase)
  //  f2(cSub) //error

  f3(dBase)
  f3(dSub)
}
