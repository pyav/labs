/**
 * https://leetcode.com/problems/find-missing-elements/description/
 * 
 * Output:
 * ------
 * 3 
 *
 * 2 3 4 5 6 7 8 9
 */

import java.util.*;

public class MissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        boolean[] present = new boolean[100];
        int min = nums[0];
        int max = nums[1];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            present[nums[i]-1] = true;
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = min-1; i < max-1; i++) {
            if (!present[i]) {
                result.add(i+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,5};
        List<Integer> result = new MissingElements().findMissingElements(nums);
        result.stream().forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] nums2 = {7,8,6,9};
        List<Integer> result2 = new MissingElements().findMissingElements(nums2);
        result2.stream().forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] nums3 = {1,10};
        List<Integer> result3 = new MissingElements().findMissingElements(nums3);
        result3.stream().forEach(x -> System.out.printf("%d ", x));
    }
}

