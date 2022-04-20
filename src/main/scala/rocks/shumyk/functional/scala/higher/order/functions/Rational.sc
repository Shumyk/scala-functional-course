import scala.annotation.tailrec

class Rational(x: Int, y: Int):
  require(y > 0, s"denominator must be positive, was $x/$y")

  def this(x: Int) = this(x, 1)

  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

  val numer = x // gcd(x.abs, y)
  val denom = y // gcd(x.abs, y)

  def add(r: Rational): Rational =
    Rational(numer * r.denom + r.numer * denom,
      denom * r.denom)

  def sub(r: Rational): Rational = add(neg(r))

  def mul(r: Rational): Rational = Rational(numer * r.numer, denom * r.denom)

  def neg(r: Rational): Rational = Rational(-r.numer, r.denom)

  def less(that: Rational): Boolean =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational): Rational =
    if this.less(that) then that else this

  override def toString = s"${numer / gcd(x.abs, y)}/${denom / gcd(x.abs, y)}"
end Rational

val x = Rational(1, 3)
val y = Rational(5, 7)
val z = Rational(3, 2)
val zz = Rational(3, 6)
x.add(y).mul(z)
x.sub(y).sub(z)