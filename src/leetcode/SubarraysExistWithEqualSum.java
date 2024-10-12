/**
 * https://leetcode.com/problems/find-subarrays-with-equal-sum/description/
 *
 * Otuput:
 * ------
 * true
 * false
 * true
 */

import java.util.HashSet;
import java.util.Set;

public class SubarraysExistWithEqualSum {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> sumSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length - 1; i++) {
            if(!sumSet.contains(nums[i] + nums[i+1])) {
                sumSet.add(nums[i] + nums[i+1]);
            } else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {4,2,4};
        System.out.println(new SubarraysExistWithEqualSum().findSubarrays(nums));
        int[] nums2 = {1,2,3,4,5};
        System.out.println(new SubarraysExistWithEqualSum().findSubarrays(nums2));
        int[] nums3 = {0,0,0};
        System.out.println(new SubarraysExistWithEqualSum().findSubarrays(nums3));
    }
}

