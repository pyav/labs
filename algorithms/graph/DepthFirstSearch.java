/**
 * Following code demonstrates the Depth First Search Graph traversal from a
 * given source vertex in a graph.
 * 
 * Output
 * ------
 * Depth First sequence from vertex 2 is: 2 0 1 3 
 *  
 * 
 * @author pyav
 */

import java.util.Iterator;
import java.util.LinkedList;

class DFSGraph {
	private int vertexCount;
	private LinkedList<Integer> adjList[];

	@SuppressWarnings("unchecked")
	DFSGraph(int V) {
		vertexCount = V;
		adjList = new LinkedList[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}

	void DFSUtil(int vertex, boolean visited[]) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		Iterator<Integer> itr = adjList[vertex].iterator();
		while (itr.hasNext()) {
			int next = itr.next();
			if (!visited[next]) {
				DFSUtil(next, visited);
			}
		}
	}

	void DFS(int startVertex) {
		boolean visited[] = new boolean[vertexCount];
		DFSUtil(startVertex, visited);

	}
}

public class DepthFirstSearch {

	public static void main(String[] args) {
		DFSGraph g = new DFSGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		int startVertex = 2;
		System.out.print("Depth First sequence from vertex " + startVertex + " is: ");
		g.DFS(startVertex);
	}

}
