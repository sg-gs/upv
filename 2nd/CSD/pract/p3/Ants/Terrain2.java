import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Native monitor based Terrain
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public class Terrain2 implements Terrain {
    Viewer v;
    ReentrantLock rl;
    Condition[][] notAvailable;

    public Terrain2(int t, int ants, int movs) {
        v = new Viewer(t, ants, movs, "2.- reentrantLock monitor with lock per cell");
        rl = new ReentrantLock();

        notAvailable = new Condition[t][t];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                // lock for each cell
                notAvailable[i][j] = rl.newCondition();
            }
        }

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
            Pos currentPos = v.getPos(a); // save current position to free it after using the next position

            while (v.occupied(dest)) {
                notAvailable[dest.x][dest.y].await();
                v.retry(a);
            }
            v.go(a);

            notAvailable[currentPos.x][currentPos.y].signal(); // just one ant can use it, signal just the next that is
                                                               // waiting
        } catch (Exception ie) {
            ie.printStackTrace();
        } finally {
            rl.unlock();
        }

    }
}