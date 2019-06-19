import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Bullet {
    protected Position pos;
    protected int size;
    protected Image image = new ImageIcon("sperm.png").getImage().getScaledInstance(
            32, 32,  java.awt.Image.SCALE_SMOOTH);

    public abstract void move();
}
