/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * Output:
 * ------
 * true
 * false
 * true
 */

import java.util.*;

public class FindPathInGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            ArrayList<Integer> val;
            if (map.containsKey(src)) {
                val = map.get(src);
            } else {
                val = new ArrayList<Integer>();
            }
            val.add(dst);
            map.put(src, val);

            if (map.containsKey(dst)) {
                val = map.get(dst);
            } else {
                val = new ArrayList<Integer>();
            }
            val.add(src);
            map.put(dst, val);
        }
        ArrayList<Integer> list = map.get(source);
        if (list == null && source == destination && source == 0) {
            return true;
        }
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        while(list != null && !list.isEmpty()) {
            int val = list.remove(0);
            if (val == destination) {
                return true;
            }
            if (visited[val]) {
                continue;
            }
            visited[val] = true;
            list.addAll(map.get(val));
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,0}};
        System.out.println(new FindPathInGraph().validPath(3, edges, 0, 2));
        int[][] edges2 = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
        System.out.println(new FindPathInGraph().validPath(6, edges2, 0, 5));
        int[][] edges3 = {};
        System.out.println(new FindPathInGraph().validPath(1, edges3, 0, 0));
    }

}

