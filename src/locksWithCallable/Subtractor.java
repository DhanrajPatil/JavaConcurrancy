package locksWithCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    Value v;
    Lock lock;

    public Subtractor(Value v, Lock lock) {
        this.v = v;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 5000 ; i++) {
            lock.lock();
            this.v.val = this.v.val - i;
            lock.unlock();
        }
        return null;
    }
}
