public class FireBullet extends Bullet {
    public FireBullet(int damage, int speed, Position pos) {
        this.damage = damage;
        this.speed = speed;
        this.pos = pos;
    }

    @Override
    public void move() {

    }
    @Override
    public boolean isHit() {
        return true;
    }
}
