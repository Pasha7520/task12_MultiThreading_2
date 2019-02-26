package task1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CountThread implements Runnable{
    private static Lock lock = new ReentrantLock();
    ReadWriteLock sd = new ReentrantReadWriteLock();
    CommonResource res;
    CountThread(CommonResource res){
        this.res=res;
    }
    public void run(){
        lock.lock();
            res.x=1;

            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        lock.unlock();
    }
}
