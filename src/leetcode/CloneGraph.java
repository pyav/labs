/**
 * https://leetcode.com/problems/clone-graph/
 *
 * Output:
 * ------
 * 1
 * 2
 * 4
 * 3
 */

package leetcode;

import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraph {
	
	public Node cloneGraph(Node node) {
		if (null == node) {
			return null;
		}
		Map<Node, Node> map = new HashMap<Node, Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node n1 = queue.poll();
			if (!map.containsKey(n1)) {
				Node n1Val = new Node(n1.val);
				map.put(n1, n1Val);
				for (Node nghbr : n1.neighbors) {
					if (!map.containsKey(nghbr)) {
						Node ngh1 = new Node(nghbr.val);
						map.put(nghbr, ngh1);
						queue.add(nghbr);
						n1Val.neighbors.add(ngh1);
						ngh1.neighbors.add(n1Val);
					}
				}
			} else {
				for (Node nghbr : n1.neighbors) {
					Node ngh1 = new Node();
					if (!map.containsKey(nghbr)) {
						ngh1 = new Node(nghbr.val);
						map.put(nghbr, ngh1);
						queue.add(nghbr);
					} else {
						ngh1 = map.get(nghbr);
					}
					if (!map.get(n1).neighbors.contains(ngh1)) {
						map.get(n1).neighbors.add(ngh1);
					}
					if (!ngh1.neighbors.contains(map.get(n1))) {
						ngh1.neighbors.add(map.get(n1));
					}
				}
			}
		}

		return map.get(node);
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		
		Node result = new CloneGraph().cloneGraph(node1);
		Queue<Node> neighbors = new LinkedList<Node>();
		neighbors.add(result);
		Queue<Node> seen = new LinkedList<Node>();
		while (!neighbors.isEmpty()) {
			Node node = neighbors.peek();
			System.out.println(node.val);
			for (Node n1 : node.neighbors) {
				if (!neighbors.contains(n1) && !seen.contains(n1)) {
					neighbors.add(n1);
				}
			}
			seen.add(neighbors.poll());
		}
	}
}
