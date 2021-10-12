package t5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private int store = 0;
    private boolean full = false;
    private ReentrantLock lock;
    private Condition noLleno, noVacio;

    public Buffer() {
        lock = new ReentrantLock();
        noLleno = lock.newCondition();
        noVacio = lock.newCondition();
    }

    private void lock() { lock.lock(); }
    private void unlock() { lock.unlock(); }

    public int get() {
        int value = 0;

        try {
            lock();

            while (!full) { noVacio.await(); }

            value = store;
            store = 0;
            full = false;

            noLleno.signal();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            unlock();
        }

        return value;
    }

    public void put(int value) {
        try {
            lock();

            while (full) { noLleno.await(); }

            store = value;
            full = true;

            noVacio.signal();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            unlock();
        }
    }
}
