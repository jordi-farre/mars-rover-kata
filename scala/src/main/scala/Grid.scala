
class Grid {

  val directions = List('N', 'E', 'S', 'W')

  val MAX_WIDTH = 10

  val MAX_HEIGHT = 10

  def right(actualDirection: Char): Char = {
    val actualDirectionIndex = directions.indexOf(actualDirection)
    directions((actualDirectionIndex + 1) % 4)
  }

  def left(actualDirection: Char): Char = {
    val actualDirectionIndex = directions.indexOf(actualDirection)
    if (actualDirectionIndex == 0) {
      directions.last
    } else {
      directions(actualDirectionIndex - 1)
    }
  }

}
