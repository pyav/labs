/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Output:
 * ------
 * 4
 * 4
 * 1
 */

package leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < 1+lis[j]) {
                    lis[i] = 1+lis[j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
        int[] nums2 = {0,1,0,3,2,3};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums2));
        int[] nums3 = {7,7,7};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums3));
    }

}

