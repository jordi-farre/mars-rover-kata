
class Grid(obstacles: List[Position]) {

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

  def incrementX(position: Position): Position = {
    position.copy(x = (position.x + 1) % MAX_WIDTH)
  }

  def incrementY(position: Position): Position = {
    position.copy(y = (position.y + 1) % MAX_HEIGHT)
  }

  def decrementX(position: Position): Position = {
    position.copy(x = if (position.x == 0) MAX_WIDTH - 1 else position.x - 1)
  }

  def decrementY(position: Position): Position = {
    position.copy(y = if (position.y == 0) MAX_HEIGHT - 1 else position.y - 1)
  }

  def obstacleInPosition(position: Position): Boolean = obstacles.contains(position)

}
