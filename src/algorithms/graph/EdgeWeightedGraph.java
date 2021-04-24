import java.util.Iterator;

class Bag<Item> implements Iterable<Item> {

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Edge e) {
		// TODO Auto-generated method stub

	}

	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return this.size();
	}

}

public class EdgeWeightedGraph {

	private final int V;
	private final Bag<Edge>[] adj;

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.adj = (Bag<Edge>[]) new Bag [V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Edge>();
		}

	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public static void main(String[] args) {

	}

}
