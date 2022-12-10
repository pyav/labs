/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 *
 * Output:
 * ------
 * 1
 * 1
 */

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

public class MinDistanceBST {

    private int minDist = Integer.MAX_VALUE;
    
    private int getHighestOfLeftSubtree(TreeNode root) {
        if (null == root.left) {
            return root.val;
        }
        TreeNode node = root.left;
        while(node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    private int getLowestOfRightSubtree(TreeNode root) {
        if (null == root.right) {
            return root.val;
        }
        TreeNode node = root.right;
        while(node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public int minDiffInBST(TreeNode root) {
        if (null == root) {
            return minDist;
        }
        if (root.left != null && minDist > Math.abs(root.val - root.left.val)) {
            minDist = Math.abs(root.val - root.left.val);
        }
        if (root.right != null && minDist > Math.abs(root.val - root.right.val)) {
            minDist = Math.abs(root.val - root.right.val);
        }
        int highestOfLeftSubtree = getHighestOfLeftSubtree(root);
        int lowestOfRightSubtree = getLowestOfRightSubtree(root);
        if ((root.val != highestOfLeftSubtree) && minDist > Math.abs(root.val - highestOfLeftSubtree)) {
            minDist = Math.abs(root.val - highestOfLeftSubtree);
        }
        if ((root.val != lowestOfRightSubtree) && minDist > Math.abs(root.val - lowestOfRightSubtree)) {
            minDist = Math.abs(root.val - lowestOfRightSubtree);
        }
        minDiffInBST(root.left);
        minDiffInBST(root.right);
        return minDist;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(new MinDistanceBST().minDiffInBST(root));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(48);
        root2.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);
        System.out.println(new MinDistanceBST().minDiffInBST(root2));
    }

}

