import java.util.Arrays;

public class Rover {

    private char direction = 'N';

    public String execute(String commands) {
        commands.chars()
                .mapToObj(i -> (char) i)
                .forEach(this::calculateDirection);
        return "0:0:" + this.direction;
    }

    private enum Coordinate {

        NORTH('N'),
        EAST('E'),
        SOUTH('S'),
        WEST('W');

        private char value;
        private Coordinate left;
        private Coordinate right;

        static {
            NORTH.left = WEST;
            NORTH.right = EAST;
            EAST.left = NORTH;
            EAST.right = SOUTH;
            SOUTH.left = EAST;
            SOUTH.right = WEST;
            WEST.left = SOUTH;
            WEST.right = NORTH;
        }

        Coordinate(char value) {
            this.value = value;
        }

        public static Coordinate get(char value) {
            return Arrays.stream(values())
                    .filter(coordinate -> coordinate.value == value)
                    .findFirst()
                    .get();
        }

        public Coordinate getLeft() {
            return left;
        }

        public Coordinate getRight() {
            return right;
        }
    }

    private void calculateDirection(char command) {
        Coordinate actualCoordinate = Coordinate.get(this.direction);
        if (command == 'R') {
            this.direction = actualCoordinate.right.value;
        } else {
            this.direction = actualCoordinate.left.value;
        }
    }

}
