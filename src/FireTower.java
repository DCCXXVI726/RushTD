import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FireTower extends Tower {
    private int size;

    public FireTower(Position pos, int size) {
        this.size = size;
        this.pos = pos;
    }

    @Override
    public Bullet attack() {
        return new FireBullet(new Position(pos.x + size, pos.y ), size);
    }
}
