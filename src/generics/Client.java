package generics;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Pair pair = new Pair(4,9);
        pair.first = 100;
        pair.second = "Dhanraj";
        List<Pair> list = new ArrayList<>();
        list.add(pair);
        list.add(new Pair(4.5, 7.8));
        list.add(new Pair(9.8, 2.3));

        Pair guest = list.get(2);
        System.out.println(guest.first);
        Integer v = 127;
        Integer x = 127;

        System.out.println(v==x);
        // this will not work beacuse first and second are objects not integers
        //System.out.println(guest.first + guest.second);

    }
}
