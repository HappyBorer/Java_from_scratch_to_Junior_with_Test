import collections_framework.array_list.Car;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> carSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });

        for(int i = 0; i < 100; i++){
            carSet.add(i);
        }

        for (int item : carSet) {
            System.out.println(item);
        }
    }
}
