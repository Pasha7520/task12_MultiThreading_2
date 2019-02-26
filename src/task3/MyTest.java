package task3;

public class MyTest {
        private final static MyLockImpl lock = new MyLockImpl();
        private static long A = 0; // Shared Resource
        class MyThread extends Thread {
            @Override
            public void run() {
                for (int i = 1; i <= 10000000; i++) {
                    try {
                        lock.lock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try { A++; } finally { lock.unlock(); }
                }
                System.out.println("finish " + Thread.currentThread().getName());
            } }
        public void show() {
            MyThread t1 = new MyThread(); MyThread t2 = new MyThread();
            MyThread t3 = new MyThread();
            t1.start(); t2.start(); t3.start();
            try { t1.join(); t2.join(); t3.join(); } catch (InterruptedException e) { }
            System.out.println("A=" + A);
        }

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        myTest.show();
    }

}
