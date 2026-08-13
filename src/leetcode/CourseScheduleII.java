/**
 * https://leetcode.com/problems/course-schedule-ii/description
 *
 * Output:
 * ------
 * 0 1
 * 
 */

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] val : prerequisites) {
            int src = val[1];
            int dest = val[0];
            list.get(src).add(dest);
            inDegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while(!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int adj : list.get(node)) {
                inDegree[adj]--;
                if (inDegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }

        if (numCourses == order.size()) {
            return order.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = new CourseScheduleII().findOrder(2, new int[][]{{1,0}});
        Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result2 = new CourseScheduleII().findOrder(2, new int[][]{{1,0}, {0,1}});
        Arrays.stream(result2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}

