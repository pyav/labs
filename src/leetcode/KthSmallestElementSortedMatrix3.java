/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * Output:
 * ------
 * 13
 * -5
 * 3
 * 12
 * 5
 */

package leetcode;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix3 {

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				pq.add(matrix[i][j]);
			}
		}
		while (k > 1) {
			pq.poll();
			k--;
		}
		return pq.poll();
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(new KthSmallestElementSortedMatrix3().kthSmallest(matrix, 7));
		int[][] matrix2 = { { -5 } };
		System.out.println(new KthSmallestElementSortedMatrix3().kthSmallest(matrix2, 1));
		int[][] matrix3 = { { 1, 2 }, { 1, 3 } };
		System.out.println(new KthSmallestElementSortedMatrix3().kthSmallest(matrix3, 4));
		int[][] matrix4 = { { 1, 3, 5 }, { 6, 7, 12 }, { 11, 14, 14 } };
		System.out.println(new KthSmallestElementSortedMatrix3().kthSmallest(matrix4, 7));
		int[][] matrix5 = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(new KthSmallestElementSortedMatrix3().kthSmallest(matrix5, 5));
	}

}
