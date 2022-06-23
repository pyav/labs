/**
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 * 
 * Output:
 * ------
 * 4
 * 1
 * 166
 * 2891
 * 2
 * 2
 */

package leetcode;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {

	class Node {
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

	public int countPaths(int n, int[][] roads) {
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < roads.length; i++) {
			graph.get(roads[i][0]).add(new Node(roads[i][1], roads[i][2]));
			graph.get(roads[i][1]).add(new Node(roads[i][0], roads[i][2]));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.getWeight() - v2.getWeight());
		pq.add(new Node(0, 0));
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		int[] count = new int[n];
		Arrays.fill(count, 0);
		count[0] = 1;
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		while (pq.size() > 0) {
			Node currNode = pq.poll();
			visited[currNode.getVertex()] = true;
			for (Node node : graph.get(currNode.getVertex())) {
				if (distance[currNode.getVertex()] + node.getWeight() < distance[node.getVertex()]) {
					distance[node.getVertex()] = distance[currNode.getVertex()] + node.getWeight();
					if (!visited[node.getVertex()]) {
						pq.add(new Node(node.getVertex(), distance[node.getVertex()]));
						visited[node.getVertex()] = true;
					}
					count[node.getVertex()] = count[currNode.getVertex()];
				} else if (distance[currNode.getVertex()] + node.getWeight() == distance[node.getVertex()]) {
					count[node.getVertex()] = (int) ((count[node.getVertex()] + count[currNode.getVertex()])
							% 1000000007);
				}
			}
		}

		for (Node node : graph.get(n - 1)) {
			if (graph.get(n - 1).size() == 1 && count[n - 1] < count[node.getVertex()]) {
				count[n - 1] = count[node.getVertex()];
			}
		}

		return count[n - 1];
	}

	public static void main(String[] args) {
		int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
				{ 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
		System.out.println(new NumberOfWaysToArriveAtDestination().countPaths(7, roads));
		int[][] roads2 = { { 1, 0, 10 } };
		System.out.println(new NumberOfWaysToArriveAtDestination().countPaths(2, roads2));
		int[][] roads3 = { { 1, 0, 2348 }, { 2, 1, 2852 }, { 2, 0, 5200 }, { 3, 1, 12480 }, { 2, 3, 9628 },
				{ 4, 3, 7367 }, { 4, 0, 22195 }, { 5, 4, 5668 }, { 1, 5, 25515 }, { 0, 5, 27863 }, { 6, 5, 836 },
				{ 6, 0, 28699 }, { 2, 6, 23499 }, { 6, 3, 13871 }, { 1, 6, 26351 }, { 5, 7, 6229 }, { 2, 7, 28892 },
				{ 1, 7, 31744 }, { 3, 7, 19264 }, { 6, 7, 5393 }, { 2, 8, 31998 }, { 8, 7, 3106 }, { 3, 8, 22370 },
				{ 8, 4, 15003 }, { 8, 6, 8499 }, { 8, 5, 9335 }, { 8, 9, 5258 }, { 9, 2, 37256 }, { 3, 9, 27628 },
				{ 7, 9, 8364 }, { 1, 9, 40108 }, { 9, 5, 14593 }, { 2, 10, 45922 }, { 5, 10, 23259 }, { 9, 10, 8666 },
				{ 10, 0, 51122 }, { 10, 3, 36294 }, { 10, 4, 28927 }, { 11, 4, 25190 }, { 11, 9, 4929 },
				{ 11, 8, 10187 }, { 11, 6, 18686 }, { 2, 11, 42185 }, { 11, 3, 32557 }, { 1, 11, 45037 } };
		System.out.println(new NumberOfWaysToArriveAtDestination().countPaths(12, roads3));
		int[][] roads4 = { { 0, 1, 3972 }, { 2, 1, 1762 }, { 3, 1, 4374 }, { 0, 3, 8346 }, { 3, 2, 2612 },
				{ 4, 0, 6786 }, { 5, 4, 1420 }, { 2, 6, 7459 }, { 1, 6, 9221 }, { 6, 3, 4847 }, { 5, 6, 4987 },
				{ 7, 0, 14609 }, { 7, 1, 10637 }, { 2, 7, 8875 }, { 7, 6, 1416 }, { 7, 5, 6403 }, { 7, 3, 6263 },
				{ 4, 7, 7823 }, { 5, 8, 10184 }, { 8, 1, 14418 }, { 8, 4, 11604 }, { 7, 8, 3781 }, { 8, 2, 12656 },
				{ 8, 0, 18390 }, { 5, 9, 15094 }, { 7, 9, 8691 }, { 9, 6, 10107 }, { 9, 1, 19328 }, { 9, 4, 16514 },
				{ 9, 2, 17566 }, { 9, 0, 23300 }, { 8, 9, 4910 }, { 9, 3, 14954 }, { 4, 10, 26060 }, { 2, 10, 27112 },
				{ 10, 1, 28874 }, { 8, 10, 14456 }, { 3, 10, 24500 }, { 5, 10, 24640 }, { 10, 6, 19653 },
				{ 10, 0, 32846 }, { 10, 9, 9546 }, { 10, 7, 18237 }, { 11, 7, 21726 }, { 11, 2, 30601 },
				{ 4, 11, 29549 }, { 11, 0, 36335 }, { 10, 11, 3489 }, { 6, 11, 23142 }, { 3, 11, 27989 },
				{ 11, 1, 32363 }, { 11, 8, 17945 }, { 9, 11, 13035 }, { 5, 11, 28129 }, { 2, 12, 33902 },
				{ 5, 12, 31430 }, { 6, 12, 26443 }, { 4, 12, 32850 }, { 12, 3, 31290 }, { 11, 12, 3301 },
				{ 12, 1, 35664 }, { 7, 13, 28087 }, { 13, 8, 24306 }, { 6, 13, 29503 }, { 11, 13, 6361 },
				{ 4, 13, 35910 }, { 13, 12, 3060 }, { 3, 13, 34350 }, { 13, 5, 34490 }, { 13, 2, 36962 },
				{ 10, 13, 9850 }, { 9, 13, 19396 }, { 12, 14, 8882 }, { 8, 14, 30128 }, { 14, 6, 35325 },
				{ 14, 5, 40312 }, { 1, 14, 44546 }, { 11, 14, 12183 }, { 15, 12, 13581 }, { 2, 15, 47483 },
				{ 4, 15, 46431 }, { 15, 10, 20371 }, { 15, 14, 4699 }, { 15, 6, 40024 }, { 15, 7, 38608 },
				{ 1, 15, 49245 }, { 11, 15, 16882 }, { 8, 15, 34827 }, { 0, 15, 53217 }, { 5, 15, 45011 },
				{ 15, 3, 44871 }, { 16, 2, 53419 }, { 16, 9, 35853 }, { 1, 16, 55181 }, { 16, 7, 44544 },
				{ 8, 16, 40763 }, { 0, 16, 59153 }, { 15, 16, 5936 }, { 16, 10, 26307 }, { 16, 6, 45960 },
				{ 12, 16, 19517 }, { 17, 2, 57606 }, { 17, 3, 54994 }, { 17, 14, 14822 }, { 17, 11, 27005 },
				{ 0, 17, 63340 }, { 17, 7, 48731 }, { 8, 17, 44950 }, { 17, 16, 4187 }, { 5, 17, 55134 },
				{ 17, 10, 30494 }, { 17, 9, 40040 }, { 17, 12, 23704 }, { 13, 17, 20644 }, { 17, 1, 59368 } };
		System.out.println(new NumberOfWaysToArriveAtDestination().countPaths(18, roads4));
		int[][] roads5 = { { 0, 1, 1 }, { 1, 2, 4 }, { 0, 4, 3 }, { 3, 2, 5 }, { 3, 4, 1 }, { 3, 0, 5 }, { 1, 3, 1 } };
		System.out.println(new NumberOfWaysToArriveAtDestination().countPaths(5, roads5));
		int[][] roads6 = { { 3, 0, 4 }, { 0, 2, 3 }, { 1, 2, 2 }, { 4, 1, 3 }, { 2, 5, 5 }, { 2, 3, 1 }, { 0, 4, 1 },
				{ 2, 4, 6 }, { 4, 3, 1 } };
		System.out.println(new NumberOfWaysToArriveAtDestination().countPaths(6, roads6));
	}

}

