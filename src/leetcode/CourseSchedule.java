/**
 * https://leetcode.com/problems/course-schedule/description/
 *
 * Output:
 * ------
 * true
 * false
 */

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        while(!q.isEmpty()) {
            int node = q.poll();
            for (int adj : list.get(node)) {
                inDegree[adj]--;
                if (inDegree[adj] == 0) {
                    q.add(adj);
                }
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{{1,0}}));
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{{1,0}, {0,1}}));
    }
}

