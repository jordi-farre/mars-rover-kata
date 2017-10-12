
class Rover(grid: Grid) {

  var direction = 'N'

  var position = Position(0, 0)

  var obstacleFound = false

  def execute(commands: String): String =
    commands
      .toCharArray
      .map(command => processCommand(command))
      .last


  def processCommand(command: Char): String = {
    if (!obstacleFound) {
      if (command == 'R') turnRight()
      if (command == 'L') turnLeft()
      if (command == 'F' || command == 'B') move(command)
    }
    val prefix = if (obstacleFound) "O:" else ""
    s"$prefix${position.x}:${position.y}:$direction"
  }

  def turnRight(): Unit = {
    direction = grid.right(direction)
  }

  def turnLeft(): Unit = {
    direction = grid.left(direction)
  }

  def move(command: Char): Unit = {
    var newPosition: Position = Position(0, 0)
    if (forwardEast(command) || backwardWest(command))
      newPosition = grid.incrementX(position)
    if (forwardSouth(command) || backwardNorth(command))
      newPosition = grid.incrementY(position)
    if (forwardWest(command) || backwardEast(command))
      newPosition = grid.decrementX(position)
    if (forwardNorth(command) || backwardSouth(command))
      newPosition = grid.decrementY(position)
    if (grid.obstacleIn(newPosition)) {
      obstacleFound = true
    } else {
      position = newPosition
    }
  }

  private def backwardSouth(command: Char) = {
    command == 'B' && direction == 'S'
  }

  private def forwardNorth(command: Char) = {
    command == 'F' && direction == 'N'
  }

  private def backwardEast(command: Char) = {
    command == 'B' && direction == 'E'
  }

  private def forwardWest(command: Char) = {
    command == 'F' && direction == 'W'
  }

  private def backwardNorth(command: Char) = {
    command == 'B' && direction == 'N'
  }

  private def forwardSouth(command: Char) = {
    command == 'F' && direction == 'S'
  }

  private def backwardWest(command: Char) = {
    command == 'B' && direction == 'W'
  }

  private def forwardEast(command: Char) = {
    command == 'F' && direction == 'E'
  }

}
