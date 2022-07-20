/**
 * Demonstation of bottom view of a binary tree
 * 
 * Output:
 * ------
 * 5 6 4 7
 */

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class BinaryTreeBottomView {

	static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	private Map<Integer, Integer> map;

	public BinaryTreeBottomView() {
		this.map = new HashMap<Integer, Integer>();
	}

	private void calcBottomViewElems(Node node, int currDist) {
		if (null == node) {
			return;
		}
		this.map.put(currDist, node.val);
		calcBottomViewElems(node.left, currDist-1);
		calcBottomViewElems(node.right, currDist+1);
	}

	public int[] bottomView(Node node, int currDist) {
		calcBottomViewElems(node, currDist);
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
		BinaryTreeBottomView obj = new BinaryTreeBottomView();
		int[] bottomElems = obj.bottomView(root, 0);

		for (int i = 0; i < bottomElems.length; i++) {
			System.out.printf("%d ", bottomElems[i]);
		}
        System.out.println();
	}

}

