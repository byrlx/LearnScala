import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

/**
  * Created by lx on 08/11/2016.
  */
object Chp5 extends App {
  //
//  def logTagFor[A <: Singleton](a: A): String = macro ZLogMacros.logTagForSingleton[A]
//
//  private object ZLogMacros {
//    def logTagForSingleton[A <: Singleton](c: Context)(a: c.Expr[A])(implicit tag: c.WeakTypeTag[A]) = logTagFor[A](c)
//
//    def logTagFor[A](c: Context)(implicit tag: c.WeakTypeTag[A]) = {
//      import c.universe._
//      val name = tag.tpe.typeSymbol.fullName.split('.').lastOption.getOrElse("UNKNOWN")
//      q"$name"
//    }
//  }

  override def main(args: Array[String]) = {
    def calcTax(amount: Float)(implicit rate: Float) = rate * amount

    /*simple one
    implicit val rate: Float = 0.05F
    println(s"tax is ${calcTax(1000)}")
    */

    /*implicit funtion*/
    object simple {
      implicit val rate: Float = 0.05F
    }

    case class ComplicatedTax(
                               baseRate: Float,
                               isHoliday: Boolean,
                               storeId: Int)

    object complicate {
      private def extra(id: Int): Float = {
        0.1F
      }

      implicit def rate(implicit cstd: ComplicatedTax): Float = {
        if (cstd.isHoliday) 0F
        else cstd.baseRate + extra(cstd.storeId)
      }
    }

    {
      import simple.rate

      println(s"Tax of simple = ${calcTax(1011)}")
    }

    {
      import complicate.rate
      implicit val myStore = ComplicatedTax(0.12F, false, 200)

      println(s"Tax of complicate = ${calcTax(2222)}")
    }

//    println(logTagFor(Chp5))
  }
}
