package mergeSortWithFixedThread;


import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        UUID ui = UUID.randomUUID();

        for (int i = 0; i < 3000; i++) {
            list.add(new Random().nextInt() % 3000);
        }
        ExecutorService es = Executors.newFixedThreadPool(500);
        ThreadedMergeSort mergeSort = new ThreadedMergeSort(list, es);
        Future<List<Integer>> sortedFuture = es.submit(mergeSort);
        list = sortedFuture.get();
        System.out.println(list);
        es.shutdown();
    }
}
