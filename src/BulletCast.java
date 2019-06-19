public class BulletCast extends Thread {
    private GameField game;

    public BulletCast(GameField game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            game.moveBullet();
            try {
                sleep(700);
            } catch (Exception e) {}
        }
    }
}
