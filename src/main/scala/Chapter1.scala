/**
  * Chapter1: Zero to Sixty
  *
  * Created by lx on 11/6/16.
  */

// SIMPLE
class Upper {
  def upper(strings: String*): Seq[String] = {
    strings.map((s: String) => s.toUpperCase())
  }
}

object Sig {
  def lower(strings: String*) = strings.map(_.toLowerCase())
}


//Concurrency
case class Point(x: Double, y: Double = 0.0)

abstract class Shape() {
  def draw(f: String => Unit): Unit = f(s"draw: ${this.toString}")
}

case class Circle(center: Point, radius: Double) extends Shape

case class Rectangle(leftTop: Point, h: Double, w: Double) extends Shape

case class Triangle(p1: Point, p2: Point, p3: Point) extends Shape

object Chapter1 extends App {
  override def main(args: Array[String]) {
    val book = "Programming Scala"
    println("This is chapter 1");

    val up = new Upper
    println(up.upper("helo", "wold", "ni").toString());
    Sig.lower("HeLo", "wOlD", "ni").foreach(printf("%s ", _));
    val result = Sig.lower("HeLo", "wOlD", "ni").mkString("~");
    println(result)
  }
}
