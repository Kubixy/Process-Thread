package producer_consumer;

public class Producer extends Thread {
    private Queue queue;
    private int n;

    public Producer(Queue queue, int n) {
        this.queue = queue;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 5; i++){
            queue.put(i);
            System.out.printf(i + " -> Producer: " + n + ", produces: " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
