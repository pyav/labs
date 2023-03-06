/**
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * Output:
 * ------
 * 3 5
 * -1 0
 * 0 1
 */

import java.util.Map.Entry;
import java.util.Map;
import java.util.HashMap;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int[] result = new int[2];
        int count = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[count++] = entry.getKey();
                if (count == 2) {
                    break;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] result = new SingleNumberIII().singleNumber(nums);
        System.out.printf("%d %d\n", result[0], result[1]);
        int[] nums2 = {-1,0};
        int[] result2 = new SingleNumberIII().singleNumber(nums2);
        System.out.printf("%d %d\n", result2[0], result2[1]);
        int[] nums3 = {0,1};
        int[] result3 = new SingleNumberIII().singleNumber(nums3);
        System.out.printf("%d %d\n", result3[0], result3[1]);
    }

}

