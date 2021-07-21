package producer_consumer;

public class Queue {
    private int num;
    private boolean available = false;

    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        available = false;
        notifyAll();
        return num;
    }

    public synchronized void put (int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        num = value;
        available = true;
        notifyAll();
    }
}
