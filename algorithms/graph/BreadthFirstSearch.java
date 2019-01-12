
/**
 * Following code demonstrates the Breadth First Search Graph traversal from a given source vertex.
 * 
 * Output
 * ------
 * Breadth First sequence from vertex 2 is: 2 0 3 1 
 *  
 * 
 * @author pyav
 */

import java.util.Iterator;
import java.util.LinkedList;

class BFSGraph {
	int vertexCount;
	LinkedList<Integer> adjList[];

	@SuppressWarnings("unchecked")
	BFSGraph(int V) {
		this.vertexCount = V;
		this.adjList = new LinkedList[this.vertexCount];

		for (int i = 0; i < this.vertexCount; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}

	void BFS(int startVertex) {
		boolean visited[] = new boolean[this.vertexCount];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[startVertex] = true;
		queue.add(startVertex);
		while (queue.size() != 0) {
			int currentVertex = queue.poll();
			System.out.printf(currentVertex + " ");

			Iterator<Integer> itr = this.adjList[currentVertex].iterator();
			while (itr.hasNext()) {
				int nextElement = itr.next();
				if (!visited[nextElement]) {
					queue.add(nextElement);
					visited[nextElement] = true;
				}
			}
		}

	}
}

public class BreadthFirstSearch {

	public static void main(String[] args) {
		BFSGraph g = new BFSGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		int startVertex = 2;
		System.out.print("Breadth First sequence from vertex " + startVertex + " is: ");
		g.BFS(startVertex);
	}

}
