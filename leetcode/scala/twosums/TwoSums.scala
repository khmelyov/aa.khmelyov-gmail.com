package leetcode.scala.twosums

import scala.collection.immutable.HashMap

// неоптимальный
object TwoSums extends App {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] =
    numbers
      .zipWithIndex
      .foldLeft((HashMap.empty[Int, Int], List.empty[Int])) {
        case ((acc, arr), (num, i)) if acc.contains(target - num) && (!acc.get(target - num).contains(i)) => (acc.updated(num, i), arr ++ List(acc.getOrElse(target - num, 0), i))
        case ((acc, arr), (num, i)) => (acc.updated(num, i), arr)
      }
      ._2
      .toArray
}
