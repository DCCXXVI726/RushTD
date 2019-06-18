public class Position {
    int x;
    int y;

    public boolean equals(Position pos) {
        return this.x == pos.x && this.y == pos.y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
