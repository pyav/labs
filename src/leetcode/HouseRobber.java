/**
 * https://leetcode.com/problems/house-robber/description/
 *
 * Output:
 * ------
 * 4
 * 12
 */

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] select = new int[n];
        int[] nonSelect = new int[n];
        select[0] = nums[0];

        for (int i = 1; i < n; i++) {
            select[i] = nums[i] + nonSelect[i-1];
            nonSelect[i] = Math.max(select[i-1], nonSelect[i-1]);
        }
        return Math.max(select[n-1], nonSelect[n-1]);
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1,2,3,1}));
        System.out.println(new HouseRobber().rob(new int[]{2,7,9,3,1}));
    }
}

