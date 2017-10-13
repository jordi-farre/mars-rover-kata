

class Grid(obstacles: List[Position]) {

  val directions = List(new North(), new East(), new South(), new West())

  def right(actualDirection: Direction): Direction = {
    val actualDirectionIndex = directions.indexOf(directions.find(direction => actualDirection.value == direction.value).head)
    directions((actualDirectionIndex + 1) % 4)
  }

  def left(actualDirection: Direction): Direction = {
    val actualDirectionIndex = directions.indexOf(directions.find(direction => actualDirection.value == direction.value).head)
    if (actualDirectionIndex == 0) {
      directions.last
    } else {
      directions(actualDirectionIndex - 1)
    }
  }

  def obstacleIn(position: Position): Boolean = obstacles.contains(position)

}

object Grid {

  val MAX_WIDTH = 10

  val MAX_HEIGHT = 10

  def incrementX(position: Position): Position = {
    position.copy(x = (position.x + 1) % Grid.MAX_WIDTH)
  }

  def incrementY(position: Position): Position = {
    position.copy(y = (position.y + 1) % Grid.MAX_HEIGHT)
  }

  def decrementX(position: Position): Position = {
    position.copy(x = if (position.x == 0) Grid.MAX_WIDTH - 1 else position.x - 1)
  }

  def decrementY(position: Position): Position = {
    position.copy(y = if (position.y == 0) Grid.MAX_HEIGHT - 1 else position.y - 1)
  }

}

abstract class Direction {

  def value: Char

  def forward(position: Position): Position

  def backward(position: Position): Position

}

class North extends Direction {

  val value = 'N'

  override def forward(position: Position): Position = Grid.decrementY(position)

  override def backward(position: Position): Position = Grid.incrementY(position)

}

class East extends Direction {

  val value = 'E'

  override def forward(position: Position): Position = Grid.incrementX(position)

  override def backward(position: Position): Position = Grid.decrementX(position)

}

class South extends Direction {

  val value = 'S'

  override def forward(position: Position): Position = Grid.incrementY(position)

  override def backward(position: Position): Position = Grid.decrementY(position)

}

class West extends Direction {

  val value = 'W'

  override def forward(position: Position): Position = Grid.decrementX(position)

  override def backward(position: Position): Position = Grid.incrementX(position)

}

