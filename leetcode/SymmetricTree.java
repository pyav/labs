/**
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * 
 * Output:
 * ------
 * 1
 * 2
 * 3
 * 4
 * 2
 * 4
 * 3
 * [2, 3, null, null, 4, null, null]
 * [2, 3, null, null, 4, null, null]
 * true
 */

package leetcode;

import java.util.ArrayList;

class TreeNode {

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

public class SymmetricTree {

	ArrayList<Integer> leftTreeAsArray = new ArrayList<Integer>();
	ArrayList<Integer> rightTreeAsArray = new ArrayList<Integer>();

	public boolean isSymmetric(TreeNode root) {
		if (root != null) {
			leftTreeAsArray = getLeftOrderTreeAsArray(root.left);
			rightTreeAsArray = getRightOrderTreeAsArray(root.right);
			System.out.println(leftTreeAsArray.toString());
			System.out.println(rightTreeAsArray.toString());
			return leftTreeAsArray.equals(rightTreeAsArray);
		}
		return true;
	}

	private ArrayList<Integer> getRightOrderTreeAsArray(TreeNode root) {
		if (root == null) {
			rightTreeAsArray.add(null);
			return rightTreeAsArray;
		}
		rightTreeAsArray.add(root.val);
		getRightOrderTreeAsArray(root.right);
		getRightOrderTreeAsArray(root.left);
		return rightTreeAsArray;
	}

	private ArrayList<Integer> getLeftOrderTreeAsArray(TreeNode root) {
		if (root == null) {
			leftTreeAsArray.add(null);
			return leftTreeAsArray;
		}
		leftTreeAsArray.add(root.val);
		getLeftOrderTreeAsArray(root.left);
		getLeftOrderTreeAsArray(root.right);
		return leftTreeAsArray;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(), new TreeNode());
		root.left = new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null));
		// root.left = new TreeNode(2, null, new TreeNode(3, null, null));
		root.right = new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null));
		// root.right = new TreeNode(2, null, new TreeNode(3, null, null));
		printTree(root);
		System.out.println(new SymmetricTree().isSymmetric(root));
	}

	private static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		printTree(root.left);
		printTree(root.right);

	}

}
