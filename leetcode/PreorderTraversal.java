/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Output:
 * ------
 * 1
 * 2
 * 3
 */

package leetcode;

import java.util.List;
import java.util.ArrayList;

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

public class PreorderTraversal {
    List<Integer> values = new ArrayList<Integer> ();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer> ();
        }
        values.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return values;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        //TreeNode root = new TreeNode(1);

        List<Integer> output = new PreorderTraversal().preorderTraversal(root);
        for (Integer val : output) {
            System.out.println(val);
        }
    }
}

