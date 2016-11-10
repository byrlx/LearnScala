/**
  * Chapter1: Zero to Sixty
  *
  * Created by lx on 11/6/16.
  */

import akka.actor.Actor
// SIMPLE
class Upper {
  def upper(strings: String*): Seq[String] = {
    strings.map((s: String) => s.toUpperCase())
  }
}

object Sig {
  def lower(strings: String*) = strings.map(_.toLowerCase())
}



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
