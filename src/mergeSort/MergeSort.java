package mergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort{
    public static List<Integer> sortList(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        List<Integer> left = sortList(list.subList(0, mid));
        List<Integer> right = sortList(list.subList(mid, list.size()));

        return mergeLists(left, right);
    }

    public static  List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(i)) {
                temp.add(list1.get(i));
                i++;
            } else {
                temp.add(list2.get(i));
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
