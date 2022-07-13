/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 * Output:
 * ------
 * 30 36 36 35 33 21 26 15 8 
 * 1 1 
 */

package leetcode;

public class BinarySearchTreeToGreaterSumTree {

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

	private int lastVal = 0;

	private void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.printf("%d ", root.val);
		printTree(root.left);
		printTree(root.right);
	}

	public TreeNode bstToGst(TreeNode root) {
		if (root == null) {
			return null;
		}
		bstToGst(root.right);
		lastVal = root.val + lastVal;
		root.val = lastVal;
		bstToGst(root.left);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		BinarySearchTreeToGreaterSumTree obj = new BinarySearchTreeToGreaterSumTree();
		obj.bstToGst(root);
		obj.printTree(root);
		System.out.println();
		TreeNode root2 = new TreeNode(0);
		root2.right = new TreeNode(1);
		BinarySearchTreeToGreaterSumTree obj2 = new BinarySearchTreeToGreaterSumTree();
		obj2.bstToGst(root2);
		obj2.printTree(root2);
	}

}

