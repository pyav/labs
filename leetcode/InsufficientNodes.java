/**
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 *
 * Output:
 * ------
 * 1
 */

package leetcode;

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

public class InsufficientNodes {
    private boolean isLess = false;
    private TreeNode calculateSumInNode(TreeNode root, int limit, int sum) {
        if (root == null) {
            return null;
        }

        sum += root.val;
        root.left = calculateSumInNode(root.left, limit, sum);

        if (isLess && root.left == null && root.right == null) {
            return null;
        }
        isLess = false;
        root.right = calculateSumInNode(root.right, limit, sum);

        if (sum < limit) {
            isLess = true;
        }
        if (isLess && root.right == null && root.left == null) {
            return null;
        }
        
        return root;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return calculateSumInNode(root, limit, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(-5);
        root.right.left = new TreeNode(4);

        System.out.println(new InsufficientNodes().sufficientSubset(root, -1).val);
    }

}

