/**
 * https://leetcode.com/problems/find-center-of-star-graph/
 *
 * Output:
 * ------
 * 1
 */

package leetcode;

import java.util.Arrays;

public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        int center = -1;
        int[] count = new int[edges.length + 1];
        Arrays.fill(count, 0);
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0] - 1;
            int second = edges[i][1] - 1;
            count[first] += 1;
            count[second] += 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == edges.length) {
                center = i+1;
            }
        }
        return center;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(new FindCenterOfStarGraph().findCenter(edges));
    }
}

