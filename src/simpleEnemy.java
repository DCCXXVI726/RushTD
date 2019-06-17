public class simpleEnemy extends Enemy {

    @Override
    public int takeDamage(int damage) {
        return hp - damage;
    }
}
