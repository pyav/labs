/**
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 * 
 * Output:
 * ------
 * 5
 * 1
 */

package leetcode;

public class CountNodesEqualToAverageOfSubtree2 {

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

	int finalCount = 0;

	public int averageOfSubtree(TreeNode root) {
		countAverage(root);
		return finalCount;
	}

	private int[] countAverage(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 }; // sum, count
		}
		int[] a = countAverage(root.left);
		int[] b = countAverage(root.right);
		int sum = root.val + a[0] + b[0];
		int count = 1 + a[1] + b[1];
		if (sum / count == root.val) {
			finalCount++;
		}
		return new int[] { sum, count };
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(8);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println(new CountNodesEqualToAverageOfSubtree2().averageOfSubtree(root));
		TreeNode root2 = new TreeNode(1);
		System.out.println(new CountNodesEqualToAverageOfSubtree2().averageOfSubtree(root2));
	}

}

