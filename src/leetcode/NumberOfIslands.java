/**
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * Output:
 * ------
 * Number of islands: 3
 * Number of islands: 1
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int result = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && '1' == grid[i][j]) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    result++;
                }
                while(!q.isEmpty()) {
                    int[] arr = q.poll();
                    int m = arr[0];
                    int n = arr[1];
                    for (int[] direction : directions) {
                        int nextRow = m + direction[0];
                        int nextCol = n + direction[1];
                        if (nextRow >= 0 && nextRow < rows
                            && nextCol >= 0 && nextCol < cols
                            && !visited[nextRow][nextCol]
                            && '1' == grid[nextRow][nextCol]) {

                            visited[nextRow][nextCol] = true;
                            q.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        int numIslands = numIslands(grid);
        System.out.println("Number of islands: " + numIslands);

        char[][] grid2 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        numIslands = numIslands(grid2);
        System.out.println("Number of islands: " + numIslands);
    }
}
