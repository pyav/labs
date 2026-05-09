/**
 * https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/
 *
 * Output:
 * ------
 * Result:
 * 24 15 13 15 21 
 * Result2:
 * 45 37 31 27 25 25 27 31 37 45 
 * Result3:
 * 2 2 
 */

import java.util.Arrays;

public class SumAbsoluteDiffs {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n-1] = 0;

        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] + Math.abs(nums[0] - nums[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] + Math.abs(nums[n-1] - nums[i]);
        }

        int[] result = new int[n];

        result[0] = left[n-1];
        result[n-1] = right[0];

        int initVal = (n-1) * Math.abs(nums[0] - nums[n-1]);
        for (int i = 1; i <= n-2; i++) {
            result[i] = initVal - (i * Math.abs(nums[i] - nums[n-1]))
                        - left[i] - ((n-i-2)* Math.abs(nums[0] - nums[i])) - right[i+1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,6,8,10};
        int[] result = new SumAbsoluteDiffs().getSumAbsoluteDifferences(nums);
        System.out.println("Result:");
        Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] nums2 = {1,2,3,4,5,6,7,8,9,10};
        int[] result2 = new SumAbsoluteDiffs().getSumAbsoluteDifferences(nums2);
        System.out.println("Result2:");
        Arrays.stream(result2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] nums3 = {1,3};
        int[] result3 = new SumAbsoluteDiffs().getSumAbsoluteDifferences(nums3);
        System.out.println("Result3:");
        Arrays.stream(result3).forEach(x -> System.out.printf("%d ", x));
        System.out.println();

    }
}

