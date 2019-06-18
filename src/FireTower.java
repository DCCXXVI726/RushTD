import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FireTower extends Tower {

    public FireTower(Position pos) {
        this.pos = pos;
        this.damage = 5;
        this.fireRate = 3;
        ImageIcon iic = new ImageIcon("FireTower.png");
        this.image = iic.getImage().getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH);
    }

    @Override
    public Bullet attack() {
        return new Bullet();
    }
}
