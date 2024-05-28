package locksWithCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Value v = new Value(0);
        Lock l = new ReentrantLock();

        Adder x = new Adder(v, l);
        Subtractor y = new Subtractor(v, l);
        ExecutorService ec = Executors.newCachedThreadPool();

        List<Callable<Void>> tasks = new ArrayList<>();
        tasks.add(x);
        tasks.add(y);
        List<Future<Void>> f = ec.invokeAll(tasks);

        System.out.println(v.val);
        ec.shutdownNow();
    }
}
