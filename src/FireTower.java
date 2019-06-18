public class FireTower extends Tower {

    public FireTower(Position pos, int fireRate) {
        this.pos = pos;
        this.damage = 5;
        this.fireRate = fireRate;
    }

    @Override
    public Bullet attack() {
        return new Bullet();
    }
}
