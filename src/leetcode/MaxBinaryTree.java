/**
 * https://leetcode.com/problems/maximum-binary-tree/
 *
 * Output:
 * ------
 * 6 3 2 1 5 0
 */

public class MaxBinaryTree {

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

    private int getMaxIdx(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int maxIdx = left;
        int max = nums[left];
        for (int i = left+1; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private TreeNode constructTreeFromArray(int[] nums, int i, int j) {
        int maxIdx = getMaxIdx(nums, i, j);
        if (-1 == maxIdx) {
            return null;
        }
        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = constructTreeFromArray(nums, i, maxIdx-1);
        node.right = constructTreeFromArray(nums, maxIdx+1, j);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTreeFromArray(nums, 0, nums.length-1);
    }

    static private void printTree(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.printf("%d ", root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = new MaxBinaryTree().constructMaximumBinaryTree(nums);
        printTree(root);
        System.out.println();
    }

}

