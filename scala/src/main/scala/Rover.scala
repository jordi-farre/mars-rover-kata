
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
      if (command == 'F') moveForward(command)
      if (command == 'B') moveBackward(command)
    }
    formatResult()
  }

  def turnRight(): Unit = {
    direction = grid.right(direction)
  }

  def turnLeft(): Unit = {
    direction = grid.left(direction)
  }

  def moveForward(command: Char): Unit = {
    val newPosition: Position = direction.forward(position)
    checkObstacles(newPosition)
  }

  def moveBackward(command: Char): Unit = {
    val newPosition: Position = direction.backward(position)
    checkObstacles(newPosition)
  }

  def checkObstacles(newPosition: Position): Unit = {
    if (grid.obstacleIn(newPosition)) obstacleFound = true
    else position = newPosition
  }

  def formatResult(): String = {
    val prefix = if (obstacleFound) "O:" else ""
    s"$prefix${position.x}:${position.y}:${direction.value}"
  }

}
