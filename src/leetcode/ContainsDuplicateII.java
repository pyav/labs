/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * Output:
 * ------
 * true
 * true
 * false
 */

import java.util.*;

public class ContainsDuplicateII {
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int oldIdx = map.get(nums[i]);
                if (i-oldIdx <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums, 3));
        int[] nums2 = {1,0,1,1};
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums2, 1));
        int[] nums3 = {1,2,3,1,2,3};
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums3, 2));
    }

}

