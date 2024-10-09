/**
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * Output:
 * ------
 *
 */

package leetcode;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    static boolean isSubsetSum(int[] nums, int n, int sum, int[][] store) {
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }
        if (store[n][sum] != -1) {
            return store[n][sum] == 1;
        }
        if (nums[n - 1] > sum) {
            return isSubsetSum(nums, n - 1, sum, store);
        }

        store[n][sum] = (isSubsetSum(nums, n - 1, sum, store) ||
                isSubsetSum(nums, n - 1, sum - nums[n - 1], store)) ? 1 : 0;

        return store[n][sum] == 1;
    }


    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if (sum%2 != 0) {
            return false;
        }

        int[][] store = new int[n + 1][sum/2 + 1];
        for (int[] row : store) {
            Arrays.fill(row, -1);
        }

        return isSubsetSum(nums, n, sum/2, store);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 9, 12 };
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }
}

