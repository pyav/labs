/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Output:
 * ------
 * [0, 1, 3]
 * [0, 2, 3]
 * [0, 4]
 * [0, 3, 4]
 * [0, 1, 3, 4]
 * [0, 1, 2, 3, 4]
 * [0, 1, 4]
 */

package leetcode;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllPathsFromSourceToTarget {

	void DFS(int next, int[][] graph, Stack<Integer> stack, List<List<Integer>> allPaths) {
		stack.push(next);
		for (int j = 0; j < graph[next].length; j++) {
			int next2 = graph[next][j];
			if (next2 == graph.length - 1) {
				stack.push(next2);
				ArrayList<Integer> list = new ArrayList<Integer>(stack);
				allPaths.add(list);
				stack.pop();
			}
			DFS(next2, graph, stack, allPaths);
		}
		stack.pop();
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		Stack<Integer> stack = new Stack<Integer>();
		List<List<Integer>> allPaths = new ArrayList<List<Integer>>();
		DFS(0, graph, stack, allPaths);
		return allPaths;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
		List<List<Integer>> allPaths = new AllPathsFromSourceToTarget().allPathsSourceTarget(graph);
		Iterator<List<Integer>> outItr = allPaths.iterator();
		while (outItr.hasNext()) {
			List<Integer> item = outItr.next();
			System.out.println(item.toString());
		}
		int[][] graph2 = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
		allPaths = new AllPathsFromSourceToTarget().allPathsSourceTarget(graph2);
		outItr = allPaths.iterator();
		while (outItr.hasNext()) {
			List<Integer> item = outItr.next();
			System.out.println(item.toString());
		}
	}
}

