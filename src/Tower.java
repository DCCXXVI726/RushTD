import java.awt.*;
import java.util.ArrayList;

public abstract class Tower {
    int damage;
    Position pos;
    int fireRate;
    Image image;

    public abstract Bullet attack();

}
