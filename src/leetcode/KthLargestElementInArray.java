/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Output:
 * ------
 * 2
 * 4
 */

package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			pq.add(nums[i]);
		}
		for (int i = 1; i < k; i++) {
			pq.remove();
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		System.out.println(new KthLargestElementInArray().findKthLargest(nums, 5));
		int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println(new KthLargestElementInArray().findKthLargest(nums2, 4));
	}

}
