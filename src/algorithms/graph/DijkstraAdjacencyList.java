/**
 * Output:
 * ------
 * Vertex	Distance from source:
 * 0    	0
 * 1    	4
 * 2	    12
 * 3	    19
 * 4	    21
 * 5	    11
 * 6	    9
 * 7	    8
 * 8	    14
 *
 */

import java.util.*;

public class DijkstraAdjacencyList {

    static class Node {
        int vertex;
        int weight;

        Node(int v, int w) {
            vertex = v;
            weight = w;
        }
        int getVertex() {
            return vertex;
        }
        int getWeight() {
            return weight;
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<Node>> graph, int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<> ((v1, v2) ->
                v1.getWeight() - v2.getWeight());
        pq.add(new Node(src, 0));

        while(pq.size() > 0) {
            Node current = pq.poll();
            for (Node n : graph.get(current.getVertex())) {
                if (distance[current.getVertex()] + n.getWeight() <
                    distance[n.getVertex()]) {
                    distance[n.getVertex()] = distance[current.getVertex()] + n.getWeight();
                    pq.add(new Node(n.getVertex(), distance[n.getVertex()]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int V = 9;
        ArrayList<ArrayList<Node>> graph = new ArrayList<> ();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Node> ());
        }
        int source = 0;
        graph.get(0).add(new Node(1, 4));
        graph.get(0).add(new Node(7, 8));
        graph.get(1).add(new Node(2, 8));
        graph.get(1).add(new Node(7, 11));
        graph.get(1).add(new Node(0, 7));
        graph.get(2).add(new Node(1, 8));
        graph.get(2).add(new Node(3, 7));
        graph.get(2).add(new Node(8, 2));
        graph.get(2).add(new Node(5, 4));
        graph.get(3).add(new Node(2, 7));
        graph.get(3).add(new Node(4, 9));
        graph.get(3).add(new Node(5, 14));
        graph.get(4).add(new Node(3, 9));
        graph.get(4).add(new Node(5, 10));
        graph.get(5).add(new Node(4, 10));
        graph.get(5).add(new Node(6, 2));
        graph.get(6).add(new Node(5, 2));
        graph.get(6).add(new Node(7, 1));
        graph.get(6).add(new Node(8, 6));
        graph.get(7).add(new Node(0, 8));
        graph.get(7).add(new Node(1, 11));
        graph.get(7).add(new Node(6, 1));
        graph.get(7).add(new Node(8, 7));
        graph.get(8).add(new Node(2, 2));
        graph.get(8).add(new Node(6, 6));
        graph.get(8).add(new Node(7, 1));

        int[] distance = dijkstra(V, graph, source);
        System.out.println("Vertex\tDistance from source:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + distance[i]);
        }
    }

}

