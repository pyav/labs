/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Output:
 * ------
 * 2
 * 2
 * 4
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySum().subarraySum(new int[]{1,2,3}, 3));
        System.out.println(new SubarraySum().subarraySum(new int[]{1,1,1}, 2));
        System.out.println(new SubarraySum().subarraySum(new int[]{1,-1,1,-1}, 0));
    }
}

