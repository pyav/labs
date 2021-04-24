
public class ConnectedComponentsWithDFS {
	
	private boolean marked[];
	private int[] id;
	private int count;
	
	public ConnectedComponentsWithDFS(Graph G) {
		marked = new boolean[G.vertices];
		id = new int[G.vertices];
		for (int v = 0; v < G.vertices; v++) {
			if (!marked[v]) {
				dfs(v);
				count++;
			}
		}
	}
	
	public int count() {}
	public int id(int v) {}
	public void dfs(Graph G, int v) {}
	
	public static void main(String[] args) {
		
		
	}

}
