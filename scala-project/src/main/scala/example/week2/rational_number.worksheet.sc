class Rational(x: Int, y: Int):
    require(y > 0, "denominator must be positive")
    private def gcd(a: Int, b: Int): Int =
        if b == 0 then a else gcd(b, a % b)
    val numer = x / gcd(x.abs, y)
    val denom = y / gcd(x.abs, y)

    def this(x: Int) = this(x, 1)

    def add(r: Rational) = 
        Rational(numer * r.denom + r.numer * denom, denom * r.denom)

    def mul(r: Rational) =
        Rational(numer * r.numer, denom * r.denom)

    def neg() = Rational(-numer, denom)

    def sub(r: Rational) = add(r.neg())
    
    override def toString(): String = s"$numer/$denom"
end Rational

val x = Rational(1, 2)
x.toString()

val y = Rational(5, 7)
val z = Rational(3, 2)
x.add(y).mul(z)
x.sub(y).sub(z)
