/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Output:
 * ------
 * 2
 * 0
 * 5
 */

public class MinimumDepthOfBinaryTree {

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

    private int minHt = Integer.MAX_VALUE;
    private int getMinDepth(TreeNode root, int ht) {
        if (null == root) {
            return 0;
        }
        if (root.left == null && root.right == null && ht < minHt) {
            minHt = ht;
        }
        getMinDepth(root.left, ht+1);
        getMinDepth(root.right, ht+1);
        return minHt;
    }

    public int minDepth(TreeNode root) {
        getMinDepth(root, 1);
        if (minHt == Integer.MAX_VALUE) {
            return 0;
        }
        return minHt;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root));
        TreeNode root2 = null;
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root2));
        TreeNode root3 = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.right.right = new TreeNode(4);
        root3.right.right.right = new TreeNode(5);
        root3.right.right.right.right = new TreeNode(6);
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root3));
    }

}

