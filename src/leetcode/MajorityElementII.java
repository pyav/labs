/**
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * Otuput:
 * ------
 * 3
 * 1
 * 2
 * 1
 * 2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], record.getOrDefault(nums[i], 0) + 1);
        }
        for (Entry<Integer, Integer> entry : record.entrySet()) {
            if (entry.getValue() > Math.floor(nums.length/3)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> nums1 = new MajorityElementII().majorityElement(new int[] {3,2,3});
        for (Integer i : nums1) {
            System.out.println(i);
        }
        List<Integer> nums2 = new MajorityElementII().majorityElement(new int[] {2,2,1,1,1,2,2});
        for (Integer i : nums2) {
            System.out.println(i);
        }
        List<Integer> nums3 = new MajorityElementII().majorityElement(new int[] {2,1});
        for (Integer i : nums3) {
            System.out.println(i);
        }
    }
}

