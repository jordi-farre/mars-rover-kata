
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

  def incrementX(x: Int): Int = (x + 1) % MAX_WIDTH

  def incrementY(y: Int): Int = (y + 1) % MAX_HEIGHT

  def decrementX(x: Int): Int = if (x == 0) MAX_WIDTH - 1 else x - 1

  def decrementY(y: Int): Int = if (y == 0) MAX_HEIGHT - 1 else y - 1


}
