package counter;

public class threadB extends Thread{
    private counter counter;

    public threadB (String n, counter counter) {
        setName(n);
        this.counter = counter;
    }

    public void run() {
        synchronized (counter) {
            for (int j = 0; j < 300; j++) {
                counter.decrease();
            }
            System.out.println(getName() + " value: " + counter.getValue());
        }
    }
}
