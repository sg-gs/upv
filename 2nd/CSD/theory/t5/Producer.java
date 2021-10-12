package t5;

import java.util.concurrent.CountDownLatch;

// import java.util.concurrent.BrokenBarrierException;
// import java.util.concurrent.CyclicBarrier;

// 2.bis
public class Producer extends Thread {
    private Buffer b;
    private int number;
    private MyCyclicBarrier barrier;

    public Producer(Buffer ca, int id, MyCyclicBarrier c) {
        b = ca;
        number = id;
        barrier = c;
    }

    public void run() {
        for (int i = 1; i < 10; i++) {
            b.put(i);
            System.out.println("Producer #" + number + " puts: " + i);
        }
        
        try {
            barrier.await();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}


// 2. CountDownLatch
// public class Producer extends Thread {
//     private Buffer b;
//     private int number;
//     private CountDownLatch barrier;

//     public Producer(Buffer ca, int id, CountDownLatch c) {
//         b = ca;
//         number = id;
//         barrier = c;
//     }

//     public void run() {
//         for (int i = 1; i < 10; i++) {
//             b.put(i);
//             System.out.println("Producer #" + number + " puts: " + i);
//         }
        
//         barrier.countDown();
//     }
// }

// 2. CyclicBarrier
// public class Producer extends Thread {
//     private Buffer b;
//     private int number;
//     private CyclicBarrier barrier;

//     public Producer(Buffer ca, int id, CyclicBarrier c) {
//         b = ca;
//         number = id;
//         barrier = c;
//     }

//     public void run() {
//         for (int i = 1; i < 10; i++) {
//             b.put(i);
//             System.out.println("Producer #" + number + " puts: " + i);
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