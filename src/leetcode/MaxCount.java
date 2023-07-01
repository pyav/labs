/**
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
 *
 * Output:
 * ------
 * 3
 * 3
 * 4
 */

public class MaxCount {

    public int maximumCount(int[] nums) {
        int neg = 0, pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg++;
            } else if (nums[i] > 0) {
                pos++;
            }
        }
        return (pos > neg)? pos: neg;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,2,3};
        System.out.println(new MaxCount().maximumCount(nums));
        int[] nums2 = {-3,-2,-1,0,0,1,2};
        System.out.println(new MaxCount().maximumCount(nums2));
        int[] nums3 = {5,20,66,1314};
        System.out.println(new MaxCount().maximumCount(nums3));
    }

}

