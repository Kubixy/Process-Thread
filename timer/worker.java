package timer;

import java.util.List;
import javax.swing.*;

public class worker extends SwingWorker<Double, Integer>{

    JLabel tag;
    JProgressBar progress;
    int time;

    public worker(JLabel tag, JProgressBar progress, int time){
        this.tag = tag;
        this.progress = progress;
        this.time = time;
    }

    @Override
    protected Double doInBackground() throws Exception {
        for (int i = time; i > 0; i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("Interrupted");
            }
            publish(i-1);
        }

        return 0.0;
    }

    @Override
    protected void done(){
        tag.setText("TIME");
    }

    @Override
    protected void process (List<Integer> chunks){
        progress.setValue(chunks.get(0));
    }
}
