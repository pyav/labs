/**
 * https://leetcode.com/problems/delete-and-earn/description/
 *
 * Output:
 * ------
 * 9
 * 4
 */

import java.util.*;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int sum = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (1 == entry.getValue()) {
                sum += entry.getKey();
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{3,4,2}));
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}


/*
 * 2,2,3,3,3,4
 *
 * 2 : 2
 * 3 : 3
 * 4 : 1
 *
 *
 */
