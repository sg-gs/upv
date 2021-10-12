import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Native monitor based Terrain
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public class Terrain1 implements Terrain {
    Viewer v;
    ReentrantLock rl;
    Condition notAvailable;

    public Terrain1(int t, int ants, int movs) {
        v = new Viewer(t, ants, movs, "1.- reentrantLock monitor");
        rl = new ReentrantLock();
        notAvailable = rl.newCondition();

        for (int i = 0; i < ants; i++)
            new Ant(i, this, movs).start();
    }

    public void hi(int a) {
        try {
            rl.lock();

            v.hi(a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rl.unlock();
        }
    }

    public void bye(int a) {
        try {
            rl.lock();

            v.bye(a);
        } catch (Exception ie) {
            ie.printStackTrace();
        } finally {
            rl.unlock();
        }
    }

    public void move(int a) throws InterruptedException {
        try {
            rl.lock();

            v.turn(a);
            Pos dest = v.dest(a);

            while (v.occupied(dest)) {
                notAvailable.await();
                v.retry(a);
            }
            v.go(a);

            notAvailable.signalAll();
        } catch (Exception ie) {
            ie.printStackTrace();
        } finally {
            rl.unlock();
        }

    }
}