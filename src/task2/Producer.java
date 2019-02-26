package task2;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while(true){
            try {
                Message massage = new Message(scanner.nextLine());
                queue.put(massage);
                System.out.println("Produced sent :"+massage.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
