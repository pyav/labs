/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 * 
 * Output:
 * ------
 * [0, 3]
 * [0, 2, 3]
 */

package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MinimumNumberOfVerticesToReachAllNodes {

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		boolean[] isSrcToThisDest = new boolean[n];
		Arrays.fill(isSrcToThisDest, false);
		Iterator<List<Integer>> itr = edges.iterator();
		while (itr.hasNext()) {
			List<Integer> next = itr.next();
			isSrcToThisDest[next.get(1)] = true;
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < isSrcToThisDest.length; i++) {
			if (!isSrcToThisDest[i]) {
				result.add(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {

		List<List<Integer>> edges = new ArrayList<List<Integer>>();
		edges.add(Arrays.asList(0, 1));
		edges.add(Arrays.asList(0, 2));
		edges.add(Arrays.asList(2, 5));
		edges.add(Arrays.asList(3, 4));
		edges.add(Arrays.asList(4, 2));
		System.out.println(new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(6, edges));
		List<List<Integer>> edges2 = new ArrayList<List<Integer>>();
		edges2.add(Arrays.asList(0, 1));
		edges2.add(Arrays.asList(2, 1));
		edges2.add(Arrays.asList(3, 1));
		edges2.add(Arrays.asList(1, 4));
		edges2.add(Arrays.asList(2, 4));
		System.out.println(new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(5, edges2));
	}

}

