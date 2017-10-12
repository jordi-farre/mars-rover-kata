
class Rover(grid: Grid) {

  var direction = 'N'

  var x: Int = 0

  var y: Int = 0

  val MAX_WIDTH = 10

  val MAX_HEIGHT = 10

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
    prefix + x + ":" + y + ":" + direction
  }

  def turnRight(): Unit = {
    direction = grid.right(direction)
  }

  def turnLeft(): Unit = {
    direction = grid.left(direction)
  }

  def move(command: Char): Unit = {
    var newX = 0
    var newY = 0
    if ((command == 'F' && direction == 'E') || (command == 'B' && direction == 'W'))
      newX = grid.incrementX(x)
    if ((command == 'F' && direction == 'S') || (command == 'B' && direction == 'N'))
      newY = grid.incrementY(y)
    if ((command == 'F' && direction == 'W') || (command == 'B' && direction == 'E'))
      newX = grid.decrementX(x)
    if ((command == 'F' && direction == 'N') || (command == 'B' && direction == 'S'))
      newY = grid.decrementY(y)
    if (grid.obstacleInPosition(newX, newY)) {
      obstacleFound = true
    } else {
      x = newX
      y = newY
    }
  }

}
