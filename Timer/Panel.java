package Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {
    public static JLabel label = new JLabel("00:00");
    private static JButton startbutton = new JButton("Start");
    private JButton[] buttons = new JButton[10];
    public static int time = 0;

    Panel() {
        this.setBackground(Color.GRAY);

        label.setBounds(50, 5, 150, 300);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 50));
        label.setForeground(Color.WHITE);
        this.add(label);

        startbutton.setBounds(0, 5, 25, 300);
        startbutton.setFont(new Font(label.getFont().getName(), Font.PLAIN, 100));
        startbutton.setBackground(new Color(108, 149, 241));
        startbutton.setForeground(Color.WHITE);
        startbutton.addActionListener(this);
        this.add(startbutton);
        numbersMake();
    }

    public void numbersMake() {
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(i + "");
            buttons[i].setBounds(i * (50 + 10) + 50, (50 + 10) + 280, 50, 50);
            buttons[i].setFont(new Font(label.getFont().getName(), Font.PLAIN, 25));
            buttons[i].setBackground(Color.DARK_GRAY);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(this);
            add(buttons[i]);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getSource().equals(startbutton)) {
            time = time * 10 +
                    Integer.parseInt(Character.toString(
                            e.getSource().toString().charAt(e.getSource().toString().indexOf("text") + 5)));
            label.setText(time / 1000 + "" + time / 100 % 10 + ":" + time / 10 % 10 + time % 10);
        }
        if (e.getSource().equals(startbutton) && MyThread.second == 0) {
            MyThread td = new MyThread(time % 100 + time / 100 * 60);
            td.start();
            time = 0;
        }

    }
}
