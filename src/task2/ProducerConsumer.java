package task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(1);
        Producer cus1Send = new Producer(queue);
        Consumer cus1Get = new Consumer(queue);
        new Thread(cus1Send).start();
        new Thread(cus1Get).start();
        System.out.println("Communicate has been started");
    }
}
