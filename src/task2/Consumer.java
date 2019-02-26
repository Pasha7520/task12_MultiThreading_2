package task2;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

        private BlockingQueue<Message> queue;

        public Consumer(BlockingQueue<Message> q){
            this.queue=q;
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            try{
                Message msg;

                while(true){
                    System.out.println("Consumed get :"+queue.take().getMsg());
                }
            }catch(InterruptedException e) {
               e.printStackTrace();
           }
        }

}
