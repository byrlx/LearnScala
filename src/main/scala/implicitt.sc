import java.math.BigInteger

object implicitt {

  1 + 1

  class KoanIntWrapper(val original: Int) {
    println(original)

    def isOdd = original % 2 != 0
  }

  implicit def thisMethodNameIsIrrelevant(value: String) = new KoanIntWrapper(1)

  "2".isOdd
  "a".isOdd

  implicit def bigIntAdd(x: Int): BigInteger = new BigInteger(x.toString)

  def add(a: BigInteger, b: BigInteger) = a.add(b)

  add(bigIntAdd(1), bigIntAdd(2))
  add(1, 2).intValue() == 3

  def howMuchCanIMake_?(hours: Int)(implicit amount: BigDecimal, currencyName: String) =
    (amount * hours).toString() + " " + currencyName

  implicit val hourlyRate = BigDecimal(34.00)
  implicit val currencyName = "Dollars"

  howMuchCanIMake_?(30)

  def howMuchCanIMake(hours: Int, amount: BigDecimal = 34, currencyName: String = "Dollars") =
    (amount * hours).toString() + " " + currencyName

  howMuchCanIMake(30)

  1 to 3
  1 until 3

  val r1 = 1 to 4
  val r2 = 1 to 2

  val m = for {
    a <- r1
    b <- r2

    if a % 2 == 0
  } yield a

  val nList = List(List(1), List(2), List(3), List(4))
  val nList2 = List(1, 2, 3, 4)

  nList.flatten.map(a => a * 10)

  val g: Int = 31
  g toHexString

  val list = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
  val it = list sliding 3
  it.next()
  it.next()
  it.next()

  list takeRight(3)

  val xt1 = Set(1, 2, 3)
  val yt1 = Set(3, 2, 1)
  xt1 sameElements(yt1)

  val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
  val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
  xs1 sameElements ys1

  val set = Set(1, 9, 10, 22)
  val listm = List(3, 4, 5, 10)
  val result2 = listm ++ set
  val result = set ++ listm
}