/**
 * https://leetcode.com/problems/4sum-ii/
 * 
 * Output:
 * ------
 * 17
 */

package leetcode;

import java.util.Map;
import java.util.HashMap;

public class FourSumTwo_new {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int N = A.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int count = 0;
				if (map.containsKey(A[i] + B[j])) {
					count = map.get(A[i] + B[j]);
				}
				map.put(A[i] + B[j], 1 + count);

			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map.containsKey(-1 * (C[i] + D[j]))) {
					count += map.get(-1 * (C[i] + D[j]));
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		/*
		 * int[] A = { 1, 2 };
		 * int[] B = { -2, -1 };
		 * int[] C = { -1, 2 };
		 * int[] D = { 0, 2 };
		 */

		/*
		 * int[] A = { -1, -1 };
		 * int[] B = { -1, 1 };
		 * int[] C = { -1, 1 };
		 * int[] D = { 1, -1 };
		 */
		int[] A = { 0, 1, -1 };
		int[] B = { -1, 1, 0 };
		int[] C = { 0, 0, 1 };
		int[] D = { -1, 1, 1 };
		System.out.println(new FourSumTwo_new().fourSumCount(A, B, C, D));
	}
}
