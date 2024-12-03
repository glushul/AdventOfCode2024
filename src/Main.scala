import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    println("Day 1:")
    println(Day1.part1("inputs/day1.txt"))
    println(Day1.part2("inputs/day1.txt"))

    println("Day 2:")
    println(Day2.part1("inputs/day2.txt"))
    println(Day2.part2("inputs/day2.txt"))

    println("Day 3:")
    println(Day3.part1("inputs/day3.txt"))
    println(Day3.part2("inputs/day3.txt"))
  }
}