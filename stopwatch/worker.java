package stopwatch;

import javax.swing.*;

public class worker extends SwingWorker<Double, Integer>{

    JLabel tag;
    int time;

    public worker(JLabel tag, int time) {
        this.tag = tag;
        this.time = time;
    }

    @Override
    protected Double doInBackground() {
        for (int i = time; i > 0; i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("Interrupted");
            }
            tag.setText(i+"");
            publish(i-1);
        }

        return 0.0;
    }

    @Override
    protected void done(){
        tag.setText("TIME");
    }
}
