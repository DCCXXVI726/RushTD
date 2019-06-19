import javax.swing.*;

public class FireBullet extends Bullet {

    public FireBullet(Position pos, int size) {
        this.pos = pos;
        this.size = size;
    }

    @Override
    public void move(){
        pos.x += size;
    }
}
