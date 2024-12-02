import scala.io.Source

object Day2 {
  def part1(fileName: String): Int = {
    parse(fileName).map { a =>
      (a == a.sorted || a == a.sorted.reverse) &&
        a.sliding(2).forall {
          case List(a, b) => (Math.abs(b - a) >= 1) && (Math.abs(b - a) <= 3)
          case _ => true
        }
    }.count(_ == true)
  }

  def part2(fileName: String): Int = {
    def isSafe(a: List[Int]): Boolean = {
      (a == a.sorted || a == a.sorted.reverse) &&
        a.sliding(2).forall {
          case List(x, y) => (Math.abs(y - x) >= 1) && (Math.abs(y - x) <= 3)
          case _ => true
        }
    }

    parse(fileName).map { a =>
      if (isSafe(a)) {
        true
      } else {
        a.indices.exists { i =>
          val modifiedList = a.take(i) ++ a.drop(i + 1)
          isSafe(modifiedList)
        }
      }
    }.count(_==true)
  }

    def parse(fileName: String): List[List[Int]] = {
      val bufferedSource = Source.fromFile(fileName)

      bufferedSource.getLines().map(line =>
        line.split("\\s+").map(_.toInt).toList
      ).toList
    }
}
