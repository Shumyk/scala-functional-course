package rocks.shumyk.functional.scala.recursion

import scala.annotation.tailrec

object Recursion:

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
    if c == r || c == 0 then 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
    @tailrec
    def _balance(chars: List[Char], openCount: Int): Boolean =
      if chars.isEmpty then openCount == 0
      else
        if chars.head == '(' then _balance(chars.tail, openCount + 1)
        else if chars.head == ')' then openCount > 0 && _balance(chars.tail, openCount - 1)
        else _balance(chars.tail, openCount)

    _balance(chars, 0)

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    def count(money: Int, coins: List[Int]): Int =
      if money == 0 then 1
      else if money > 0 && coins.nonEmpty then count(money - coins.head, coins) + count(money, coins.tail)
      else 0

    if money <= 0 then 0
    else count(money, coins)