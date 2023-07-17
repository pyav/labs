/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * Output:
 * ------
 * 2
 * 1
 * 0
 * 2
 */

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int i = -1, curr = 0, minLen = Integer.MAX_VALUE, len = 0, sum = 0;

        while(curr < nums.length) {
            i++;
            sum += nums[i];
            len++;
            while (sum >= target) {
                if (len < minLen) {
                    minLen = len;
                }
                sum -= nums[curr++];
                len--;
            }
            if (i == nums.length-1) {
                while(curr < nums.length) {
                    if (sum < target) {
                        break;
                    }
                    if (sum >= target && len < minLen) {
                        minLen = len;
                    }
                    sum -= nums[curr++];
                    len--;
                }
                break;
            }
        }

        return (minLen == Integer.MAX_VALUE)? 0: minLen;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,2,4,3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, nums1));
        int[] nums2 = {1,4,4};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(4, nums2));
        int[] nums3 = {1,1,1,1,1,1,1,1};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(11, nums3));
        int[] nums4 = {5,1,3,5,10,7,4,9,2,8};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(15, nums4));
    }
    
}

