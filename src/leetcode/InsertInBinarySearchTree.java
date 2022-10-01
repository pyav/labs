/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Output:
 * ------
 * 4
 * 2
 * 1
 * 3
 * 7
 * 5
 */

public class InsertInBinarySearchTree {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            if (null == root.right) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST(root.right, val);
            }
        } else {
            if (null == root.left) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST(root.left, val);
            }
        }
        return root;
    }

    private static void printTree(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        new InsertInBinarySearchTree().insertIntoBST(root, 5);
        printTree(root);
    }

}

