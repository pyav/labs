/**
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 * 
 * Output:
 * ------
 * 5
 * 1
 */

package leetcode;

import java.util.HashMap;

public class CountNodesEqualToAverageOfSubtree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
	int finalCount = 0;

	private int countNodes(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int count = 1 + countNodes(node.left) + countNodes(node.right);
		map.put(node, count);
		return count;
	}

	private int checkAvgCount(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int sum = node.val + checkAvgCount(node.left) + checkAvgCount(node.right);
		int count = map.get(node);
		if (node.val == sum / count) {
			finalCount++;
		}
		return sum;
	}

	public int averageOfSubtree(TreeNode root) {
		countNodes(root);
		checkAvgCount(root);
		return finalCount;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(8);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println(new CountNodesEqualToAverageOfSubtree().averageOfSubtree(root));
		TreeNode root2 = new TreeNode(1);
		System.out.println(new CountNodesEqualToAverageOfSubtree().averageOfSubtree(root2));
	}

}

