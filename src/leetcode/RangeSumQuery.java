/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 * Output:
 * ------
 * 1
 * -1
 * -3
 * 1
 */

public class RangeSumQuery {
    private int[] nums;
    private int[] sum;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
    }
 
    public int sumRange(int left, int right) {
        return (left == 0)? this.sum[right]: this.sum[right]-this.sum[left-1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery numArray = new RangeSumQuery(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
        int[] nums2 = {1};
        RangeSumQuery numArray2 = new RangeSumQuery(nums2);
        System.out.println(numArray2.sumRange(0, 0));
    }
}

