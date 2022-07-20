/**
 * https://leetcode.com/problems/same-tree/
 *
 * Output:
 * ------
 * false
 */

package leetcode;

import java.util.Stack;

public class SameTree2 {

    static public class TreeNode {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        return ((p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        //root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(new SameTree2().isSameTree(root, root2));
    }

}

