/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * 
 * Output:
 * ------
 * 18
 * 0
 */

package leetcode;

public class SumOfNodesWithEvenValuedGrandparent {

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

	private int finalSum = 0;

	public int sumEvenGrandparent(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.val % 2 == 0) {
			if (root.left != null) {
				if (root.left.left != null) {
					finalSum += root.left.left.val;
				}
				if (root.left.right != null) {
					finalSum += root.left.right.val;
				}
			}
			if (root.right != null) {
				if (root.right.left != null) {
					finalSum += root.right.left.val;
				}
				if (root.right.right != null) {
					finalSum += root.right.right.val;
				}
			}
		}
		sumEvenGrandparent(root.left);
		sumEvenGrandparent(root.right);
		return finalSum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(7);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(9);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(4);
		System.out.println(new SumOfNodesWithEvenValuedGrandparent().sumEvenGrandparent(root));
		TreeNode root2 = new TreeNode(1);
		System.out.println(new SumOfNodesWithEvenValuedGrandparent().sumEvenGrandparent(root2));
	}

}

