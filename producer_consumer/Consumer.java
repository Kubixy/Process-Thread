package producer_consumer;

public class Consumer extends Thread {
    private Queue queue;
    private int n;

    public Consumer(Queue queue, int n) {
        this.queue = queue;
        this.n = n;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 5; i++) {
            value = queue.get();
            System.out.println(i + " -> Consumer: " + n + ", consumes: " + value);
        }
    }
}
