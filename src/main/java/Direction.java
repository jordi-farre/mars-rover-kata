import java.util.Arrays;

enum Direction {

    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private char value;

    private Direction left;
    private Direction right;
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

    Direction(char value) {
        this.value = value;
    }

    public static Direction get(char value) {
        return Arrays.stream(values())
                .filter(direction -> direction.value == value)
                .findFirst()
                .get();
    }

    public Direction left() {
        return left;
    }

    public Direction right() {
        return right;
    }

    public char value() {
        return value;
    }
}
