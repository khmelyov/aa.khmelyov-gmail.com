package leetcode.scala

import scala.collection.immutable.HashMap


// неоптимальный
object task1 extends App {
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

// более оптимальный вариант
object task1_opt extends App {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    val indices = scala.collection.mutable.Map[Int, Int]()

    for (i <- numbers.indices) {
      indices.get(target - numbers(i)) match {
        case Some(j) => return Array(j, i)
        case None => indices(numbers(i)) = i
      }
    }
    Array.empty[Int]
  }
}