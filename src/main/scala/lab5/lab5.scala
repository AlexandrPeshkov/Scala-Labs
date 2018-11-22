package main.scala.lab5

import scala.collection.mutable.ListBuffer

object Lab5 {

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  def balance(chars: List[Char]): Boolean = {
    def check(chars: List[Char], openParenthesesCount: Int): Boolean = {
      if (chars.isEmpty) {
        openParenthesesCount == 0
      } else {
        val head = chars.head
        val count =
          if (head == '(') openParenthesesCount + 1
          else if (head == ')') openParenthesesCount - 1
          else openParenthesesCount
        if (count >= 0) check(chars.tail, count)
        else false
      }
    }
    check(chars, 0)
  }

  def countChange(money: Int, coins: List[Int]): Int = {
    def check(totalCoinCount: List[(Int, Int)], count: Int): Int = {
      if (totalCoinCount.isEmpty) {
        count
      } else {
        val buffer = ListBuffer[(Int, Int)]()
        var newCount = count
        for ((lastMaxCoin, total) <- totalCoinCount) {
          if (total < money) {
            for (coin <- coins) {
              if (coin >= lastMaxCoin) {
                val variant = (coin, total + coin)
                buffer += variant
              }
            }
          } else if (total == money) {
            newCount += 1
          }
        }

        check(buffer.toList, newCount)
      }
    }

    val b = coins.map { c => (c, c) }
    check(b, 0)
  }
}