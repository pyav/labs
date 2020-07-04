/**
 * References:
 * ----------
 *   - https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
 *   - https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 * 
 * 
 * Notes:
 * -----
 *   - Incrementally improve the estimate of shortest path between two vertices until the estimate is optimal.
 *   - Theta(|v|^3) comparisons in a graph.
 *   - Recursive case:
 * 	   --------------
 * 	   shortestPath(i,j,k) = min(shortestPath(i,j,k-1), shortestPath(i,k,k-1) + shortestPath(k,j,k-1))
 * 
 * 
 * Output:
 * ------
 * 0 5 8 9 
 * INF 0 3 4 
 * INF INF 0 1 
 * INF INF INF 0
 *  
 */

package algorithms.dynamicprogramming;

public class FloydWarshall {

	final static int V = 4, INF = Integer.MAX_VALUE;

	private static void calculateFloydWarshallWt(int graph[][]) {

		int i, j, k;

		for (k = 0; k < V; k++) {
			for (i = 0; i < V; i++) {
				for (j = 0; j < V; j++) {
					if ((graph[i][k] != INF) && (graph[k][j] != INF) && (graph[i][j] > graph[i][k] + graph[k][j])) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		printGraph(graph);
	}

	static void printGraph(int graph[][]) {

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (graph[i][j] == INF) {
					System.out.print("INF ");
				} else {
					System.out.print(graph[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };
		calculateFloydWarshallWt(graph);
	}

}
