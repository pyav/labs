/**
 * Following code demonstrates Depth First Search.
 * The output of this code is:
 * 
 * Depth First Traversal: 
 * 2 0 1 3 
 * 
 * @author pyav
 */

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstTraversal {
	
	private int nodes;
	private LinkedList<Integer> adj[];
	
	DepthFirstTraversal(int n) {
		nodes = n;
		adj = new LinkedList[nodes];
		
		for (int i = 0; i < nodes; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void dfsOperate(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> i = adj[v].listIterator();
		
		while (i.hasNext()) {
			int k = i.next();
			
			if (!visited[k]) {
				dfsOperate(k, visited);
			}
		}
		
	}
	
	void DFS(int v) {
		boolean visited[] = new boolean[nodes];
		
		dfsOperate(v, visited);
	}
	
	public static void main(String[] args) {

		DepthFirstTraversal n = new DepthFirstTraversal(4);
	
		n.addEdge(0, 1);
		n.addEdge(0, 2);
		n.addEdge(1, 2);
		n.addEdge(2, 0);
		n.addEdge(2, 3);
		n.addEdge(3, 3);
		
		System.out.println("Depth First Traversal: ");
		n.DFS(2);
	}

}
