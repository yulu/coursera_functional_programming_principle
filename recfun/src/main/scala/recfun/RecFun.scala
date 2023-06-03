package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
    if c < 0 || c > r then 0
    else if r == 0 || r == 1 then 1 
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = 
    def balanceInner(chars: List[Char], left: Int): Boolean = 
      if chars.isEmpty then left == 0
      else
        val first = chars.head
        if first == '(' then balanceInner(chars.tail, left + 1)
        else if first == ')' then (if left > 0 then balanceInner(chars.tail, left - 1) else false)
        else balanceInner(chars.tail, left)

    balanceInner(chars, 0)

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if money == 0 then 1
    else if money < 0 then 0
    else if coins.isEmpty then 0
    else
      val first = coins.head
      var count = 0
      var ways = 0
      while (money - first * count >= 0) {
        ways = ways + countChange(money - first * count, coins.tail)
        count += 1
      }
      ways

