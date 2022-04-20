class Rational(x: Int, y: Int):
  def numer = x
  def denom = y

  def add(r: Rational): Rational =
    Rational(numer * r.denom + r.numer * denom,
      denom * r.denom)

  def sub(r: Rational): Rational = add(neg(r))

  def mul(r: Rational): Rational = Rational(numer * r.numer, denom * r.denom)

  def neg(r: Rational): Rational = Rational(-r.numer, r.denom)

  override def toString = s"$numer/$denom"
end Rational

val x = Rational(1, 3)
val y = Rational(5, 7)
val z = Rational(3, 2)
x.add(y).mul(z)
x.sub(y).sub(z)