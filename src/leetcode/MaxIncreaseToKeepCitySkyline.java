/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 * 
 * Output:
 * ------
 * 0
 * 35
 */

package leetcode;

public class MaxIncreaseToKeepCitySkyline {

	public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxRows = new int[grid.length];
        int[] maxCols = new int[grid[0].length];
        int sum = 0;
        int n = maxRows.length;

        for (int i = 0; i < n; i++) {
            maxRows[i] = grid[i][0];
            for (int j = 1; j < n; j++) {
                if (grid[i][j] > maxRows[i]) {
                    maxRows[i] = grid[i][j];
                }
            }
        }
        for (int j = 0; j < n; j++) {
            maxCols[j] = grid[0][j];
            for (int i = 1; i < n; i++) {
                if (grid[i][j] > maxCols[j]) {
                    maxCols[j] = grid[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(maxRows[i], maxCols[j]) - grid[i][j];
            }
        }
        return sum;
	}

	public static void main(String[] args) {
        int[][] grid = {{0,0,0}, {0,0,0}, {0,0,0}};
        System.out.println(new MaxIncreaseToKeepCitySkyline().maxIncreaseKeepingSkyline(grid));
        int[][] grid2 = {{3,0,8,4}, {2,4,5,7}, {9,2,6,3}, {0,3,1,0}};
        System.out.println(new MaxIncreaseToKeepCitySkyline().maxIncreaseKeepingSkyline(grid2));
	}

}

