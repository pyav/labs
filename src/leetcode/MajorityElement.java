/**
 * https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 * 
 * Output:
 * ------
 * 3
 * 2
 */

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        int maxElement = Integer.MIN_VALUE;
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
            if (maxCount < record.get(nums[i])) {
                maxCount = record.get(nums[i]);
                maxElement = nums[i];
            }
        }
        return maxElement;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(new MajorityElement().majorityElement(nums));
        System.out.println(new MajorityElement().majorityElement(new int[] {2,2,1,1,1,2,2,}));
    }
}
