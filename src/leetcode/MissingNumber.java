/**
 * https://leetcode.com/problems/missing-number/description/
 *
 * Output:
 * ------
 * 2
 * 2
 * 8
 */

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return ((n*(n+1)/2) - sum);
    }

    public static void main(String[] args) {
        int[] nums = {3,1,0};
        System.out.println(new MissingNumber().missingNumber(nums));
        int[] nums2 = {0,1};
        System.out.println(new MissingNumber().missingNumber(nums2));
        int[] nums3 = {9,6,4,2,3,5,7,0,1};
        System.out.println(new MissingNumber().missingNumber(nums3));
    }

}

