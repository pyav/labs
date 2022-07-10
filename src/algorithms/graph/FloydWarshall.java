/**
 * Demonstration of Floyd-Warshall algorithm
 *
 * Output:
 * ------
 * 0	5	8	9	
 * INF	0	3	4	
 * INF	INF	0	1	
 * INF	INF	INF	0
 */

class FloydWarshall {

    int[][] dist;
    int V;

    void floydWarshall(int[][] graph) {
        V = graph.length;
        dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE
                        && dist[k][j] != Integer.MAX_VALUE
                        && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    void printSolution() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.printf("INF\t");
                } else {
                    System.out.printf("%d\t", dist[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                          {0, 5, Integer.MAX_VALUE, 10},
                          {Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE},
                          {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
                          {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
                        };
        FloydWarshall sol = new FloydWarshall();
        sol.floydWarshall(graph);
        sol.printSolution();
    }
    
}

