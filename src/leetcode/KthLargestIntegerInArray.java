/**
 * https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 * 
 * Output:
 * ------
 * 6
 * 0
 */

package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestIntegerInArray {

	public String kthLargestNumber(String[] nums, int k) {
		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<>() {
			public int compare(String s1, String s2) {
				int l1 = s1.length();
				int l2 = s2.length();
				if (l1 < l2) {
					return 1;
				} else if (l1 > l2) {
                    return -1;
                }

				for (int i = 0; i < l1; i++) {
					if (s1.charAt(i) < s2.charAt(i)) {
						return 1;
					} else if (s1.charAt(i) > s2.charAt(i)) {
						return -1;
					}
				}
				return 0;
			}
		});

		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
		}

		while (k-- > 1) {
			pq.poll();
		}
		return pq.poll();
	}

	public static void main(String[] args) {
		String[] nums = { "3", "11", "6", "7", "10" };
		System.out.println(new KthLargestIntegerInArray().kthLargestNumber(nums, 4));
		String[] nums2 = { "0", "0" };
		System.out.println(new KthLargestIntegerInArray().kthLargestNumber(nums2, 2));
	}

}
