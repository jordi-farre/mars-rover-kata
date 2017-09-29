public class Rover {

    private Grid grid;

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public String execute(String commands) {
        commands.chars()
                .mapToObj(i -> (char) i)
                .forEach(grid::calculatePosition);
        return grid.reportPosition();
    }

}
