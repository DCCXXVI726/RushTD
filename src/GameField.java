import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320;
    private final int CURSOR_SIZE = 32;
    private final int ALL_DOTS = 400;
    private Image cursor;
    private int cursorX;
    private int cursorY;
    private Timer timer;
    private boolean inGame = true;
    private ArrayList<Tower> towers = new ArrayList<Tower>();

    public GameField() {
        setBackground(Color.white);
        loadImages();
        initGame();
        addKeyListener(new KeyListener());
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            Graphics2D g2 = (Graphics2D) g;
            g.drawImage(cursor, cursorX, cursorY, this);
            for (Tower element: towers) {
                g.drawImage(element.image, element.pos.x, element.pos.y, this);
            }
            g2.setStroke(new BasicStroke(3));
            for (int i = 0; i < SIZE; i += CURSOR_SIZE) {
                g2.drawLine(0, i, SIZE, i);
                g2.drawLine(i, 0, i, SIZE);
            }
        }
    }

    public void initGame() {
        cursorX = SIZE / 2 - CURSOR_SIZE;
        cursorY = SIZE / 2 - CURSOR_SIZE;
        timer = new Timer(0, this);
        timer.start();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {

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
                towers.add(new FireTower(new Position(cursorX, cursorY)));
            }
        }
    }
}
