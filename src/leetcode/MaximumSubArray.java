/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Output:
 * ------
 * 6
 * 23
 * 1
 * 1
 * 10
 * 5
 * 3
 * 1
 */

package leetcode;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            nums[i] = nums[i] + nums[i-1];
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        for (int i = 1; i <= nums.length-2; i++) {
            for (int j = i+1; j <= nums.length-1; j++) {
                if (max < (nums[j] - nums[i-1])) {
                    max = nums[j] - nums[i-1];
                }
            }
        }

		return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubArray().maxSubArray(nums));

        nums = new int[] {5,4,-1,7,8};
        System.out.println(new MaximumSubArray().maxSubArray(nums));

        nums = new int[] {-2,-2,-3,0,-3,1,-3};
        System.out.println(new MaximumSubArray().maxSubArray(nums));

        nums = new int[] {1};
        System.out.println(new MaximumSubArray().maxSubArray(nums));

        nums = new int[] {1, 2, 3, 4};
        System.out.println(new MaximumSubArray().maxSubArray(nums));

        nums = new int[] {-3,4,-1,2};
        System.out.println(new MaximumSubArray().maxSubArray(nums));

        nums = new int[] {-1, -2, 3, -4};
        System.out.println(new MaximumSubArray().maxSubArray(nums));

        nums = new int[] {1};
        System.out.println(new MaximumSubArray().maxSubArray(nums));
    }
}

