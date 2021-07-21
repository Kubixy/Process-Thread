package counter;

public class counter {

    private int c = 0;

    counter (int c) {
        this.c = c;
    }

    public void increase() {
        c++;
    }

    public void decrease() {
        c--;
    }

    public int getValue(){
        return c;
    }
}
