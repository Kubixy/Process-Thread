package timer;

import java.util.concurrent.ExecutionException;
import javax.swing.*;

public class timer {

    public static void main(String[] args) {
        new timer();
    }

    public timer() {
        JFrame window = new JFrame();
        JLabel message = new JLabel("unmodified");

        window.getContentPane().add(message);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        JProgressBar progressBar = new JProgressBar(0,100);
        JDialog dialog = new JDialog(window, "Progress");
        dialog.getContentPane().add(progressBar);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        worker worker = new worker(message, progressBar, 100);
        worker.execute();

        try {
            System.out.println("Result: "+ worker.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
