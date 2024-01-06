/**
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 *
 * Output:
 * ------
 * 1
 * 2
 * 3
 * 4
 */

import java.util.*;

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

public class IncreasingOrderSearch {

    private static LinkedList<Integer> queue = new LinkedList<Integer>();

    private void populateQueue(TreeNode root) {
        if (null == root) {
            return;
        }
        populateQueue(root.left);
        queue.add(root.val);
        populateQueue(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        if (null == root) {
            return root;
        }
        populateQueue(root);
        TreeNode tmp = root;
        while(!queue.isEmpty()) {
            tmp.left = null;
            tmp.val = queue.poll();
            if (queue.isEmpty()) {
                tmp.right = null;
            } else {
                tmp.right = new TreeNode();
            }
            tmp = tmp.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        TreeNode head = new IncreasingOrderSearch().increasingBST(root);
        System.out.println(head.val);
        System.out.println(head.right.val);
        System.out.println(head.right.right.val);
        System.out.println(head.right.right.right.val);
    }

}

