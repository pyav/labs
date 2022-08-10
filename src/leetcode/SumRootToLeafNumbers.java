/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Output:
 * ------
 * 1026
 * 4
 * 10
 */

public class SumRootToLeafNumbers {

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

    private int calcSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        sum = (sum*10)+root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return calcSum(root.left, sum) + calcSum(root.right, sum);
    }

    public int sumNumbers(TreeNode root) {
        return calcSum(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
        TreeNode root2 = new TreeNode(4);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root2));
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(0);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root3));
    }

}

