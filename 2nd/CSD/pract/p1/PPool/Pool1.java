// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool {   //no kids alone

    private int instructors = 0, kids = 0;

    public void init(int ki, int cap) {}

    public synchronized void kidSwims() throws InterruptedException {
        while (instructors == 0) {
            log.waitingToSwim();
            wait();
        }

        log.swimming();
        kids++;
        notifyAll();
    }

    public synchronized void kidRests() throws InterruptedException {
        log.resting(); 
        kids--;
        notifyAll();
    }

    public synchronized void instructorSwims() throws InterruptedException {
        log.swimming();
        instructors++;
        notifyAll();
    }

    public synchronized void instructorRests() throws InterruptedException {
        while(kids > 0 && instructors == 1) {
            log.waitingToRest();
            wait();
        }

        log.resting(); 
        instructors--;
        notifyAll();
    }
}
