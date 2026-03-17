/**
 * Following code shows N-Queens for n = 4.
 * 
 *  Output:
 *  ------
 *  2 4 1 3 
 *  3 1 4 2 
 */

import java.util.ArrayList;

public class NQueens {
	
	static int isSafe(int row, int col, int[][] mat) {
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
	
	
	static void placeQueens(int row, int[][] mat, ArrayList<ArrayList<Integer>> result) {
		int n = mat.length;
		
		if (row == n) {
			ArrayList<Integer> list = new ArrayList<>();
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
	
	
	static ArrayList<ArrayList<Integer>> nQueens(int n) {
		int[][] mat = new int[n][n];
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		placeQueens(0, mat, result);
		return result;
	}

	public static void main(String[] args) {
		int n = 4;
		
		ArrayList<ArrayList<Integer>> result = nQueens(n);
		for (ArrayList<Integer> list : result) {
			list.stream().forEach(x -> System.out.printf("%d ", x));
			System.out.println();
		}
	}

}
