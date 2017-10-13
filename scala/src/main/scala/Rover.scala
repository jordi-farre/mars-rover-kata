
class Rover(grid: Grid) {

  var direction: Direction = new North();

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
    s"$prefix${position.x}:${position.y}:${direction.value}"
  }

  def turnRight(): Unit = {
    direction = grid.right(direction)
  }

  def turnLeft(): Unit = {
    direction = grid.left(direction)
  }

  def move(command: Char): Unit = {
    var newPosition: Position = Position(0, 0)
    if (command == 'F')
      newPosition = direction.forward(position)
    if (command == 'B')
      newPosition = direction.backward(position)
    if (grid.obstacleIn(newPosition)) {
      obstacleFound = true
    } else {
      position = newPosition
    }
  }

}
