package week4

/**
  * Created by lx on 18/11/2016.
  */
abstract class LxIntSet {
  def isEmpty: LxBoolean
}

object LxEmpty extends LxIntSet {
  override def isEmpty: LxBoolean = LxTrue
}

class LxNoEmpty extends LxIntSet {
  override def isEmpty: LxBoolean = LxFalse
}

abstract class LxTest3 {
  def assertAllPos[S <: LxIntSet](x: S): S
}
