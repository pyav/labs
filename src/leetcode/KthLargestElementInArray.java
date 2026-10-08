/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Output:
 * ------
 * 5
 * 4
 */

import java.util.PriorityQueue;

public class KthLargestElementInArray {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
		}
		return pq.poll();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		System.out.println(new KthLargestElementInArray().findKthLargest(nums, 2));
		int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println(new KthLargestElementInArray().findKthLargest(nums2, 4));
	}

}
