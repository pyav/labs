/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * 
 * Output:
 * ------
 * 15
 * 19
 * 2
 */

public class DeepestLeavesSum {

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

    int htMax = 1;
    int sum = 0;

    private int findSum(TreeNode root, int ht) {
        if (null == root) {
            return ht;
        }
        if (null == root.left && root.right != null) {
            findSum(root.right, ht + 1);
        }
        if (null == root.right && root.left != null) {
            findSum(root.left, ht + 1);
        }
        if (root.left != null && root.right != null) {
            findSum(root.left, ht + 1);
            findSum(root.right, ht + 1);
        }
        if (ht > htMax) {
            sum = 0;
            htMax = ht;
            sum += root.val;
        } else if (ht == htMax) {
            sum += root.val;
        }

        return sum;
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findSum(root, 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(root));
        TreeNode root2 = new TreeNode(6);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(1);
        root2.right.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(9);
        root2.left.right = new TreeNode(7);
        root2.left.right.left = new TreeNode(1);
        root2.left.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(root2));
        TreeNode root3 = new TreeNode(2);
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(root3));
    }

}

