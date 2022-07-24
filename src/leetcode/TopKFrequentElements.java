/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Output:
 * ------
 * 55 11 33 22 
 */

package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				return Integer.compare(map.get(second), map.get(first));
			}
		});
		for (int i : map.keySet()) {
			pq.add(i);
		}
		int[] result = new int[k];
		int i = 0;
		while (i < k) {
			result[i] = pq.poll();
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 33, 33, 33, 11, 11, 11, 22, 22, 44, 44, 55, 55, 55, 55, 55, 55, };
		int[] result = new TopKFrequentElements().topKFrequent(nums, 4);
		for (int i = 0; i < result.length; i++) {
			System.out.printf("%d ", result[i]);
		}
		System.out.println();
	}

}
