/**
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 *
 * Output:
 * ------
 * -2 2,
 * -2 4, 3 3,
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class ClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<> ((o1, o2) ->
                Integer.compare(o2[0]*o2[0] + o2[1]*o2[1], o1[0]*o1[0] + o1[1]*o1[1]));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()) {
            int[] point = pq.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = new ClosestPointsToOrigin().kClosest(new int[][]{{1,3},{-2,2}}, 1);
        Arrays.stream(result).forEach(x -> System.out.printf("%d %d, ", x[0], x[1]));
        System.out.println();
        int[][] result2 = new ClosestPointsToOrigin().kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
        Arrays.stream(result2).forEach(x -> System.out.printf("%d %d, ", x[0], x[1]));
        System.out.println();
    }
}