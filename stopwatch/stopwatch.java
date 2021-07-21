package stopwatch;

import java.awt.*;
import javax.swing.*;

public class stopwatch {

    public static void main(String[] args) {
        new stopwatch();
    }

    public stopwatch() {
        JFrame v = new JFrame();
        v.setLayout(new GridLayout(2,0));
        v.setTitle("Timer");
        v.setSize(100,100);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        v.setLocationRelativeTo(null);

        JLabel output = new JLabel("O");
        JButton acc = new JButton("Start");
        acc.addActionListener(e -> {
            worker worker = new worker(output, 10);
            worker.execute();
        });

        v.add(output);
        v.add(acc);
        v.setVisible(true);
    }
}
