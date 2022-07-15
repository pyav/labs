/**
 * https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
 *
 * Output:
 * ------
 * 3 2 2 
 * 2 3 2 4
 */

package leetcode;

import java.util.Arrays;

public class PointsInsideCircle {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] count = new int[queries.length];
        Arrays.fill(count, 0);
        for (int j = 0; j < queries.length; j++) {
            for (int i = 0; i < points.length; i++) {
                double distance = Math.sqrt(Math.pow(queries[j][0]-points[i][0], 2)
                                + Math.pow(queries[j][1]-points[i][1], 2));
                if (queries[j][2] >= distance) {
                    count[j]++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] res = new PointsInsideCircle().countPoints(points, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
        System.out.println();
        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] queries2 = {{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}};
        int[] res2 = new PointsInsideCircle().countPoints(points2, queries2);
        for (int i = 0; i < res2.length; i++) {
            System.out.printf("%d ", res2[i]);
        }
    }

}

