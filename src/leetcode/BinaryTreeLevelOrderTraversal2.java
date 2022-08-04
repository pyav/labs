/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Output:
 * ------
 * 3 
 * 9 20 
 * 15 7 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {

	static class TreeNode2 {
		int val;
		TreeNode2 left;
		TreeNode2 right;
		TreeNode2() {}
		TreeNode2(int val) {	this.val = val; }
		TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private List<List<Integer>> addListLevelWise(TreeNode2 node, List<List<Integer>> list, int ht) {
		if (null == node) {
			return list;
		}
		if (list.size() < ht) {
			list.add(new ArrayList<Integer>()); 
		}
		List<Integer> tmpLst = list.get(ht-1);
		tmpLst.add(node.val);
		list.remove(ht-1);
		list.add(ht-1, tmpLst);
        addListLevelWise(node.left, list, ht+1);
        addListLevelWise(node.right, list, ht+1);
        return list;
    }
	
	public List<List<Integer>> levelOrder(TreeNode2 root) {
		return addListLevelWise(root, new ArrayList<List<Integer>>(), 1);
	}

	public static void main(String[] args) {
		TreeNode2 root = new TreeNode2(3);
		root.left = new TreeNode2(9);
		root.right = new TreeNode2(20);
		root.right.left = new TreeNode2(15);
		root.right.right = new TreeNode2(7);
		List<List<Integer>> result = new BinaryTreeLevelOrderTraversal2().levelOrder(root);
		Iterator<List<Integer>> itr = result.iterator();
		while (itr.hasNext()) {
			List<Integer> list = itr.next();
			Iterator<Integer> item = list.iterator();
			while (item.hasNext()) {
				System.out.printf("%d ", item.next());
			}
			System.out.println();
		}
	}

}
