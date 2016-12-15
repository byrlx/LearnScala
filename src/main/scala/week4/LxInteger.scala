package week4

/**
  * 如果表示一个整数
  * Created by lx on 18/11/2016.
  */
//not negative integer
abstract class LxNat {
  var value: Int

  //这个整数是否为0
  def isZero: LxBoolean

  //这个整数的前一个整数
  def predecessor: LxNat

  //这个整数的后一个整数
  def successor: LxNat = new LxSuccessor(this)

  //两数相加
  def +(x: LxNat): LxNat

  //两数相减
  def -(x: LxNat): LxNat

  override def toString = value.toString
}

//代表整数零
object LxZero extends LxNat {
  var value = 0

  override def isZero: LxBoolean = LxTrue

  //两数相加
  override def +(x: LxNat): LxNat = x

  //两数相减
  override def -(x: LxNat): LxNat = if (x.isZero.isTrue) this else throw new IllegalArgumentException

  //这个整数的前一个整数
  override def predecessor: LxNat = throw new IllegalArgumentException
}

class LxSuccessor(n: LxNat) extends LxNat {
  var value = n.value + 1

  //这个整数是否为0
  override def isZero: LxBoolean = LxFalse

  //两数相加
  override def +(x: LxNat): LxNat = new LxSuccessor(n + x)

  //两数相减
  override def -(x: LxNat): LxNat = n - x.predecessor

  //这个整数的前一个整数
  override def predecessor: LxNat = n
}

object LxTest extends App {
  var i10 = new LxSuccessor(LxZero)
  for (x <- 1 to 9) {
    i10 = new LxSuccessor(i10)
  }

  println(i10)
  println(i10 - i10)
}