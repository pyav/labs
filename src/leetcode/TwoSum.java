/**
 * Link: https://leetcode.com/problems/two-sum/
 * 
 * Output:
 * ------
 * 0 1
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[] {i, map.get(comp)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] result = new TwoSum().twoSum(nums, 6);
        System.out.printf("%d %d", result[0], result[1]);
    }
}
