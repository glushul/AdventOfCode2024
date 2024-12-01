import scala.+:
import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    println(day1("inputs/day1.txt"))

  }

  def day1(file_name: String): Int = {
    val bufferedSource = Source.fromFile(file_name)

    val numbers = bufferedSource.getLines()
      .map { line =>
        val parts = line.split("\\s+").map(_.toInt)
        (parts(0), parts(1))
      }.toList

    bufferedSource.close()

    val list1 = numbers.map { case (first, _) => first }.sorted
    val list2 = numbers.map { case (_, second) => second }.sorted

    val result = (list1 zip list2).map{a =>
      if (a._1 < a._2) (a._2 - a._1) else if (a._2 < a._1) (a._1 - a._2) else 0
    }.sum

    result
  }

}