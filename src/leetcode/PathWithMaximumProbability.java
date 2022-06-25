/**
 * https://leetcode.com/problems/path-with-maximum-probability/
 * 
 * Output:
 * ------
 * 0.3
 * 0.0
 * 0.2139
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {

	class Node {
		int vertex;
		double weight;

		Node(int v, double w) {
			vertex = v;
			weight = w;
		}

		int getVertex() {
			return vertex;
		}

		double getWeight() {
			return weight;
		}
	}

	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).add(new Node(edges[i][1], succProb[i]));
			graph.get(edges[i][1]).add(new Node(edges[i][0], succProb[i]));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				if (node1.getWeight() > node2.getWeight()) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		double[] distance = new double[n];
		Arrays.fill(distance, 0);
		distance[start] = 1;
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		pq.add(new Node(start, 0));
		while (pq.size() > 0) {
			Node currNode = pq.poll();
			visited[currNode.getVertex()] = true;
			for (Node node : graph.get(currNode.getVertex())) {
				if (distance[currNode.getVertex()] * node.getWeight() > distance[node.getVertex()]) {
					distance[node.getVertex()] = distance[currNode.getVertex()] * node.getWeight();
					if (!visited[node.getVertex()]) {
						pq.add(new Node(node.getVertex(), distance[node.getVertex()]));
						visited[node.getVertex()] = true;
					}
				}
			}
		}
		return distance[end];
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
		double[] succProb = { 0.5, 0.5, 0.3 };
		System.out.println(new PathWithMaximumProbability().maxProbability(3, edges, succProb, 0, 2));
		int[][] edges2 = { { 0, 1 } };
		double[] succProb2 = { 0.5 };
		System.out.println(new PathWithMaximumProbability().maxProbability(3, edges2, succProb2, 0, 2));
		int[][] edges3 = { { 1, 4 }, { 2, 4 }, { 0, 4 }, { 0, 3 }, { 0, 2 }, { 2, 3 } };
		double[] succProb3 = { 0.37, 0.17, 0.93, 0.23, 0.39, 0.04 };
		System.out.println(new PathWithMaximumProbability().maxProbability(5, edges3, succProb3, 3, 4));
	}

}

