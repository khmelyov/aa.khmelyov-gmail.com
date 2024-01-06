package leetcode.scala.twosums

// более оптимальный вариант
object TwoSums_opt extends App {
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
