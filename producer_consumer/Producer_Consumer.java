package producer_consumer;

public class Producer_Consumer {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Producer producer = new Producer(queue, 1);
        Consumer consumer = new Consumer(queue,1);
        producer.start();
        consumer.start();
    }
}
