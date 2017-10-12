
class Rover {

  var direction = 'N'

  var directions = List('N', 'E', 'S', 'W')

  def execute(commands: String): String =
    commands
      .toCharArray
      .map(command => processCommand(command))
      .last

  def processCommand(command: Char): String = {
    turnRight()
    "0:0:" + direction
  }

  def turnRight(): Unit = {
    val actualDirectionIndex = directions.indexOf(direction)
    direction = directions((actualDirectionIndex + 1) % 4)
  }

}
