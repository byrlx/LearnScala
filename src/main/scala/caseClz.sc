object caseClz {
  abstract class Term

  case class Var(name:String) extends Term
  case class Fun(args:String, body:Term) extends Term
  case class App(f:Term, v:Term) extends Term

  Fun("cube", Var("x")).args

  App(Fun("cube", Fun("add", Var("m"))), Var("N"))

  Var("x").toString

  case class Dog(name: String, breed: String)
  val d1 = Dog("Scooby", "Doberman")
  d1.toString

  def sum(a: Int, b: Int, c: Int) = a + b + c
  val sum3 = sum _
  sum(1,2,3)
  sum3(1,2,3)

  def customFilter(f: Int ⇒ Boolean)(xs: List[Int]) = {
    xs filter f
  }
  def onlyEven(x: Int) = x % 2 == 0
  val xs = List(12, 11, 5, 20, 3, 13, 2)
  customFilter(onlyEven)(xs)
}