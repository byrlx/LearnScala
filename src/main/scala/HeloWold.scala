/**
  * Created by lx on 10/20/16.
  */

case class Provider[T](fn: () => T) extends (() => T) {
  def apply() = fn()
}

/**
  * Singleton 是这样一个类, 他接受一个函数, 函数返回一个 T,
  * 调用 singleton 默认会 执行函数得到一个 T.
  */
case class Singleton[T](fn: () => T) extends (() => T) {
  lazy val value = fn()

  def apply() = value
}

object HeloWold extends App {
  override def main(args: Array[String]): Unit = {
    //    println(Singleton(()=>"helo").value)
    val f1 = Provider(() => "helo")
    val f2 = Singleton(() => "wold")

    println(f1())
    println(f2())
  }
}
