import java.util.Arrays;

enum Coordinate {

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

    public Coordinate left() {
        return left;
    }

    public Coordinate right() {
        return right;
    }

    public char value() {
        return value;
    }
}
