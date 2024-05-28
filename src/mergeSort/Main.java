package mergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(new Random().nextInt());
        }
        list = MergeSort.sortList(list);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
