public class Bullet {
    int damage;
    int speed;
    Position pos;

    public void move(){}

	public abstract void explosion(ArrayList<Enemy> enemies);
    public boolean isHit(){return true;}
}
