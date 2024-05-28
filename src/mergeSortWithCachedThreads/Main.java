package mergeSortWithCachedThreads;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Random().nextInt() % 10000);
        }
        ExecutorService es = Executors.newCachedThreadPool();
        ThreadedMergeSort mergeSort = new ThreadedMergeSort(list, es);
        Future<List<Integer>> sortedFuture = es.submit(mergeSort);
        list = sortedFuture.get();
        System.out.println(list);
        es.shutdown();
    }
}
