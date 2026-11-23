/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 *
 * Output:
 * ------
 * 2
 * 0
 * 16
 * 0
 * 1
 */

public class CountSubArray {
    /*public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] %2 == 1) {
                    count++;
                }
                if (count > k) {
                    break;
                }
                if (count == k) {
                    result++;
                }
            }
        }
        return result;
    }*/

    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0, end = 0, result = 0, count = 0, prefix = 0;
        while(end < nums.length) {
            if (nums[end] % 2 == 1) {
                count++;
                prefix = 0;
            }
            while (count == k) {
                prefix++;
                if (nums[start] % 2 == 1) {
                    count--;
                }
                start++;
            }
            result += prefix;
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubArray().numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
        System.out.println(new CountSubArray().numberOfSubarrays(new int[]{2,4,6}, 1));
        System.out.println(new CountSubArray().numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
        System.out.println(new CountSubArray().numberOfSubarrays(new int[]{2}, 1));
        System.out.println(new CountSubArray().numberOfSubarrays(new int[]{1}, 1));
    }
}

