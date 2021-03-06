import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RoverShould {

    private Rover rover = new Rover(new Grid());

    @ParameterizedTest(name = "commands: {0} -- result: {1}")
    @CsvSource({"R, 0:0:E", "RR, 0:0:S", "RRR, 0:0:W", "RRRR, 0:0:N"})
    public void turn_right(String commands, String result) {
        String finalPosition = this.rover.execute(commands);

        assertThat(finalPosition, is(result));
    }

    @ParameterizedTest(name = "commands: {0} -- result: {1}")
    @CsvSource({"L, 0:0:W", "LL, 0:0:S", "LLL, 0:0:E", "LLLL, 0:0:N"})
    public void turn_left(String commands, String result) {
        String finalPosition = this.rover.execute(commands);

        assertThat(finalPosition, is(result));
    }

    @ParameterizedTest(name = "commands: {0} -- result: {1}")
    @CsvSource({"RF, 1:0:E", "RFFFFFF, 6:0:E", "RFFFFFFFFFF, 0:0:E",
            "RFFFFFFFFFFFFFFF, 5:0:E", "LF, 9:0:W", "LFFFFFFFFFFFFFFF, 5:0:W",
            "F, 0:9:N", "FFFFFFFFFFFFFF, 0:6:N", "RRF, 0:1:S", "RRFFFFFFFFFF, 0:0:S", "RRFFFFFFFFFFFFF, 0:3:S"})
    public void move_forward(String commands, String result) {
        String finalPosition = this.rover.execute(commands);

        assertThat(finalPosition, is(result));
    }

    @ParameterizedTest(name = "commands: {0} -- result: {1}")
    @CsvSource({"RB, 9:0:E", "RBBBBBB, 4:0:E", "RBBBBBBBBBB, 0:0:E",
            "RBBBBBBBBBBBBBBB, 5:0:E", "LB, 1:0:W", "LBBBBBBBBBBBBBBB, 5:0:W",
            "B, 0:1:N", "BBBBBBBBBBBBBB, 0:4:N", "RRB, 0:9:S", "RRBBBBBBBBBB, 0:0:S", "RRBBBBBBBBBBBBB, 0:7:S"})
    public void move_backward(String commands, String result) {
        String finalPosition = this.rover.execute(commands);

        assertThat(finalPosition, is(result));
    }

    @ParameterizedTest(name = "commands: {0} -- result: {1}")
    @CsvSource({"RFFF, O:2:0:E", "RFFFRFFFFF, O:2:0:E"})
    public void find_obstacle(String commands, String result) {
        List<Point> obstacles = Arrays.asList(new Point(3, 0));
        this.rover = new Rover(new Grid(obstacles));
        String finalPosition = this.rover.execute(commands);

        assertThat(finalPosition, is(result));
    }

}
