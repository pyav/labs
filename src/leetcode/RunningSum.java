/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 * 
 * 
 * Output:
 * ------
 * java  leetcode.RunningSum
 * 
 * 1
 * 3
 * 6
 * 10
 *
 */

package leetcode;

class Solution {
	public int[] runningSum(int[] nums) {

		int j = 0;
		int a[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			a[i] = nums[i] + j;
			j = a[i];
		}

		return a;
	}
}

public class RunningSum {

	public static void main(String[] args) {

		Solution solution = new Solution();
		int nums[] = { 1, 2, 3, 4 };
		int runningSumArr[] = solution.runningSum(nums);
		for (int i = 0; i < runningSumArr.length; i++) {
			System.out.println(runningSumArr[i]);
		}
	}

}
