
class Rover {

  var direction = 'N'

  var directions = List('N', 'E', 'S', 'W')

  def execute(commands: String): String =
    commands
      .toCharArray
      .map(command => processCommand(command))
      .last

  def processCommand(command: Char): String = {
    if (command == 'R') turnRight()
    if (command == 'L') turnLeft()
    "0:0:" + direction
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

}
