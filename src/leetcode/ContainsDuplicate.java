/**
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * Output:
 * ------
 * true
 * false
 */

import java.util.*;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
        int[] nums2 = {1,2,3,4};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums2));
    }

}

