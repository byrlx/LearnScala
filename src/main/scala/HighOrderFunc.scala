/**
  * Created by lx on 10/11/2016.
  */

object HighOrderFunc extends App {
  def sum(f: Int => Int, start: Int, end: Int): Int = {
    if (start > end) 0
    else f(start) + sum(f, start + 1, end)
  }

  def id(x: Int) = x

  def square(x: Int) = x * x

  def cube(x: Int) = x * x * x

  println(sum(id, 1, 5))
  println(sum(square, 1, 5))
  println(sum(cube, 1, 5))
  println(sum(x => x + 1, 1, 5))

  //create function
  def sum2(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    }

    sumF
  }

  def sumId = sum2(x => x)

  def sumSquare = sum2(x => x * x)

  def sumCube = sum2(x => x * x * x)

  println("---------------------")
  println(sumId(1, 5))
  println(sumSquare(1, 5))
  println(sumCube(1, 5))

  /**
    * curry theory
    * f(x1)(x2)(x3)..(xn) = {f1(xn); f1}
    * 即 f(x1)..(xn-1) = f1
    * 即 f(x1)..(xn-1) = {f2(xn-1); f2}
    */
  def sum3(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum3(f)(a + 1, b)

  def sumId2 = sum3(x => x)(_, _)

  def sumSquare2 = sum3(x => x * x)(_, _)

  def sumCube2 = sum3(x => x * x * x)(_, _)

  println("---------------------")
  println(sumId2(1, 5))
  println(sumSquare2(1, 5))
  println(sumCube2(1, 5))

  /**
    * generate sum and product
    */

  def mapReduce(f: Int => Int, g: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else g(f(a), mapReduce(f, g, zero)(a + 1, b))

  def sum4(a: Int, b: Int) = mapReduce(Int => Int, (x, y) => x + y, 0)(a, b)

  def product = mapReduce(Int => Int, (x, y) => x * y, 1)(_,_)

  def sumId3 = sum3(x => x)(_,_)

  def sumSquare3 = sum3(x => x * x)(_, _)

  def sumCube3 = sum3(x => x * x * x)(_, _)

  println("---------------------")
  println(sumId3(1, 5))
  println(sumSquare3(1, 5))
  println(sumCube3(1, 5))

}
