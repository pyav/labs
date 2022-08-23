/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Output:
 * ------
 * 3 
 * 20 9 
 * 33 22 15 7 
 */

import java.util.List;
import java.util.ArrayList;

public class BinaryTreeZigzag {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<TreeNode> queue1 = new ArrayList<TreeNode>();
        queue1.add(root);
        List<TreeNode> tmpList = new ArrayList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        while (true) {
            if (queue1.isEmpty()) {
                break;
            }
            List<Integer> q1List = new ArrayList<Integer>();
            for (int i = 0; i < queue1.size(); i++) {
            	q1List.add(queue1.get(i).val);
            }
            if (q1List.size() > 0) {
                result.add(q1List);
            }
            while (!queue1.isEmpty()) {
                TreeNode tmp = queue1.remove(queue1.size() - 1);
                if (tmp.right != null) {
                    tmpList.add(new TreeNode(tmp.right.val, tmp.right.left, tmp.right.right));
                }
                if (tmp.left != null) {
                    tmpList.add(new TreeNode(tmp.left.val, tmp.left.left, tmp.left.right));
                }
            }
            List<Integer> q2List = new ArrayList<Integer>();
            for (int i = 0; i < tmpList.size(); i++) {
            	q2List.add(tmpList.get(i).val);
        	}
            if (q2List.size() > 0) {
            	result.add(q2List);
            }
            while (!tmpList.isEmpty()) {
                TreeNode tmp2 = tmpList.remove(tmpList.size()-1);
                if (tmp2.left != null) {
                    queue1.add(new TreeNode(tmp2.left.val, tmp2.left.left, tmp2.left.right));
                }
                if (tmp2.right != null) {
                    queue1.add(new TreeNode(tmp2.right.val, tmp2.right.left, tmp2.right.right));
                }
            }
            
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.right = new TreeNode(22);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(33);
        List<List<Integer>> result = new BinaryTreeZigzag().zigzagLevelOrder(root);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }

}

