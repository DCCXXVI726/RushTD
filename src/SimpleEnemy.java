public class SimpleEnemy extends Enemy {
   SimpleEnemy(double x, double y) {
        hp = 1000000;
        speed = -1000000;
        this.x = x;
        this.y = y;
    }
    @Override
    public int takeDamage(int damage) {
        return hp - damage;
    }
}
