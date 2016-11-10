/**
  * Created by lx on 07/11/2016.
  */
import akka.actor.{ActorRef, Props, ActorSystem, Actor}
import akka.actor.Actor.Receive
import com.typesafe.config.ConfigFactory
;

object Ch1Concurrence extends App{

  //Concurrency
  case class Point(x: Double, y: Double = 0.0)

  abstract class Shape() {
    def draw(f: String => Unit): Unit = f(s"draw: ${this.toString}")
  }

  case class Circle(center: Point, radius: Double) extends Shape

  case class Rectangle(leftTop: Point, h: Double, w: Double) extends Shape

  case class Triangle(p1: Point, p2: Point, p3: Point) extends Shape

  object Messages {
    object Exit
    object Finished

    case class Response(msg:String)
  }

  class ShapeDrawingActor extends Actor {
    import Messages._


    def receive = {
      case s: Shape =>
        s.draw(str => println(s"draw $str"))
        sender ! Response(s" $s drawn")
      case Exit =>
        println("exiting...")
        sender ! Finished
      case unexpected =>
        val response = Response("unkonw")
        println(s"response: $response")
        sender ! response
    }
  }

  class ShapesDrawingDriver(drawerActor: ActorRef) extends Actor {     // 5
    import Messages._

    def receive = {
      case Start =>                                                    // 6
        drawerActor ! Circle(Point(0.0,0.0), 1.0)
        drawerActor ! Rectangle(Point(0.0,0.0), 2, 5)
        drawerActor ! 3.14159
        drawerActor ! Triangle(Point(0.0,0.0), Point(2.0,0.0), Point(1.0,2.0))
        drawerActor ! Exit
      case Finished =>                                                 // 7
        println(s"ShapesDrawingDriver: cleaning up...")
        context.system.shutdown()
      case response: Response =>                                       // 8
        println("ShapesDrawingDriver: Response = " + response)
      case unexpected =>                                               // 9
        println("ShapesDrawingDriver: ERROR: Received an unexpected message = "
          + unexpected)
    }
  }

  private object Start

  override def main(strings:Array[String]): Unit = {
    val  system =  ActorSystem("LXDraw", ConfigFactory.load())
    val drawer = system.actorOf(
      Props(new ShapeDrawingActor), "drawActor")
    val driver = system.actorOf(
      Props(new ShapesDrawingDriver(drawer)), "drawDriver")

    driver ! Start

    val m = 1
  }
}
