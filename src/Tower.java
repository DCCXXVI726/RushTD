import java.awt.*;

public abstract class Tower {
    int damage;
    Position pos;
    int fireRate;
    Image image;

    public abstract Bullet attack();

}
