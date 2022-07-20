/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Output:
 * ------
 * 3
 */

package leetcode;

public class MaxDepthBinaryTree {

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

    private int maxHt = 0;

    private int calcMaxHt(TreeNode node, int ht) {
        if (null == node) {
            return 0;
        }
        if (ht > maxHt) {
            maxHt = ht;
        }
        calcMaxHt(node.left, ht+1);
        calcMaxHt(node.right, ht+1);
        return maxHt;
    }

    public int maxDepth(TreeNode root) {
        return calcMaxHt(root, 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(new MaxDepthBinaryTree().maxDepth(root));
    }

}

