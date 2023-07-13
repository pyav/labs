/**
 * https://leetcode.com/problems/count-complete-tree-nodes/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Output:
 * ------
 * 6
 * 0
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

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new CountCompleteTreeNodes().countNodes(root));
        TreeNode root2 = null;
        System.out.println(new CountCompleteTreeNodes().countNodes(root2));
        TreeNode root3 = new TreeNode(1);
        System.out.println(new CountCompleteTreeNodes().countNodes(root3));
    }

}

