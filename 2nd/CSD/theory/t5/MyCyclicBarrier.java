package t5;

public class MyCyclicBarrier {
    private int threadsToWait = 0;
    private Runnable cb;

    public MyCyclicBarrier(int threadsToWait) {
        this.threadsToWait = threadsToWait;
        this.cb = null;
    }

    public MyCyclicBarrier(int threadsToWait, Runnable callback) {
        this.threadsToWait = threadsToWait;
        this.cb = callback;
    }

    public synchronized void await() throws InterruptedException {
        threadsToWait--;

        while (threadsToWait > 0)
            wait();

        notify();

        // prevent cb to be runned more than one time
        if (cb == null) {
            return;
        }

        new Thread(cb).start();
        cb = null;
    }
}
