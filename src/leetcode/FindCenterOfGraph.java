/**
 * https://leetcode.com/problems/find-center-of-star-graph/
 *
 * Output:
 * ------
 * 2
 * 1
 */

import java.util.*;
import java.util.Map.Entry;

public class FindCenterOfGraph {

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int nodes = 0;
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i][0], map.getOrDefault(edges[i][0], 0) + 1);
            map.put(edges[i][1], map.getOrDefault(edges[i][1], 0) + 1);
            if (edges[i][0] > nodes) {
                nodes = edges[i][0];
            }
            if (edges[i][1] > nodes) {
                nodes = edges[i][1];
            }
        }
        int center = 0;
        //for (Entry<Integer, Integer> entry : map.entrySet()) {
        for (Integer key : map.keySet()) {
            //if (entry.getValue() == nodes - 1) {
            if (map.get(key) == nodes - 1) {
                center = key;
                break;
            }
        }
        return center;
    }
    
    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {4,2}};
        System.out.println(new FindCenterOfGraph().findCenter(edges));
        int[][] edges2 = {{1,2}, {5,1}, {1,3}, {1,4}};
        System.out.println(new FindCenterOfGraph().findCenter(edges2));
    }

}

