/**
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * Output:
 * ------
 * 1
 * 98
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(new SingleNumberII().singleNumber(nums));
        int[] nums2 = {0,1,0,1,0,1,99};
        System.out.println(new SingleNumberII().singleNumber(nums2));
    }

}

