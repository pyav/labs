/**
 * https://leetcode.com/problems/divide-array-into-equal-pairs/description/
 *
 * Output:
 * ------
 * true
 */

import java.util.*;

public class DivideArrayIntoEqualPairs {

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		for (Integer val : map.values()) {
			if (val%2 != 0) {
				return false;
			}
		}
		return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,2,2,2};
        System.out.println(new DivideArrayIntoEqualPairs().divideArray(nums));
    }

}

