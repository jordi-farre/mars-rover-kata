public class Grid {

    public static final int MAX_WIDTH = 10;
    public static final int MAX_HEIGHT = 10;

    private Direction direction = Direction.NORTH;

    private int x;

    private int y;

    public void calculatePosition(char command) {
        if (command == 'R') {
            turnRight();
        } else if (command == 'L') {
            turnLeft();
        } else if (command == 'F') {
            moveForward();
        } else if (command == 'B') {
            moveBackward();
        }
    }

    private void moveForward() {
        switch (this.direction) {
            case EAST:
                incrementX();
                break;
            case WEST:
                decrementX();
                break;
            case NORTH:
                decrementY();
                break;
            case SOUTH:
                incrementY();
                break;
        }
    }

    private void moveBackward() {
        switch (this.direction) {
            case EAST:
                decrementX();
                break;
            case WEST:
                incrementX();
                break;
            case NORTH:
                incrementY();
                break;
            case SOUTH:
                decrementY();
                break;
        }
    }

    private void incrementY() {
        this.y = (y + 1) % MAX_HEIGHT;
    }

    private void decrementY() {
        this.y = this.y == 0 ? 9 : this.y - 1;
    }

    private void decrementX() {
        this.x = this.x == 0 ? 9 : this.x - 1;
    }

    private void incrementX() {
        this.x = (x + 1) % MAX_WIDTH;
    }

    private void turnLeft() {
        this.direction = direction.left();
    }

    private void turnRight() {
        this.direction = direction.right();
    }

    public String reportPosition() {
        return this.x + ":" + y +  ":" + this.direction.value();
    }

}
