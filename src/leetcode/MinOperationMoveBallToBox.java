/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 *
 * Output:
 * ------
 * 1 1 3 
 */

package leetcode;

import java.util.List;
import java.util.ArrayList;

public class MinOperationMoveBallToBox {
	public int[] minOperations(String boxes) {
		int n = boxes.length();
		int[] res = new int[n];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (boxes.charAt(i) == '1') {
				list.add(i);
			}
		}
		for (int i = 0; i < n; i++) {
			res[i] = 0;
			for (int j = 0; j < list.size(); j++) {
				res[i] += Math.abs(i - list.get(j));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String boxes = "110";
		int[] res = new MinOperationMoveBallToBox().minOperations(boxes);
		for (int i = 0; i < res.length; i++) {
			System.out.printf("%d ", res[i]);
		}
		System.out.println();
	}

}
