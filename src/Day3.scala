import scala.io.Source
import scala.util.Try

object Day3 {
  def part1(fileName: String): Int = {
    multiply(parse(fileName))
  }

  def part2(fileName: String): Int = {
    parse(fileName)
      .split("do\\(\\)")
      .toList
      .map { b =>
        multiply(b.split("don't\\(\\)").toList.head)
      }
      .sum
  }

  def multiply(input: String): Int = {
    input
      .split("mul")
      .map(c =>
        if (c.headOption.getOrElse("") == '(')
          c.split(')')
            .head
            .drop(1)
            .split(',')
            .map(d => if (Try(d.toInt).isSuccess) d.toInt else 0)
            .product
        else 0
      )
      .filterNot(_ == ())
      .sum
  }

  def parse(fileName: String): String = {
    val bufferedSource = Source.fromFile(fileName)

    val res = Source.fromFile(fileName).getLines().mkString(" ")

    bufferedSource.close()
    res
  }
}