def abs(x: Double) = if (x < 0) -x else x

def sqrt(x: Double) =
	def improve(guess: Double) = 
		(guess + x / guess) / 2

	def isGoodEnough(guess: Double) = 
		abs(guess * guess - x) < 0.001

	def sqrtIter(guess: Double): Double =
		if isGoodEnough(guess) then guess
		else sqrtIter(improve(guess))

	sqrtIter(1)

@main def main() = println(sqrt(100))
	
