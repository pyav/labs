/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Output:
 * ------
 * 2 
 * 4 9 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] count1 = new boolean[1001];
        boolean[] count2 = new boolean[1001];

        for(int i = 0; i < nums1.length; i++) {
            count1[nums1[i]] = true;
        }
        for(int i = 0; i < nums2.length; i++) {
            count2[nums2[i]] = true;
        }

        List<Integer> result = new ArrayList<> ();

        for (int i = 0; i < 1001; i++) {
            if (count1[i] && count2[i]) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = new TwoArrayIntersection().intersection(nums1, nums2);
        Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
        System.out.println();

        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        int[] result2 = new TwoArrayIntersection().intersection(nums3, nums4);
        Arrays.stream(result2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();

    }
}

