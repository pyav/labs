/**
 * Demonstation of top view of a binary tree
 * 
 * Output:
 * ------
 * 1 2 4 3 
 */

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class BinaryTreeTopView {

	static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	private Map<Integer, Integer> map;
    private int maxHt = Integer.MIN_VALUE;

	public BinaryTreeTopView() {
		this.map = new HashMap<Integer, Integer>();
	}

	private void calcTopViewElems(Node node, int currDist) {
		if (null == node) {
			return;
		}
        if (!map.containsKey(currDist)) {
		    this.map.put(currDist, node.val);
        }
		calcTopViewElems(node.left, currDist-1);
		calcTopViewElems(node.right, currDist+1);
	}

	public int[] topView(Node node, int currDist) {
		calcTopViewElems(node, currDist);
		int[] arr = new int[this.map.size()];
		int i = 0;

		for (Entry<Integer, Integer> entry : this.map.entrySet()) {
			arr[i] = entry.getValue();
			i++;
		}
		return arr;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(5);
		root.right.left.right = new Node(7);
		root.left.left = new Node(4);
		root.left.left.right = new Node(6);
		BinaryTreeTopView obj = new BinaryTreeTopView();
		int[] topElems = obj.topView(root, 0);

		for (int i = 0; i < topElems.length; i++) {
			System.out.printf("%d ", topElems[i]);
		}
        System.out.println();
	}

}

