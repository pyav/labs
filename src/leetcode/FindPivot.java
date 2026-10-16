/**
 * https://leetcode.com/problems/find-pivot-index/description/
 *
 * Output:
 * ------
 * 3
 * -1
 * 0
 */

public class FindPivot {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, pivot = -1;
        int[] rightSum = new int[nums.length];
        rightSum[nums.length-1] = nums[nums.length - 1];
        for (int i = nums.length-2; i >= 0; i--) {
            rightSum[i] = rightSum[i+1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1) {
                if (leftSum == 0) {
                    pivot = nums.length-1;
                }
                break;
            }
            if (leftSum == rightSum[i+1]) {
                pivot = i;
                break;
            }
            leftSum += nums[i];
        }

        return pivot;
    }

    public static void main(String[] args) {
        System.out.println(new FindPivot().pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(new FindPivot().pivotIndex(new int[]{1,2,3}));
        System.out.println(new FindPivot().pivotIndex(new int[]{2,1,-1}));
    }
}

