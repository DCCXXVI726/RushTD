public abstract class Bullet {
    int damage;
    int speed;
    Position pos;

    public abstract void move();

    public abstract boolean isHit();
}