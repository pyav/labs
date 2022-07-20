/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 *
 * Output:
 * ------
 * 6
 */

package leetcode;

public class BottomLeftTreeValue {

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

    private int leftmostVal;
    private int maxHt = Integer.MIN_VALUE;

    private int calcLeftmostValue(TreeNode node, int ht) {
        if (null == node) {
            return ht;
        }
        if (ht > maxHt) {
            leftmostVal = node.val;
            maxHt = ht;
        }
        calcLeftmostValue(node.left, ht+1);
        calcLeftmostValue(node.right, ht+1);

        return leftmostVal;
    }

    public int findBottomLeftValue(TreeNode root) {
        return calcLeftmostValue(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        System.out.println(new BottomLeftTreeValue().findBottomLeftValue(root));
    }

}

