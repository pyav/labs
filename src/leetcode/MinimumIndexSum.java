/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 *
 * Output:
 * ------
 * Shogun 
 * Shogun 
 * sad happy 
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class MinimumIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int val = map.get(list2[i]);
                if (val + i < min) {
                    min = val + i;
                    res.clear();
                    res.add(list2[i]);
                } else if (val + i == min) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] result1 = new MinimumIndexSum().findRestaurant(list1, list2);
        Arrays.stream(result1).forEach(word -> System.out.printf("%s ", word));
        System.out.println();
        String[] list3 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list4 = {"KFC","Shogun","Burger King"};
        String[] result2 = new MinimumIndexSum().findRestaurant(list3, list4);
        Arrays.stream(result2).forEach(word -> System.out.printf("%s ", word));
        System.out.println();
        String[] list5 = {"happy","sad","good"};
        String[] list6 = {"sad","happy","good"};
        String[] result3 = new MinimumIndexSum().findRestaurant(list5, list6);
        Arrays.stream(result3).forEach(word -> System.out.printf("%s ", word));
        System.out.println();
    }
}

