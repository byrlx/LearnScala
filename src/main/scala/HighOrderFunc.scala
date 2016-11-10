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
}
