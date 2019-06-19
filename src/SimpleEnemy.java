import javax.swing.*;

public class SimpleEnemy extends Enemy {

    public SimpleEnemy(Position pos) {
        this.pos = pos;
    }

    @Override
    public void move() {
       pos.x -= 32;
    }
}
