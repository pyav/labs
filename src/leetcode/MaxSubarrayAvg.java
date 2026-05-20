/**
 * https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Output:
 * ------
 * 12.75
 * 5.0
 */

public class MaxSubarrayAvg {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        double K = (double)k;

        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        double maxAvg = (double)sum[k-1]/K;

        for (int i = 1; i <= n-k; i++) {
            if ((double)(sum[i+k-1] - sum[i-1])/K > maxAvg) {
                maxAvg = (sum[i+k-1] - sum[i-1])/K;
            }
        }

        return maxAvg;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(new MaxSubarrayAvg().findMaxAverage(nums, 4));
        int[] nums2 = {5};
        System.out.println(new MaxSubarrayAvg().findMaxAverage(nums2, 1));
    }
}

