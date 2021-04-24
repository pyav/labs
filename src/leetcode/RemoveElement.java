/**
 * https://leetcode.com/problems/remove-element/
 */
package leetcode;

class Solution {

	public int removeElement(int[] nums, int val) {

		int reqLen = 0;
		int effectiveLen = nums.length;

		for (int i = 0; i < effectiveLen; i++) {
			if (nums[i] == val) {
				boolean flag = false;

				for (int j = i, k = i + 1; k < effectiveLen; j++, k++) {
					nums[j] = nums[k];
					flag = true;
				}

				if (flag) {
					effectiveLen -= 1;
					flag = false;
					i--;
				}
			} else {
				reqLen++;
			}
		}

		return reqLen;
	}

}

public class RemoveElement {

	public static void main(String[] args) {

		Solution solution = new Solution();
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int len = solution.removeElement(nums, 2);
		System.out.println();
		System.out.println(len);
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}