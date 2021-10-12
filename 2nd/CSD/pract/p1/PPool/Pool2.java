public class Pool2 extends Pool {   //max kids/instructor

    private int instructors = 0, kids = 0, kiCounter = 0, ki = 0;

    public void init(int ki, int cap) {
        this.ki = ki;
    }

    public synchronized void kidSwims() throws InterruptedException {
        while (instructors == 0 || limitKiReached()) {
            log.waitingToSwim();
            wait();
        }

        log.swimming();
        kids++;
        recalculateKiCounter();
        notifyAll();
    }

    public synchronized void kidRests() throws InterruptedException {
        log.resting(); 
        kids--;
        recalculateKiCounter();
        notifyAll();
    }

    public synchronized void instructorSwims() throws InterruptedException {
        log.swimming();
        instructors++;
        recalculateKiCounter();
        notifyAll();
    }

    public synchronized void instructorRests() throws InterruptedException {
        while((kids > 0 && instructors == 1) || limitKiReached()) {
            log.waitingToRest();
            wait();
        }

        log.resting(); 
        instructors--;
        recalculateKiCounter();
        notifyAll();
    }

    private boolean limitKiReached () {
        return kiCounter >= ki;
    }

    private void recalculateKiCounter () {
        if (instructors == 0) { // guard from / 0 division
            kiCounter = 0;
            return;
        }
        
        // force conversion to double
        double kiCounterDouble = ((double) kids / (double)instructors);

        // round the division to the upper, as we need at least the minimum to accomplish ki ratio
        kiCounter = (int) Math.ceil(kiCounterDouble);
    }
}
