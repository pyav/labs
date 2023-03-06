/**
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * Output:
 * ------
 * 3
 * 99
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int result = -1;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
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

