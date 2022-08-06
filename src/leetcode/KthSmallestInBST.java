/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Output:
 * ------
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 */

public class KthSmallestInBST {

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

    private int ht = 0;
    private int reqVal = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (null == root) {
            return reqVal;
        }
        kthSmallest(root.left, k);
        ht++;
        if (ht == k) {
            reqVal = root.val;
        }
        kthSmallest(root.right, k);
        return reqVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        System.out.println(new KthSmallestInBST().kthSmallest(root, 1));
        System.out.println(new KthSmallestInBST().kthSmallest(root, 2));
        System.out.println(new KthSmallestInBST().kthSmallest(root, 3));
        System.out.println(new KthSmallestInBST().kthSmallest(root, 4));
        System.out.println(new KthSmallestInBST().kthSmallest(root, 5));
        System.out.println(new KthSmallestInBST().kthSmallest(root, 6));
    }

}

