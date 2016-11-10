/**
  * Created by lx on 07/11/2016.
  */
object Ch4PatternM extends App {
  override def main(args: Array[String]) = {

    /*simple
    var bools = Seq(true, false)

    for(bool <- bools) {
      bool match {
        case true => println("true")
//        case false => println("false")
        case unexpected => println("error")
      }
    }
    */

    for {
      x <- Seq(1, 2, "a", "f", 'four, 2.5)
    } {
      val str = x match {
        case 1 => "int 1"
        case i: Int => "int 2"
        case "a" => "str a"
        case s: String => "string f"
        case d: Double => "double 2.5"
        case unexpected => "unexpected " + unexpected
      }

      println(str)
    }
  }
}
