import javax.swing.*;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();

    }

    public MainWindow() {
        setTitle("Tower Defence");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 345);
        setLocation(400, 400);
        add(new GameField());
        setVisible(true);
    }
}
