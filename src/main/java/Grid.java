public class Grid {

    public static final int MAX_WIDTH = 10;
    public static final int MAX_HEIGHT = 10;

    private Direction direction = Direction.NORTH;

    private Point position = new Point(0, 0);

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
        int y = (this.position.y() + 1) % MAX_HEIGHT;
        this.position = new Point(this.position.x(), y);
    }

    private void decrementY() {
        int y = this.position.y() == 0 ? 9 : this.position.y() - 1;
        this.position = new Point(this.position.x(), y);
    }

    private void decrementX() {
        int x = this.position.x() == 0 ? 9 : this.position.x() - 1;
        this.position = new Point(x, this.position.y());
    }

    private void incrementX() {
        int x = (this.position.x() + 1) % MAX_WIDTH;
        this.position = new Point(x, this.position.y());
    }

    private void turnLeft() {
        this.direction = direction.left();
    }

    private void turnRight() {
        this.direction = direction.right();
    }

    public String reportPosition() {
        return this.position.x() + ":" + this.position.y() +  ":" + this.direction.value();
    }

}
