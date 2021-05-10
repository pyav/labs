/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * 
 * Output:
 * ------
 * 8
 */

package leetcode;

import java.util.Arrays;

public class CountSquareSubmatrices {

	private int min(int a, int b, int c) {
		return (a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c);
	}

	public int countSquares(int[][] matrix) {
		int[][] arr = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = 0;
		}
		for (int j = 0; j < arr[0].length; j++) {
			arr[0][j] = 0;
		}
		int[] countArr = new int[Math.max(matrix.length, matrix[0].length)];
		Arrays.fill(countArr, 0);

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (arr[i - 1][j - 1] == arr[i - 1][j] && arr[i][j - 1] == arr[i - 1][j]) {
					if (matrix[i - 1][j - 1] == 1) {
						arr[i][j] = 1 + arr[i - 1][j - 1];
					} else {
						arr[i][j] = matrix[i - 1][j - 1];
					}
				} else {
					if (matrix[i - 1][j - 1] == 0) {
						arr[i][j] = matrix[i - 1][j - 1];
					} else {
						arr[i][j] = min(arr[i - 1][j - 1], arr[i - 1][j], arr[i][j - 1]) + 1;
					}
				}
				if (arr[i][j] != 0) {
					countArr[arr[i][j] - 1] += 1;
				}
			}
		}

		int sum = 0;
		for (int i = countArr.length - 1; i >= 0; i--) {
			if (countArr[i] == 0) {
				continue;
			}
			if (i == countArr.length - 1) {
				continue;
			}
			countArr[i] = countArr[i] + countArr[i + 1];
			sum += countArr[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
		System.out.println(new CountSquareSubmatrices().countSquares(matrix));
	}

}
