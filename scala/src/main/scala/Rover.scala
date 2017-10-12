
class Rover(grid: Grid) {

  var direction = 'N'

  var x: Int = 0

  var y: Int = 0

  val MAX_WIDTH = 10

  val MAX_HEIGHT = 10

  def execute(commands: String): String =
    commands
      .toCharArray
      .map(command => processCommand(command))
      .last


  def processCommand(command: Char): String = {
    if (command == 'R') turnRight()
    if (command == 'L') turnLeft()
    if (command == 'F' || command == 'B') move(command)
    x + ":" + y + ":" + direction
  }

  def turnRight(): Unit = {
    direction = grid.right(direction)
  }

  def turnLeft(): Unit = {
    direction = grid.left(direction)
  }

  def move(command: Char): Unit = {
    if ((command == 'F' && direction == 'E') || (command == 'B' && direction == 'W'))
      x = grid.incrementX(x)
    if ((command == 'F' && direction == 'S') || (command == 'B' && direction == 'N'))
      y = grid.incrementY(y)
    if ((command == 'F' && direction == 'W') || (command == 'B' && direction == 'E'))
      x = grid.decrementX(x)
    if ((command == 'F' && direction == 'N') || (command == 'B' && direction == 'S'))
      y = grid.decrementY(y)
  }

}
