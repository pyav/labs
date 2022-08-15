/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Output:
 * ------
 * true
 * false
 * true
 */

public class BalancedBinaryTree {

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

    private boolean balanced = true;

    private int calcHtDiff(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        int leftHt = 1 + calcHtDiff(root.left);
        int rightHt = 1 + calcHtDiff(root.right);
        if (Math.abs(leftHt - rightHt) > 1) {
            balanced = false;
        }
        return (leftHt > rightHt)? leftHt: rightHt;
    }

    public boolean isBalanced(TreeNode root) {
        calcHtDiff(root);
        return balanced;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BalancedBinaryTree().isBalanced(root));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println(new BalancedBinaryTree().isBalanced(root2));
        TreeNode root3 = null;
        System.out.println(new BalancedBinaryTree().isBalanced(root3));
    }

}

