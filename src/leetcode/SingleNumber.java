/**
 * https://leetcode.com/problems/single-number/
 *
 * Output:
 * ------
 * 4
 * 1
 * 1
 */

import java.util.Set;
import java.util.HashSet;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Object[] result = set.toArray();
        return (int) result[0];
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(new SingleNumber().singleNumber(nums));
        int[] nums2 = {2,2,1};
        System.out.println(new SingleNumber().singleNumber(nums2));
        int[] nums3 = {1};
        System.out.println(new SingleNumber().singleNumber(nums3));
    }

}

