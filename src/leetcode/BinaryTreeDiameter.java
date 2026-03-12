/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description
 * 
 * Output:
 * ------
 * 3
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

public class BinaryTreeDiameter {
	
	private int diameter = 0;
	
	private int calcHeight(TreeNode root) {
		if (null == root) {
			return 0;
		}
		
		int left = calcHeight(root.left);
		int right = calcHeight(root.right);
		
		diameter = Math.max(diameter, right + left);
		
		return 1 + Math.max(left, right);
	}

	public int diameterOfBinaryTree(TreeNode root) {
		calcHeight(root);
		return diameter;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(new BinaryTreeDiameter().diameterOfBinaryTree(root));
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		System.out.println(new BinaryTreeDiameter().diameterOfBinaryTree(root2));
	}

}
