package counter;

public class threadA extends Thread {
    private counter counter;

    public threadA (String n, counter counter) {
        setName(n);
        this.counter = counter;
    }

    public void run() {
        synchronized (counter){
            for (int j = 0; j < 300; j++) {
                counter.increase();
            }
            System.out.println(getName() + " value: " + counter.getValue());}
    }
}
