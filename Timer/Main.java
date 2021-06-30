package Timer;

import javax.swing.*;


public class Main {

    private static JFrame window;

    public static void main(String[] args) {
        window = new JFrame("TIMERRRRRRRRRRRRRRRRRRR");
        window.setSize(300, 600);
        window.setLocationRelativeTo(null);
        window.add(new Panel());
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
