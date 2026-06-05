/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Output:
 * ------
 * 6
 * 0
 * 0
 * 60
 */

public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
        int result = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int minCandidate = min * curr;
            int maxCandidate = max * curr;
            
            int newMax = Math.max(curr, Math.max(minCandidate, maxCandidate));
            int newMin = Math.min(curr, Math.min(minCandidate, maxCandidate));

            max = newMax;
            min = newMin;

            result = Math.max(result, newMax);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{0, 0, 0}));
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{1,0,-1,2,3,-5,-2}));
    }
}

