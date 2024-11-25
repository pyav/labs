/**
 * https://leetcode.com/problems/jump-game/description/
 *
 * Output:
 * ------
 * true
 * false
 * true
 */

import java.util.Arrays;

class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }
        if (Integer.MAX_VALUE == dp[0]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new JumpGame().canJump(nums));
        int[] nums2 = {3,2,1,0,4};
        System.out.println(new JumpGame().canJump(nums2));
        int[] nums3 = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(new JumpGame().canJump(nums3));
    }
}

