package task3;

public class MyLockImpl {
    private boolean isLocked = false;
    private Thread lockedBy = null;
    private int lockCount = 0;

    public synchronized void lock() throws InterruptedException{
        while(isLocked && Thread.currentThread() != lockedBy){
            this.wait();
        }
        isLocked = true;
        lockedBy = Thread.currentThread();
        lockCount++;
    }

    public synchronized void unlock(){
        if(Thread.currentThread() == lockedBy){
            lockCount--;
        }
        if(lockCount == 0){
            isLocked = false;
            this.notify();
        }
    }

}
