import java.io.File

/**
  * 这一文件主要阐述 scala 的控制结构
  */
object StructureLearn extends App {

  /**
    * if 是可以返回值的
    */
  val s = "helo wold"
  println(if (s.length > 0) s else 0)
  val result = if (s.length > 0) s else 0
  println(result)
  //same as above

  /**
    * while 的返回值是空函数
    */
  var i = 0
  println(while (i < 1) {
    i += 1
  })

  /**
    * for 使用 <-
    */
  val files = (new File("src/main/scala")).listFiles()
  for (f <- files)
    println(f)

  /**
    * 为 for 添加过滤器
    */
  for (i <- 0 until s.length if i % 2 == 0)
    print(s.charAt(i))
  println()

  /**
    * 嵌套循环
    */
  val v = for {
    i <- 0 to 9
    j <- 11 until 15
  } yield i * j

//  println(v.mkString("\n"))
}
