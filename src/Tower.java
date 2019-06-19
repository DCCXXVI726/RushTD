import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Tower {
    Position pos;
    Image image = new ImageIcon("penis.png").getImage().getScaledInstance(
            32, 32,  java.awt.Image.SCALE_SMOOTH);

    public abstract Bullet attack();

}
