/**
 * https://leetcode.com/contest/biweekly-contest-83/problems/number-of-zero-filled-subarrays/
 * 
 * Output:
 * ------
 * 6
 * 9
 * 0
 */

package leetcode.biweekly83;

public class ZeroFilledSubArrays {

	public long zeroFilledSubarray(int[] nums) {
		long count = 0;
		long len = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				len++;
			} else {
				count += (len * (len + 1) / 2);
				if (len > 0) {
					len = 0;
				}
			}
		}
		if (len > 0) {
			count += (len * (len + 1)) / 2;
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 0, 0, 2, 0, 0, 4 };
		System.out.println(new ZeroFilledSubArrays().zeroFilledSubarray(nums));
		int[] nums2 = { 0, 0, 0, 2, 0, 0 };
		System.out.println(new ZeroFilledSubArrays().zeroFilledSubarray(nums2));
		int[] nums3 = { 2, 10, 2019 };
		System.out.println(new ZeroFilledSubArrays().zeroFilledSubarray(nums3));
	}

}
