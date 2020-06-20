/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
package leetcode;

class Solution {
	public int removeDuplicates(int[] nums) {

		int reqLen = 0;
		int effectiveLen = nums.length;

		for (int i = 0; i < effectiveLen - 1; i++) {

			if (nums[i] != nums[i + 1]) {
				reqLen += 1;
			} else {
				boolean flag = false;

				for (int k = i + 1; k < effectiveLen - 1; k++) {
					nums[k] = nums[k + 1];
					flag = true;
				}

				if (flag) {
					effectiveLen -= 1;
					flag = false;
					i--;
				}
			}
		}

		return reqLen + 1;
	}
}

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {

		Solution solution = new Solution();
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int len = solution.removeDuplicates(nums);
		System.out.println();
		System.out.println(len);
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
