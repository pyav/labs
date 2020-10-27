/**
 * Output:
 * ------
 * 5 4 2 3 1 0 
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class TopologicalGraph {

	private int V;
	private ArrayList<ArrayList<Integer>> adj;

	TopologicalGraph(int v) {
		V = v;
		adj = new ArrayList<ArrayList<Integer>>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	void addEdge(int u, int v) {
		adj.get(u).add(v);
	}

	void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		while (!stack.empty()) {
			System.out.printf("%d ", stack.pop());
		}
		System.out.println();
	}

	private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		Integer i;
		Iterator<Integer> it = adj.get(v).iterator();

		while (it.hasNext()) {
			i = it.next();
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		stack.push(new Integer(v));
	}
}

public class TopologicalSort {

	public static void main(String[] args) {

		TopologicalGraph graph = new TopologicalGraph(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		graph.topologicalSort();
	}

}
