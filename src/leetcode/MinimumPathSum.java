/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Output:
 * ------
 * 7
 * 12
 */

package leetcode;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i][0] + grid[i-1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j] + grid[0][j-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(new MinimumPathSum().minPathSum(grid));
        int[][] grid2 = {{1,2,3}, {4,5,6}};
        System.out.println(new MinimumPathSum().minPathSum(grid2));
    }

}

