import java.io.File

import scala.io.Source

/**
  * 函数!!! 函数!!! 函数!!!
  */
object Fun extends App {
  /**
    * 函数中定义函数
    */
  def processFile(name: String, width: Int) = {
    def processLine(line: String) = {
      /**
        * 可以直接使用外部函数的参数
        */
      if (line.length > width) println(line)
    }

    val source = Source.fromFile(name)

    /**
      * 下面两种方式都可以
      */
    //    for (line <- source.getLines()) processLine(line)
    source.getLines foreach processLine
  }

  /*
  for (file <- (new File("src/main/scala")).listFiles())
    processFile(file.getAbsolutePath, 20)
  */

  /**
    * 函数可以定义到变量中
    */
  var fvar = (x: Int) => x + 1
  println(fvar(10))

  /**
    * 使用下划线做占位符
    */
  var l = List(1, 3, 4, 5, -19, -2)
  println(l.filter(_ > 0))

  /**
    * 偏函数, 使用偏函数可以将函数可以创建新的函数类
    */
  def sum(a: Int, b: Int, c: Int) = a + b + c

  //sum1不是新类, 而只是 sum 的一个实例
  var sum1 = sum _
  //sum2是编译器创建的一个新类
  var sum2 = sum(1, _: Int, 3)
  // sum3是一个无参函数, 函数的返回值是另外一个函数, 即sum2类型的函数,接受一个 int 作为参数并
  var sum3 = sum2 _

  println(sum(1, 2, 5) + "," + sum1(1, 2, 5) + "," + sum2(5) + "," + sum3())

  /**
    * 闭包
    */
  def addMore(more: Int) = (x: Int) => x + more

  val add1 = addMore(1)
  val add99 = addMore(99)
  println(add1(10) + "/" + add99(10))

  /**
    * 重复参数
    */
  def moreStr(s: String*) = {
    s foreach print;
    println
  }

  moreStr("a", "hel", "w")

  /**
    * 尾递归, 如果一个函数的最后一行代码是调用函数本身, 那么 scala 编译器
    * 可以将其优化为尾递归, 具体实现是:
    * 1. 更新函数参数.
    * 2. 将指令跳转到当前栈帧开始的地方,而不是创建新的栈帧(大部分语言递归函数都是创建新栈帧)
    *
    * 所以 crash 的时候堆栈信息会比较诡异
    */
  def sumN(n: Int): Int = {
    val result = 0

    def doSum(initValue: Int, n: Int): Int = {
      if (n == 0) initValue
      else doSum(initValue + n, n - 1)
    }

    doSum(result, n)
  }

  println(sumN(10))
}
