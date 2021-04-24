/**
 * Following code shows Breadth First traversal. 
 * The output of this code is:
 * 
 * The Breadth First traversal is: 
 * 2 0 3 1 
 * 
 * @author pyav
 *
 */

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstTraversal {

	private int val;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	BreadthFirstTraversal(int v)
	{
		val = v;
		adj = new LinkedList[val];
		
		for (int i = 0; i < val; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	void addEdge(int u, int v)
	{
		adj[u].add(v);
	}
	
	void BFS(int q)
	{
		boolean visited[] = new boolean[val];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[q] = true;
		queue.add(q);
		
		while (queue.size() > 0)
		{
			int t = queue.poll();
			System.out.print(t + " ");
			Iterator<Integer> i = adj[t].listIterator();
			
			while (i.hasNext())
			{
				int k = i.next();
				
				if (visited[k] != true) 
				{
					visited[k] = true;
					queue.add(k);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BreadthFirstTraversal obj = new BreadthFirstTraversal(4);
		
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(1, 2);
		obj.addEdge(2, 0);
		obj.addEdge(2, 3);
		obj.addEdge(3, 3);
		
		System.out.println("The Breadth First traversal is: ");
		
		obj.BFS(2);
	}

}
