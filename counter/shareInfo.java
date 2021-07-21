package counter;

public class shareInfo {
    public static void main(String[] args) {
        counter cont = new counter(100);
        threadA a = new threadA("TheadA",cont);
        threadB b = new threadB("ThreadB",cont);
        a.start();
        b.start();
    }
}
