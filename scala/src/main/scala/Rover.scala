
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
    prefix + position.x + ":" + position.y + ":" + direction
  }

  def turnRight(): Unit = {
    direction = grid.right(direction)
  }

  def turnLeft(): Unit = {
    direction = grid.left(direction)
  }

  def move(command: Char): Unit = {
    var newPosition: Position = Position(0, 0)
    if ((command == 'F' && direction == 'E') || (command == 'B' && direction == 'W'))
      newPosition = grid.incrementX(position)
    if ((command == 'F' && direction == 'S') || (command == 'B' && direction == 'N'))
      newPosition = grid.incrementY(position)
    if ((command == 'F' && direction == 'W') || (command == 'B' && direction == 'E'))
      newPosition = grid.decrementX(position)
    if ((command == 'F' && direction == 'N') || (command == 'B' && direction == 'S'))
      newPosition = grid.decrementY(position)
    if (grid.obstacleInPosition(newPosition)) {
      obstacleFound = true
    } else {
      position = newPosition
    }
  }

}
