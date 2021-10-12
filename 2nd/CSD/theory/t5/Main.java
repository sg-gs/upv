package t5;

import java.util.concurrent.CountDownLatch;

// import java.util.concurrent.CyclicBarrier;
// import java.util.concurrent.BrokenBarrierException;

public class Main {
    // 2bis. MyCyclicBarrier
    public static void main(String[] args) {
        Buffer c = new Buffer();
        // MyCyclicBarrier b = new MyCyclicBarrier(3, new Runnable() {
        //     public void run() {
        //         System.out.println("Running at the end!");
        //     }
        // });

        MyCyclicBarrier b = new MyCyclicBarrier(3);

        Consumer c1 = new Consumer(c, 1, b);
        Producer p1 = new Producer(c, 2, b);

        c1.start();
        p1.start();

        try {
            b.await();
            System.out.println("Producer and Consumer have terminated.");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    // // 2. CountDownLatch
    // public static void main(String[] args) {
    //     Buffer c = new Buffer();
    //     CountDownLatch b = new CountDownLatch(2);
    //     Consumer c1 = new Consumer(c, 1, b);
    //     Producer p1 = new Producer(c, 2, b);

    //     c1.start();
    //     p1.start();

    //     try {
    //         b.await();
    //         System.out.println("Producer and Consumer have terminated.");
    //     } catch (InterruptedException ie) {
    //         ie.printStackTrace();
    //     }
    // }

    // 2. CyclicBarrier
    // public static void main(String[] args) {
    //     Buffer c = new Buffer();
    //     CyclicBarrier b = new CyclicBarrier(3);
    //     Consumer c1 = new Consumer(c, 1, b);
    //     Producer p1 = new Producer(c, 2, b);

    //     c1.start();
    //     p1.start();

    //     try {
    //         b.await();
    //         System.out.println("Producer and Consumer have terminated.");
    //     } catch (BrokenBarrierException be) {
    //         be.printStackTrace();
    //     } catch (InterruptedException ie) {
    //         ie.printStackTrace();
    //     }
        
    // }

    // 1. Wait threads using joins
    // public static void main(String[] args) {
    //     Buffer c = new Buffer();
    //     Consumer c1 = new Consumer(c, 1);
    //     Producer p1 = new Producer(c, 2);

    //     c1.start();
    //     p1.start();

    //     try {
    //         c1.join(); p1.join();
    //     } catch (InterruptedException ie) {
    //         ie.printStackTrace();
    //     }
    // }
}