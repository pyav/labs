/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Output:
 * ------
 * 3
 * 2
 * 1
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

public class PostorderTraversal {
    List<Integer> values = new ArrayList<Integer> ();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer> ();
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        values.add(root.val);
        return values;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        //TreeNode root = new TreeNode(1);
        //TreeNode root = new TreeNode();

        List<Integer> output = new PostorderTraversal().postorderTraversal(root);
        for (Integer val : output) {
            System.out.println(val);
        }

    }
}

