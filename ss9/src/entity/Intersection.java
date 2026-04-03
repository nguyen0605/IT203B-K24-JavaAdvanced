package entity;

import exception.CollisionException;

import java.util.concurrent.locks.ReentrantLock;

public class Intersection {

    private final ReentrantLock lock = new ReentrantLock();

    public void enter(Vehicle v) throws CollisionException {
        lock.lock();
        try {
            System.out.println(v + " is passing intersection");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new CollisionException("Interrupted!");
        } finally {
            lock.unlock();
        }
    }
}