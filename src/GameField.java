import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320;
    private final int CURSOR_SIZE = 32;
    private Image cursor;
    private int cursorX;
    private int cursorY;
    private Timer timer;
    private boolean inGame = true;
    private ArrayList<Tower> towers = new ArrayList<Tower>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private EnemyCast enemyCast = new EnemyCast(this);
    private BulletCast bulletCast = new BulletCast(this);

    public GameField() {
        setBackground(Color.white);
        loadImages();
        initGame();
        addKeyListener(new KeyListener());
        setFocusable(true);
    }

    public void castEnemy() {
        synchronized (enemies) {
            enemies.add(new SimpleEnemy(
                    new Position(SIZE, new Random().nextInt(SIZE)
                            / CURSOR_SIZE * CURSOR_SIZE)));
        }
    }

    public void moveEnemy() {
        synchronized (enemies) {
            for (Enemy enemy: enemies) {
                enemy.move();
            }
        }
    }

    public void moveBullet() {
        synchronized (bullets) {
            for (Bullet bullet: bullets) {
                bullet.move();
            }
        }
    }

    public void towerAttack() {
        synchronized (towers) {
            synchronized (bullets) {
                for (Tower tower : towers) {
                    bullets.add(tower.attack());
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            Graphics2D g2 = (Graphics2D) g;
            g.drawImage(cursor, cursorX, cursorY, this);
            synchronized (towers) {
                for (Tower element : towers) {
                    g.drawImage(element.image, element.pos.x, element.pos.y, this);
                }
            }
            synchronized (enemies) {
                for (Enemy enemy : enemies) {
                    g.drawImage(enemy.image, enemy.pos.x, enemy.pos.y, this);
                }
            }
            synchronized (bullets) {
                for (Bullet bullet : bullets) {
                    g.drawImage(bullet.image, bullet.pos.x, bullet.pos.y, this);
                }
            }
            g2.setStroke(new BasicStroke(3));
            for (int i = 0; i < SIZE; i += CURSOR_SIZE) {
                g2.drawLine(0, i, SIZE, i);
                g2.drawLine(i, 0, i, SIZE);
            }
        } else {
            String str = "Vagina wins";
            Font f = new Font("Arial Black", Font.BOLD, 14);
            g.setColor(Color.black);
            g.setFont(f);
            g.drawString(str, 125, SIZE / 2);
        }
    }

    public void initGame() {
        cursorX = SIZE / 2 - CURSOR_SIZE;
        cursorY = SIZE / 2 - CURSOR_SIZE;
        timer = new Timer(0, this);
        timer.start();
        enemyCast.start();
        bulletCast.start();
    }

    public void loadImages() {
        ImageIcon iic = new ImageIcon("cursor.png");
        cursor = iic.getImage().getScaledInstance(CURSOR_SIZE, CURSOR_SIZE,  java.awt.Image.SCALE_SMOOTH);
    }

    public void moveCursor(int key) {
        if (key == KeyEvent.VK_LEFT) {
            cursorX -= CURSOR_SIZE;
        }
        if (key == KeyEvent.VK_RIGHT) {
            cursorX += CURSOR_SIZE;
        }
        if (key == KeyEvent.VK_UP) {
            cursorY -= CURSOR_SIZE;
        }
        if (key == KeyEvent.VK_DOWN) {
            cursorY += CURSOR_SIZE;
        }
        if (cursorX < 0) {
            cursorX = 0;
        }
        if (cursorY < 0) {
            cursorY = 0;
        }
        if (cursorX > SIZE - 1) {
            cursorX = SIZE - CURSOR_SIZE;
        }
        if (cursorY > SIZE - 1) {
            cursorY = SIZE - CURSOR_SIZE;
        }
    }

    public void enemyDown() {
        ArrayList<Enemy> enemiesToDelete = new ArrayList<Enemy>();
        ArrayList<Bullet> bulletsToDelete = new ArrayList<Bullet>();

        synchronized (enemies) {
            synchronized (bullets) {

            for (Enemy enemy : enemies) {

                    for (Bullet bullet : bullets) {
                        if (bullet.pos.x == enemy.pos.x && bullet.pos.y == enemy.pos.y) {
                            bulletsToDelete.add(bullet);
                            enemiesToDelete.add(enemy);
                        }
                    }
                }
            }
        }
        for (Enemy enemy: enemiesToDelete) {
            enemies.remove(enemy);
        }
        for (Bullet bullet: bulletsToDelete) {
            bullets.remove(bullet);
        }
    }

    public void gameOver() {
        for (Enemy enemy: enemies) {
            if (enemy.pos.x == 0) {
                inGame = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            enemyDown();
            gameOver();
        } else {
            enemyCast.interrupt();
            bulletCast.interrupt();
        }
        repaint();
    }

    class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            moveCursor(key);
            if (key == KeyEvent.VK_1) {
                synchronized (towers) {
                    towers.add(new FireTower(new Position(cursorX, cursorY), CURSOR_SIZE));
                }
            }
            if (key == KeyEvent.VK_2) {
                inGame = false;
            }
        }
    }
}
