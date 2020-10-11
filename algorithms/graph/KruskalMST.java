
public class KruskalMST {

	private Queue<Edge> mst;

	public KruskalMST(EdgeWeightedGraph G) {

		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>(G.edges());
		UF uf = new UF(G.V());

		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin(); // Get min weight edge on pq
			int v = e.either(), w = e.other(v);
			if (uf.connected(v, w))
				continue;
			uf.union(v, w);
			mst.enqueue(e);
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
	}

	public static void main(String[] args) {

	}

}
