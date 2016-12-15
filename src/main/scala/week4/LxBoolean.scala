package week4

/**
  * 模拟 boolean 的实现
  * 该类代表 boolean 类型(即 true 或 false)
  * Created by lx on 18/11/2016.
  */
abstract class LxBoolean {
  def isTrue:Boolean
  //这个函数的意思是, 如果当前对象本身是TRUE, 怎执行 t, 否执行 e
  def ifThenElse[T](t: => T, e: => T): T

  //如果当前是 true, 那么结果取决于 x 的值,
  //如果当前是 false, 那么结果是 false
  def &&(x: => Boolean): Boolean = ifThenElse(x, false)

  //如果当前是 true, 那么结果是 false
  //如果当前是 false, 那么结果取决于 x 的值,
  def ||(x: => Boolean): Boolean = ifThenElse(true, x)

  //boolean 取非
  def unary_!(): Boolean = ifThenElse(false, true)

  //判断两个值是否相等
  def ==(x: => Boolean): Boolean = ifThenElse(x, x.unary_!)

  //判断两个值是否不相等
  def !=(x: => Boolean): Boolean = ifThenElse(x.unary_!, !x)
}

object LxTrue extends LxBoolean {
  //这个函数的意思是, 如果当前对象本身是TRUE, 怎执行 t, 否执行 e
  override def ifThenElse[T](t: => T, e: => T): T = t

  override def isTrue: Boolean = true
}

object LxFalse extends LxBoolean {
  //这个函数的意思是, 如果当前对象本身是TRUE, 怎执行 t, 否执行 e
  override def ifThenElse[T](t: => T, e: => T): T = e

  override def isTrue: Boolean = false
}

object Test extends App {
  println(LxTrue && true)
  println(LxFalse || true)
}
