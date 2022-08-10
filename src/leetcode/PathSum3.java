/**
 * https://leetcode.com/problems/path-sum-iii/
 *
 * Output:
 * ------
 * 3
 * 3
 * 2
 * 4
 * 0
 */

import java.util.HashSet;
import java.util.Set;

public class PathSum3 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int count = 0;
    Set<TreeNode> set = new HashSet<TreeNode>();

    private int calcSum(TreeNode root, int targetSum, long sum, boolean isPath) {
        if (null == root) {
            return 0;
        }
        if (!isPath && set.contains(root)) {
            return count;
        }
        if (!isPath && !set.contains(root)) {
            set.add(root);
        }
        sum += root.val;
        if (sum == targetSum) {
            count++;
        }
        calcSum(root.left, targetSum, sum, true);
        calcSum(root.left, targetSum, 0, false);
        calcSum(root.right, targetSum, sum, true);
        calcSum(root.right, targetSum, 0, false);
        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        return calcSum(root, targetSum, 0, false);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        System.out.println(new PathSum3().pathSum(root, 8));
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(11);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(1);
        System.out.println(new PathSum3().pathSum(root2, 22));
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        root3.right.right.right = new TreeNode(4);
        root3.right.right.right.right = new TreeNode(5);
        System.out.println(new PathSum3().pathSum(root3, 3));
        TreeNode root4 = new TreeNode(0);
        root4.left = new TreeNode(1);
        root4.right = new TreeNode(1);
        System.out.println(new PathSum3().pathSum(root4, 1));
        TreeNode root5 = new TreeNode(1000000000);
        root5.left = new TreeNode(1000000000);
        root5.left.left = new TreeNode(294967296);
        root5.left.left.left = new TreeNode(1000000000);
        root5.left.left.left.left = new TreeNode(1000000000);
        root5.left.left.left.left.left = new TreeNode(1000000000);
        System.out.println(new PathSum3().pathSum(root5, 0));
    }

}

