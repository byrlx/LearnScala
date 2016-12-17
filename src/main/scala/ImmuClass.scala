/**
  * 这个个例子主要用来阐述不可变对象. 不可变对象的状态永远无法改变
  *
  * 通过有理数的实现作为例子
  */
object ImmuClass extends App {

  class Rational(n: Int, d: Int) {
    /**
      * 通过 require 来做断言, 放置分母为 0 的情况.
      */
    require(d != 0)

    private val g = gcd(n, d)
    /**
      * 将变量定义为 val 类型, 可以保证其不被改变
      *
      * 通过添加变量 g 来简化有理数
      */
    val number = n / g
    val denom = d / g

    override def toString = s"$number/$denom"

    println(toString)
    /**
      * 每次相加并没有改变加数和被加数状态, 而是返回一个新的有理数
      *
      * @param that
      * @return
      */
    def add(that: Rational): Rational = {
      new Rational(this.number * that.denom + this.denom * that.number, this.denom * that.denom)
    }


    /**
      * 定义数学操作符
      */
    def +(that: Rational): Rational = {
      new Rational(this.number * that.denom + this.denom * that.number, this.denom * that.denom)
    }

    def -(that: Rational): Rational = {
      new Rational(this.number * that.denom - this.denom * that.number, this.denom * that.denom)
    }

    def *(that: Rational): Rational = {
      new Rational(this.number * that.number, this.denom * that.denom)
    }

    def /(that: Rational): Rational = {
      new Rational(this.number * that.denom, this.denom * that.number)
    }

    /**
      * 最大公约数
      */
    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a.abs else gcd(b, a % b)
    }
  }

  val r1 = new Rational(3, 1)
  val r2 = new Rational(9, 1)
  r1 + r2
  r1 - r2
  r1 * r2
  r1 / r2
}
