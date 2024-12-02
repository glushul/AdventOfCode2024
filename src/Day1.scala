import scala.io.Source

object Day1 {
  def part1(fileName: String): Int = {
    val (list1, list2) = parseAndUnzip(fileName)

    (list1.sorted zip list2.sorted).map{ case (a, b) =>
      Math.abs(a - b)
    }.sum
  }

  def part2(fileName: String): Int = {
    val (list1, list2) = parseAndUnzip(fileName)

    list1.map(a => a * list2.count(_ == a)).sum
  }

  def parseAndUnzip(fileName: String): (List[Int], List[Int]) = {
    val bufferedSource = Source.fromFile(fileName)

    bufferedSource.getLines()
      .map { line =>
        val parts = line.split("\\s+").map(_.toInt)
        (parts(0), parts(1))
      }.toList.unzip
  }
}
