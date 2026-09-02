/**
 * https://leetcode.com/problems/rotting-oranges/description/
 *
 * Output:
 * ------
 * 4
 * -1
 * 0
 * -1
 * 0
 * 0
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean isFreshPresent = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (2 == grid[i][j]) {
                    q.offer(new int[]{i, j});
                }
                if (1 == grid[i][j]) {
                    isFreshPresent = true;
                }
            }
        }
        if (!isFreshPresent) {
            return 0;
        }
        if (q.isEmpty()) {
            return -1;
        }

        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;

        while(!q.isEmpty()) {
            Queue<int[]> q2 = new LinkedList<>();

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
                            && 1 == grid[nextRow][nextCol]) {

                        visited[nextRow][nextCol] = true;
                        q2.offer(new int[]{nextRow, nextCol});
                    }
                }
            }

            if (!q2.isEmpty()) {
                q.addAll(q2);
                result++;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (1 == grid[i][j] && !visited[i][j]) {
                    return -1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{2,1,1}, {1,1,0}, {0,1,1}}));
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{2,1,1}, {0,1,1}, {1,0,1}}));
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{0,2}}));
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{1}}));
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{2}}));
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{0}}));
    }
}

