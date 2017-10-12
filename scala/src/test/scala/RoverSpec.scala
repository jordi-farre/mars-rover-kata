import org.scalatest.FlatSpec
import org.scalatest.prop.TableDrivenPropertyChecks

class RoverSpec extends FlatSpec with TableDrivenPropertyChecks  {

  val rover: Rover = new Rover()

  val turnRightSamples =
    Table(
      ("commands", "output"),
      ("R", "0:0:E"),
      ("RR", "0:0:S"),
      ("RRR", "0:0:W"),
      ("RRRR", "0:0:N")
    )

  forAll(turnRightSamples) { (commands: String, output: String) =>
    val result = new Rover().execute(commands)

    assert(result == output)
  }

  val turnLeftSamples =
    Table(
      ("commands", "output"),
      ("L", "0:0:W"),
      ("LL", "0:0:S"),
      ("LLL", "0:0:E"),
      ("LLLL", "0:0:N")
    )

  forAll(turnLeftSamples) { (commands: String, output: String) =>
    val result = new Rover().execute(commands)

    assert(result == output)
  }

}
