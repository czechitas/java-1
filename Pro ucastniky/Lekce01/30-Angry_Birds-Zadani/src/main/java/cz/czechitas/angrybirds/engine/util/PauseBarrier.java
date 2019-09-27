package cz.czechitas.angrybirds.engine.util;

import java.util.concurrent.*;

public class PauseBarrier {

    private boolean paused = false;
    private Object latch = this;

    public synchronized void lock() {
        paused = true;
    }

    public synchronized void unlock() {
        paused = false;
        latch.notifyAll();
    }


    public synchronized boolean isLocked() {
        return paused;
    }

    public synchronized void goThrough() throws CancellationException {
        if (paused) {
            try {
                latch.wait();
            } catch (InterruptedException e) {
                throw new CancellationException();
            }
        }
    }
}
