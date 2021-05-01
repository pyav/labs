/**
 * This code shows Prim's algorithm for minimum spanning tree using adjacency
 * list representation of the graph.
 * 
 * Output:
 * ------
 * 0  - 1
 * 5  - 2
 * 2  - 3
 * 3  - 4
 * 6  - 5
 * 7  - 6
 * 0  - 7
 * 2  - 8
 */

package algorithms.graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class PrimsMSTAdjacencyList {

	class NodeAdjList {
		int dest;
		int weight;

		NodeAdjList(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}

	static class Graph {
		int V;
		LinkedList<NodeAdjList>[] adj;

		@SuppressWarnings("unchecked")
		Graph(int vertices) {
			V = vertices;
			adj = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<NodeAdjList>();
			}
		}
	}

	class NodePQ {
		int vertex;
		int key;
	}

	class Compar implements Comparator<NodePQ> {

		@Override
		public int compare(NodePQ o1, NodePQ o2) {
			return o1.key - o2.key;
		}

	}

	void addEdge(Graph graph, int src, int dest, int weight) {
		graph.adj[src].addLast(new NodeAdjList(dest, weight));
		graph.adj[dest].addLast(new NodeAdjList(src, weight));
	}

	void primsMST(Graph graph) {
		boolean[] mstSet = new boolean[graph.V];
		NodePQ[] pqNodeArr = new NodePQ[graph.V];
		int[] parent = new int[graph.V];

		for (int i = 0; i < graph.V; i++) {
			pqNodeArr[i] = new NodePQ();
		}
		for (int i = 0; i < graph.V; i++) {
			mstSet[i] = false;
			pqNodeArr[i].vertex = i;
			pqNodeArr[i].key = Integer.MAX_VALUE;
			parent[i] = -1;
		}
		mstSet[0] = true;
		pqNodeArr[0].key = 0;
		TreeSet<NodePQ> pQueue = new TreeSet<NodePQ>(new Compar());

		for (int i = 0; i < graph.V; i++) {
			pQueue.add(pqNodeArr[i]);
		}
		while (!pQueue.isEmpty()) {
			NodePQ nodePQ = pQueue.pollFirst();
			mstSet[nodePQ.vertex] = true;
			for (NodeAdjList itr : graph.adj[nodePQ.vertex]) {
				if (mstSet[itr.dest] == false) {
					if (pqNodeArr[itr.dest].key > itr.weight) {
						pQueue.remove(pqNodeArr[itr.dest]);
						pqNodeArr[itr.dest].key = itr.weight;
						pQueue.add(pqNodeArr[itr.dest]);
						parent[itr.dest] = nodePQ.vertex;
					}
				}
			}
		}
		printGraph(graph, parent);
	}

	void printGraph(Graph graph, int[] parent) {
		for (int i = 1; i < graph.V; i++) {
			System.out.println(parent[i] + " " + " - " + i);
		}
	}

	public static void main(String[] args) {
		int V = 9;
		Graph graph = new Graph(V);
		PrimsMSTAdjacencyList e = new PrimsMSTAdjacencyList();
		e.addEdge(graph, 0, 1, 4);
		e.addEdge(graph, 0, 7, 8);
		e.addEdge(graph, 1, 2, 8);
		e.addEdge(graph, 1, 7, 11);
		e.addEdge(graph, 2, 3, 7);
		e.addEdge(graph, 2, 8, 2);
		e.addEdge(graph, 2, 5, 4);
		e.addEdge(graph, 3, 4, 9);
		e.addEdge(graph, 3, 5, 14);
		e.addEdge(graph, 4, 5, 10);
		e.addEdge(graph, 5, 6, 2);
		e.addEdge(graph, 6, 7, 1);
		e.addEdge(graph, 6, 8, 6);
		e.addEdge(graph, 7, 8, 7);
		e.primsMST(graph);
	}

}
