/**
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/
 *
 * Output:
 * ------
 * 1
 * 2
 */

import java.util.*;

public class TargetIndicesAfterSorting {

    public List<Integer> targetIndices(int[] nums, int target) {
        Map<Integer, Integer> count = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int sum = 0;
        List<Integer> result = new ArrayList<Integer>();
        if (count.containsKey(target)) {
            for (Integer key : count.keySet()) {
                if (key == target) {
                    break;
                }
                sum += count.get(key);
            }
            for (int i = 1; i <= count.get(target); i++) {
                result.add(sum);
                sum += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,2,3};
        List<Integer> result = new TargetIndicesAfterSorting().targetIndices(nums, 2);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

}

