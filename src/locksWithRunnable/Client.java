package locksWithRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Value v = new Value(0);
        Lock l = new ReentrantLock();

        Adder x = new Adder(v, l);
        Subtractor y = new Subtractor(v, l);
        ExecutorService ec = Executors.newCachedThreadPool();
        ec.execute(x);
        ec.execute(y);
        System.out.println(v.val);
        ec.shutdown();
    }
}
