import javax.swing.*;
import java.awt.*;

public abstract class Enemy {
    Position pos;
    Image image = new ImageIcon("vagina.png").getImage().getScaledInstance(
            32, 32,  java.awt.Image.SCALE_SMOOTH);
    public abstract void move();
}
