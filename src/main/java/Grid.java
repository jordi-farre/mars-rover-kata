import java.util.ArrayList;
import java.util.List;

public class Grid {

    public static final int MAX_WIDTH = 10;
    public static final int MAX_HEIGHT = 10;

    private Direction direction = Direction.NORTH;

    private Point position = new Point(0, 0);
    private List<Point> obstacles;
    private boolean obstacleFound;

    public Grid() {
        this.obstacles = new ArrayList<>();
    }

    public Grid(List<Point> obstacles) {
        this.obstacles = obstacles;
    }

    public void calculatePosition(char command) {
        if (this.obstacleFound) {
            return;
        }
        switch (command) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'F':
                moveForward();
                break;
            case 'B':
                moveBackward();
                break;
        }
    }

    private void moveForward() {
        Point newPosition = this.position;
        switch (this.direction) {
            case EAST:
                newPosition = incrementX();
                break;
            case WEST:
                newPosition = decrementX();
                break;
            case NORTH:
                newPosition = decrementY();
                break;
            case SOUTH:
                newPosition = incrementY();
                break;
        }
        checkObstaclesAndMoveTo(newPosition);
    }

    private void moveBackward() {
        Point newPosition = this.position;
        switch (this.direction) {
            case EAST:
                newPosition = decrementX();
                break;
            case WEST:
                newPosition = incrementX();
                break;
            case NORTH:
                newPosition = incrementY();
                break;
            case SOUTH:
                newPosition = decrementY();
                break;
        }
        checkObstaclesAndMoveTo(newPosition);
    }

    private void checkObstaclesAndMoveTo(Point newPosition) {
        if (this.obstacles.contains(newPosition)) {
            this.obstacleFound = true;
        } else {
            this.position = newPosition;
        }
    }

    private Point incrementY() {
        int y = (this.position.y() + 1) % MAX_HEIGHT;
        return new Point(this.position.x(), y);
    }

    private Point decrementY() {
        int y = this.position.y() == 0 ? 9 : this.position.y() - 1;
        return new Point(this.position.x(), y);
    }

    private Point decrementX() {
        int x = this.position.x() == 0 ? 9 : this.position.x() - 1;
        return new Point(x, this.position.y());
    }

    private Point incrementX() {
        int x = (this.position.x() + 1) % MAX_WIDTH;
        return new Point(x, this.position.y());
    }

    private void turnLeft() {
        this.direction = direction.left();
    }

    private void turnRight() {
        this.direction = direction.right();
    }

    public String reportPosition() {
        String obstaclePrefix = this.obstacleFound ? "O:" : "";
        return obstaclePrefix + this.position.x() + ":" + this.position.y() +  ":" + this.direction.value();
    }

}
