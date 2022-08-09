/**
 * https://leetcode.com/problems/path-sum/
 *
 * Output:
 * ------
 * true
 * false
 * false
 * false
 */


public class PathSum {

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

    private boolean checkSumExists(TreeNode root, int sum, int targetSum) {
        if (null == root) {
            return false;
        }
        if ((sum = sum + root.val) == targetSum && root.left == null &&
            root.right == null) {
            return true;
        }
        return checkSumExists(root.left, sum, targetSum) ||
                checkSumExists(root.right, sum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkSumExists(root, 0, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(new PathSum().hasPathSum(root, 22));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(new PathSum().hasPathSum(root2, 5));
        TreeNode root3 = null;
        System.out.println(new PathSum().hasPathSum(root3, 0));
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        System.out.println(new PathSum().hasPathSum(root4, 1));
    }

}

