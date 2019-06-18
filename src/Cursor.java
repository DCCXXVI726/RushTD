import java.util.ArrayList;

public class Cursor {
    Position pos;

    public void deleteTower(Position pos, ArrayList<Tower> towerList) {
        for (Tower tower: towerList) {
            if (tower.pos.equals(pos)) {
                towerList.remove(tower);
                break;
            }
        }
    }

    public Cursor(int x, int y) {
        this.pos = new Position(x, y);
    }
}
