object ListFuns {
  def flatten(xs: List[Any]): Unit = xs match {
    case List() => println(xs)
    case List(x) => {
      println("last:" + xs)
    }
    case y :: ys => {
      if (y.isInstanceOf[List[Any]])
        flatten(y.asInstanceOf[List[Any]])
      println("yy:" + y)
      //      flatten(y)
      flatten(ys)
    }
  }


  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  //  flatten(List(List(List(List(1,1)))))
  /*
  var x = 1 :: 5 :: 33 :: 22 :: 4343 :: 12 :: Nil

  x.head
  x.tail
  x.init
  x apply 3
  x apply 0
  //  x apply 10

  x take 2
  x drop 4
  x.reverse
  x ++ (1 :: 5 :: Nil)
  x
  x.updated(3, 19)
  x indexOf 3
  x contains 5
  x ::: (1 :: Nil)

  def removeAt[T](n: Int, xs: List[T]): List[T] = {
    if (n == 0) xs.tail
    else xs.head :: removeAt(n - 1, xs.tail)
  }

  removeAt[Int](0, x)
  removeAt[Int](3, x)
  */

  var inc = 1

  def clousure(x: Int) = {
    x + inc
  }

  clousure(3)

  def clo2 = {
    x: Int => x + inc
  }

  def clo3(x: Int) = {
    y: Int => x + y
  }

  val n1 = clo3(inc)
  n1(4)

//  val mx = clo2
//  mx(3)

  inc = 2

  val n2 = clo3(inc)
  n1(4)
  n2(4)

//  val a = List(1, 3, 5, 7)
//  a.reduce(_ + _)

  val d = Nil
  val c = 3 :: d
  val b = 2 :: c
  val a = 1 :: b

//  val m2 = clo2
//  mx(3)
//  m2(5)
val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")

  val mapValues = myMap.values
  mapValues.head

  val newmap = myMap - "MI"
  myMap
}