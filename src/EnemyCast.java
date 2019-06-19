import java.util.ArrayList;
import java.util.Random;

public class EnemyCast extends Thread {
    private GameField game;

    public EnemyCast(GameField game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            game.castEnemy();
            game.moveEnemy();
            game.towerAttack();
            try {
                sleep(2100);
            } catch (Exception e) {}
        }
    }
}
