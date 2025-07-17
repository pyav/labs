/**
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * Output:
 * ------
 * 16
 * 4
 * 4
 */

import java.util.Arrays;

public class IslandPerimeter {
    private int[] getFirstIndexWithValueOne(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }
    private boolean isCornerGrid(int[][] grid, int i, int j) {
        if ((i == 0 && j == 0)
            || (i == 0 && j == grid[0].length-1)
            || (i == grid.length-1 && j == 0)
            || (i == grid.length-1 && j == grid[0].length-1)) {
            return true;
        }
        return false;
    }
    private boolean isSideGrid(int[][] grid, int i, int j) {
        if ((i==0) || (j==grid[0].length-1) || (i==grid.length-1) || (j==0)) {
            return true;
        }
        return false;
    }

    int perimeter = 0;

    private int calcPerimeter(int[][] grid, boolean[][] visited, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || visited[sr][sc] || grid[sr][sc] == 0) {
            return 0;
        }
        if (!visited[sr][sc] && isCornerGrid(grid, sr, sc)) {
            if (grid.length == 1 && grid[0].length == 1) {
                perimeter += 4;
            } else if ((grid.length != 1 && grid[0].length == 1)
                       || (grid.length == 1 && grid[0].length != 1)) {
                perimeter += 3;
            } else {
                perimeter += 2;
            }
            visited[sr][sc] = true;
        }
        if (!visited[sr][sc] && isSideGrid(grid, sr, sc)) {
            if ((grid.length != 1 && grid[0].length == 1)
                       || (grid.length == 1 && grid[0].length != 1)) {
                perimeter += 2;
            } else {
                perimeter += 1;
            }
            visited[sr][sc] = true;
        }
        if (sc+1 <= grid[0].length-1 && grid[sr][sc+1] == 0) {
            perimeter += 1;
        }
        if (sc-1 >= 0 && grid[sr][sc-1] == 0) {
            perimeter += 1;
        }
        if (sr+1 <= grid.length-1 && grid[sr+1][sc] == 0) {
            perimeter += 1;
        }
        if (sr-1 >= 0 && grid[sr-1][sc] == 0) {
            perimeter += 1;
        }
        visited[sr][sc] = true;
        calcPerimeter(grid, visited, sr+1, sc);
        calcPerimeter(grid, visited, sr, sc+1);
        calcPerimeter(grid, visited, sr, sc-1);
        calcPerimeter(grid, visited, sr-1, sc);
        return this.perimeter;
    }

    public int islandPerimeter(int[][] grid) {
        int[] gridWithOne = getFirstIndexWithValueOne(grid);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Arrays.stream(visited).forEach(row -> Arrays.fill(row, false));
        return calcPerimeter(grid, visited, gridWithOne[0], gridWithOne[1]);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
        int[][] grid2 = {{1}};
        System.out.println(new IslandPerimeter().islandPerimeter(grid2));
        int[][] grid3 = {{1,0}};
        System.out.println(new IslandPerimeter().islandPerimeter(grid3));
    }
}

