/**
 * This solution doesn't work for same elements.
 */

package leetcode;

import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int i=0, j=nums.length-1; i<j; ) {
            if (nums[i]+nums[j] == target) {
                indexes[0] = map.get(nums[i]);
                indexes[1] = map.get(nums[j]);
                break;
            } else if (nums[i]+nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] result = new TwoSum().twoSum(nums, 9);
        int[] nums = {3,2,4};
        int[] result = new TwoSum().twoSum(nums, 6);
        //int[] nums = {3,3};
        //int[] result = new TwoSum().twoSum(nums, 6);
    }
}
