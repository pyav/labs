/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * 
 * Output:
 * ------
 * 1
 * 2
 * 4
 * null
 * null
 * null
 * 3
 * null
 * null
 * false
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

public class CousinsInBinaryTree {

    private boolean isFirst = false;
    private boolean isSecond = false;

    TreeNode parentOfX = new TreeNode();
    TreeNode parentOfY = new TreeNode();

    private int getHeight(TreeNode root, int x, int height) {
        if (root == null) {
            return 0;
        }
        if (root.val == x) {
            return height;
        }

        int result = getHeight(root.left, x, height + 1);
        if (result != 0) {
            if (isFirst) {
                isFirst = false;
                parentOfX = root;
            }
            if (isSecond) {
                isSecond = false;
                parentOfY = root;
            }

            return result;
        }

        result = getHeight(root.right, x, height + 1);
        if (result != 0) {
            if (isFirst) {
                isFirst = false;
                parentOfX = root;
            }
            if (isSecond) {
                isSecond = false;
                parentOfY = root;
            }

        }

        return result;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        isFirst = true;
        int heightOfX = getHeight(root, x, 1);
        isSecond = true;
        int heightOfY = getHeight(root, y, 1);
        return ((heightOfX == heightOfY) && (parentOfX != parentOfY));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        //root.left = new TreeNode(2, null, new TreeNode(4, null, null));
        root.left = new TreeNode(2, new TreeNode(4, null, null), null);
        //root.right = new TreeNode(3, null, new TreeNode(5, null, null));
        root.right = new TreeNode(3, null, null);
        printTree(root);
        //System.out.println(new CousinsInBinaryTree().isCousins(root, 5, 4));
        System.out.println(new CousinsInBinaryTree().isCousins(root, 4, 3));
        //System.out.println(new CousinsInBinaryTree().isCousins(root, 2, 3));
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

}

