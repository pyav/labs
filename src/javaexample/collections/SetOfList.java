/**
 * Following code demonstrates the use of set of lists.
 *
 * Output:
 * ------
 * 1
 * 2
 * 3
 */

import java.util.*;

public class SetOfList {

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        set.add(list1);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        set.add(list2);
        for (List<Integer> list : set) {
            for (Integer item: list) {
                System.out.println(item);
            }
        }
    }

}

