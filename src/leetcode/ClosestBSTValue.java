/**
 * https://leetcode.com/problems/closest-binary-search-tree-value
 * 
 * Output:
 * ------
 * 4
 * 1
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {}

	TreeNode(int val) { this.val = val; }

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class ClosestBSTValue {
	private double diff = Double.MAX_VALUE;
	private int val = Integer.MAX_VALUE;

	public int closestValue(TreeNode root, double target) {
		if (root == null) {
			return val;
		}
		
		if (Math.abs(root.val - target) < diff) {
			diff = Math.abs(root.val - target);
			val = root.val;
		} else if (Math.abs(root.val - target) == diff) {
			if (root.val < val) {
				val = root.val;
			}
		}
		closestValue(root.left, target);
		closestValue(root.right, target);
		return val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(new ClosestBSTValue().closestValue(root, 3.714286));
		
		TreeNode root2 = new TreeNode(1);
		System.out.println(new ClosestBSTValue().closestValue(root2, 4.428571));
	}

}
