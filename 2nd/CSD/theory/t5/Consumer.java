package t5;


import java.util.concurrent.CountDownLatch;

// import java.util.concurrent.BrokenBarrierException;
// import java.util.concurrent.CyclicBarrier;

// 2. CountDownLatch
public class Consumer extends Thread {
    private Buffer b;
    private int number;
    private CountDownLatch barrier;

    public Consumer(Buffer ca, int id, CountDownLatch c) {
        b = ca;
        number = id;
        barrier = c;
    }

    public void run() {
        int value = 0;
        for (int i = 1; i < 10; i++) {
            value = b.get();
            System.out.println("Consumer #" + number + " gets: " + value);
        }

        barrier.countDown();
    }
}

// 2. CyclicBarrier
// public class Consumer extends Thread {
//     private Buffer b;
//     private int number;
//     private CyclicBarrier barrier;

//     public Consumer(Buffer ca, int id, CyclicBarrier c) {
//         b = ca;
//         number = id;
//         barrier = c;
//     }

//     public void run() {
//         int value = 0;
//         for (int i = 1; i < 10; i++) {
//             value = b.get();
//             System.out.println("Consumer #" + number + " gets: " + value);
//         }

//         try {
//             barrier.await();
//         } catch (BrokenBarrierException be) {
//             be.printStackTrace();
//         } catch (InterruptedException ie) {
//             ie.printStackTrace();
//         }
//     }
// }