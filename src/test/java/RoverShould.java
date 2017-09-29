import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RoverShould {

    private Rover rover = new Rover();

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


}
