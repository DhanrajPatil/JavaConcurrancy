package mergeSortWithCachedThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ThreadedMergeSort implements Callable<List<Integer>> {
    List<Integer> sortingList;
    ExecutorService es;

    public ThreadedMergeSort(List<Integer> sortingList, ExecutorService es) {
        this.sortingList = sortingList;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(sortingList.size() == 1) {
            return sortingList;
        }
        int mid = sortingList.size() / 2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            left.add(sortingList.get(i));
        }
        for (int i = mid; i < sortingList.size(); i++) {
            right.add(sortingList.get(i));
        }

        ThreadedMergeSort mergeSortLeft = new ThreadedMergeSort(left, es);
        ThreadedMergeSort mergeSortRight = new ThreadedMergeSort(right, es);

        Future<List<Integer>> futureLeft = es.submit(mergeSortLeft);
        Future<List<Integer>> futureRight = es.submit(mergeSortRight);

        List<Integer> list1 = futureLeft.get();
        List<Integer> list2 = futureRight.get();

        List<Integer> temp = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                temp.add(list1.get(i));
                i++;
            } else {
                temp.add(list2.get(j));
                j++;
            }
        }
        if(i < list1.size()) {
            for(int k = i; k < list1.size(); k++) {
                temp.add(list1.get(k));
            }
        }
        if(j < list2.size()) {
            for(int k = j; k < list2.size(); k++) {
                temp.add(list2.get(k));
            }
        }
        return temp;
    }
}
