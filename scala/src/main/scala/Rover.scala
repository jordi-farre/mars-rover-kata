
class Rover {

  var direction = 'N'

  var x: Int = 0

  var y: Int = 0

  var directions = List('N', 'E', 'S', 'W')

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
    val actualDirectionIndex = directions.indexOf(direction)
    direction = directions((actualDirectionIndex + 1) % 4)
  }

  def turnLeft(): Unit = {
    val actualDirectionIndex = directions.indexOf(direction)
    if (actualDirectionIndex == 0) {
      direction = directions.last
    } else {
      direction = directions(actualDirectionIndex - 1)
    }
  }

  def move(command: Char) = {
    if ((command == 'F' && direction == 'E') || (command == 'B' && direction == 'W'))
      x = (x + 1) % 10
    if ((command == 'F' && direction == 'S') || (command == 'B' && direction == 'N'))
      y = (y + 1) % 10
    if ((command == 'F' && direction == 'W') || (command == 'B' && direction == 'E'))
      if (x == 0) x = 10 - 1 else x -= 1
    if ((command == 'F' && direction == 'N') || (command == 'B' && direction == 'S'))
      if (y == 0) y = 10 - 1 else y -= 1
  }

}
