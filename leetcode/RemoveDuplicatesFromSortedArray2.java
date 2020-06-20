/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
package leetcode;

class Solution {
	public int removeDuplicates(int[] nums) {

		int reqLen = 0;
		int dupCount = 0;
		int effectiveLen = nums.length;

		for (int i = 0; i < effectiveLen - 1; i++) {

			if (nums[i] != nums[i + 1]) {
				reqLen += 1;
				dupCount = 0;
			} else {
				dupCount += 1;
				if (dupCount > 1) {
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
				} else {
					reqLen += 1;
				}
			}
		}

		return reqLen + 1;
	}
}

public class RemoveDuplicatesFromSortedArray2 {

	public static void main(String[] args) {

		Solution solution = new Solution();
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int len = solution.removeDuplicates(nums);
		System.out.println();
		System.out.println(len);
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
