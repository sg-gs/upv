// CSD feb 2015 Juansa Sendra
public class Pool3 extends Pool {   //max capacity

    private int instructors = 0;
    private int kids = 0;
    private int kiCounter = 0; 
    private int ki = 0;
    private int capCounter = 0;
    private int cap = 0;

    public void init(int ki, int cap) {
        this.ki = ki;
        this.cap = cap;
    }

    public synchronized void kidSwims() throws InterruptedException {
        while (instructors == 0 || limitKiReached() || limitCapacityReached()) {
            log.waitingToSwim();
            wait();
        }

        log.swimming();

        kids++; capCounter++;
        recalculateKiCounter();

        notifyAll();
    }

    public synchronized void kidRests() throws InterruptedException {
        log.resting(); 

        kids--; capCounter--;
        recalculateKiCounter();

        notifyAll();
    }

    public synchronized void instructorSwims() throws InterruptedException {
        while(limitCapacityReached()) {
            log.waitingToSwim();
            wait();
        }

        log.swimming();

        instructors++; capCounter++;
        recalculateKiCounter();

        notifyAll();
    }

    public synchronized void instructorRests() throws InterruptedException {
        while((kids > 0 && instructors == 1) || limitKiReached()) {
            log.waitingToRest();
            wait();
        }

        log.resting(); 

        instructors--; capCounter--;
        recalculateKiCounter();
        
        notifyAll();
    }

    private boolean limitCapacityReached () {
        return capCounter >= cap;
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

