/**
 * Following code demonstrates the adjacency list representation of a graph.
 * 
 * Output
 * ------
 * Vertex 0: 1  4 
 * Vertex 1: 0  2  3  4 
 * Vertex 2: 1  3 
 * Vertex 3: 1  2  4 
 * Vertex 4: 0  1  3 
 * 
 * 
 * @author pyav
 */

import java.util.LinkedList;

class Graph {

	int vertices;
	LinkedList<Integer> adjList[];

	@SuppressWarnings("unchecked")
	Graph(int vertexCount) {
		setVertices(vertexCount);
		adjList = new LinkedList[getVertices()];

		for (int i = 0; i < getVertices(); i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	/**
	 * Method to add an edge i.e. connect two vertices.
	 * 
	 * @param src
	 *            The source vertex.
	 * @param dest
	 *            The destination vertex.
	 */
	void addEdge(int src, int dest) {
		this.adjList[src].add(dest);
		this.adjList[dest].add(src);
	}

	/**
	 * Method to return the adjacency list of the graph.
	 * 
	 * @return The linked list of the connected vertices.
	 */
	LinkedList<Integer>[] getGraph() {
		return this.adjList;
	}

	/**
	 * Method to set the number of vertices.
	 * 
	 * @param vertexCount
	 *            The number of the vertices.
	 */
	void setVertices(int vertexCount) {
		this.vertices = vertexCount;
	}

	/**
	 * @return The number of vertices of the graph.
	 */
	int getVertices() {
		return this.vertices;
	}

	void printGraph() {
		vertices = getVertices();
		LinkedList<Integer>[] adjList = getGraph();

		for (int i = 0; i < vertices; i++) {
			System.out.printf("Vertex %d:", i);

			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.printf(" %d ", adjList[i].get(j));
			}
			System.out.println();
		}
	}
}

public class AdjacencyListRepresentation {

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.printGraph();
	}

}
