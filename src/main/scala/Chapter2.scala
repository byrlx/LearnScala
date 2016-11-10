import scala.concurrent.Future

/**
  * Created by lx on 07/11/2016.
  */
object Chapter2 extends App {
  override def main(args: Array[String]) {
    /* case
    val pf1: PartialFunction[Any, String] = {
      case s: String => "YES"
    }
    val pf2: PartialFunction[Any, String] = {
      case d: Double => "YES"
    }

    val pf = pf1 orElse pf2

    def tryPF(x: Any, f: PartialFunction[Any, String]): String = // 4
      try {
        f(x).toString
      } catch {
        case _: MatchError => "ERROR!"
      }

    def d(x: Any, f: PartialFunction[Any, String]) = f.isDefinedAt(x).toString // 5
    println("      |   pf1 - String  |   pf2 - Double  |    pf - All") // 6
    println("x     | def?  |  pf1(x) | def?  |  pf2(x) | def?  |  pf(x)")
    println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    List("str", 3.14, 10) foreach { x =>
      printf("%-5s | %-5s | %-6s  | %-5s | %-6s  | %-5s | %-6s\n", x.toString,
        d(x, pf1), tryPF(x, pf1), d(x, pf2), tryPF(x, pf2), d(x, pf), tryPF(x, pf))
    }
    */

    import scala.concurrent.Future
    import scala.concurrent.ExecutionContext.Implicits.global
    def sleep(millis: Long) = {
      Thread.sleep(millis)
    }

    // Busy work ;)
    def doWork(index: Int) = {
      sleep((math.random * 1000).toLong)
      println("thread of " + index + " " + Thread.currentThread())
      index  //返回值
    }

    (1 to 5) foreach { index =>
      val future = Future {
        doWork(index)
      }
      future onSuccess {
        case answer: Int => {
          val id = Thread.currentThread()
          println (s"Success! returned: $answer $id")
        }
      }
      future onFailure {
        case th: Throwable => {
          val id = Thread.currentThread()
          println(s"FAILURE! returned: $th $id")
        }
      }
    }

    sleep(1000)  // Wait long enough for the "work" to finish.
    println("Finito! " + Thread.currentThread())
  }
}
