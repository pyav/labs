/**
 * https://leetcode.com/problems/n-queens-ii/
 * 
 * Output:
 * ------ 
 * 1
 * 2
 */

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	
	private int result = 0;
		
	private int isSafe(int row, int col, int[][] mat) {
		int n = mat.length;
		int i, j;
		
		for (i = 0; i < row; i++) {
			if (mat[i][col] == 1) {
				return 0;
			}
		}
		
		for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (mat[i][j] == 1) {
				return 0;
			}
		}
		
		for (i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if (mat[i][j] == 1) {
				return 0;
			}
		}
		
		return 1;
	}
	
	
	private void placeQueens(int row, int[][] mat) {
		int n = mat.length;
		
		if (row == n) {
			result++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isSafe(row, i, mat) == 1) {
				mat[row][i] = 1;
				placeQueens(row+1, mat/*, result*/);
				mat[row][i] = 0;
			}
		}
	}
	
	public int totalNQueens(int n) {
		int[][] mat = new int[n][n];
		
		placeQueens(0, mat);
		
		return result;
    }

	public static void main(String[] args) {
		System.out.println(new NQueensII().totalNQueens(1));
		System.out.println(new NQueensII().totalNQueens(4));
	}

}
