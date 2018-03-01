package houseware.learn.j8.concurrency.concurrent.atomic;

public class SafeCounterWithLock {
    private volatile int counter;
    
    int getValue() {
        return counter;
    }
    
    synchronized void increment() {
        counter++;
    }
}
