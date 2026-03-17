/**
 * https://leetcode.com/problems/n-queens/description/ 
 * Output:
 * ------
 * [.Q.., ...Q, Q..., ..Q.]
 * [..Q., Q..., ...Q, .Q..]
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	
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
	
	
	private void placeQueens(int row, int[][] mat, List<List<Integer>> result) {
		int n = mat.length;
		
		if (row == n) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mat[i][j] == 1) {
						list.add(j+1);
					}
				}
			}
			result.add(list);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isSafe(row, i, mat) == 1) {
				mat[row][i] = 1;
				placeQueens(row+1, mat, result);
				mat[row][i] = 0;
			}
		}
	}
	
	public List<List<String>> solveNQueens(int n) {
		int[][] mat = new int[n][n];
		List<List<Integer>> result = new ArrayList<>();
		
		placeQueens(0, mat, result);
		
		
		List<List<String>> resultStr = new ArrayList<>();
		
		for (List<Integer> list : result) {
			int i = 0;
			List<String> rs = new ArrayList<>();
			
			while (i < list.size()) {
				int val = list.get(i)-1;
				String str = "";
				for (int j = 0; j < n; j++) {
					if (j == val) {
						str += "Q";
					} else {
						str += ".";
					}
				}
				rs.add(str);
				i++;
			}
			resultStr.add(rs);
		}
		
		
		return resultStr;
    }

	public static void main(String[] args) {
		List<List<String>> result = new NQueens().solveNQueens(4);
		for (List<String> list : result) {
			System.out.println(list);
		}
		System.out.println();
	}

}
