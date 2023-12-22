/**
 * https://leetcode.com/problems/find-missing-and-repeated-values/
 *
 * Output:
 * ------
 * 2 4
 * 9 5
 */

public class FindMissingRepeatedValue {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] count = new int[grid.length * grid.length];
        int[] result = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count[grid[i][j]-1] += 1;
            }
        }
        boolean foundFirst = false;
        boolean foundSecond = false;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                result[1] = i+1;
                foundSecond = true;
            } else if (count[i] == 2) {
                result[0] = i+1;
                foundFirst = true;
            }
            if (foundFirst && foundSecond) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3}, {2,2}};
        int[] result = new FindMissingRepeatedValue().findMissingAndRepeatedValues(grid);
        System.out.printf("%d %d\n", result[0], result[1]);
        int[][] grid2 = {{9,1,7}, {8,9,2}, {3,4,6}};
        int[] result2 = new FindMissingRepeatedValue().findMissingAndRepeatedValues(grid2);
        System.out.printf("%d %d\n", result2[0], result2[1]);
    }
}

