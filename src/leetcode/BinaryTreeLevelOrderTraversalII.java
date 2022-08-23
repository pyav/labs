/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Output:
 * ------
 * 15 7 
 * 9 20 
 * 3
 */

import java.util.List;
import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversalII {

    static class TreeNode {
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

	private List<List<Integer>> addListLevelWise(TreeNode node, List<List<Integer>> list, int ht) {
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
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = addListLevelWise(root, new ArrayList<List<Integer>>(), 1);
        for (int i = 0; i < result.size() - 1; i++) {
            List<Integer> tmp = result.get(result.size()-1);
            result.remove(result.size()-1);
            result.add(i, tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = new BinaryTreeLevelOrderTraversalII().levelOrderBottom(root);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }

}

