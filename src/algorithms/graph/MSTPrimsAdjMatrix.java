/**
 * Following program shows Prim's algorithm for minimum spanning tree in an adjacency matrix.
 * 
 * Output:
 * ------
 * Edge 	Weight
 * 0 - 1	2
 * 1 - 2	3
 * 0 - 3	6
 * 1 - 4	5
 */

package gfg;

public class MSTPrimsAdjMatrix {

	void primMSTAdjList(int[][] graph) {
		int[] parent = new int[graph.length];
		int[] key = new int[graph.length];
		boolean[] mstSet = new boolean[graph.length];

		for (int i = 0; i < graph.length; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		for (int i = 0; i < graph.length - 1; i++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;

			for (int v = 0; v < graph.length; v++) {
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}

		printMST(parent, graph);
	}

	private void printMST(int[] parent, int[][] graph) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < graph.length; i++) {
			System.out.printf("%d%s%d%s%d", parent[i], " - ", i, "\t", graph[i][parent[i]]);
			System.out.println();
		}
	}

	private int minKey(int[] key, boolean[] mstSet) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < key.length; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };
		new MSTPrimsAdjMatrix().primMSTAdjList(graph);
	}

}
