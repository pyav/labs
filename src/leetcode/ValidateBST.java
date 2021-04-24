/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Output:
 * ------
 * True
 * False
 * True
 * True
 * False
 * False
 * False
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

public class ValidateBST {
    private boolean isRightSubTreeBST(int topRootVal, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (topRootVal >= root.val) {
            return false;
        }
        if (!isRightSubTreeBST(topRootVal, root.right) || !isRightSubTreeBST(topRootVal, root.left)) {
            return false;
        }

        return true;
    }

    private boolean isLeftSubTreeBST(int topRootVal, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (topRootVal <= root.val) {
            return false;
        }
        if (!isLeftSubTreeBST(topRootVal, root.left) || !isLeftSubTreeBST(topRootVal, root.right)) {
            return false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (!isRightSubTreeBST(root.val, root.right) || !isLeftSubTreeBST(root.val, root.left)) {
            return false;
        }
        if (!isValidBST(root.left) || !isValidBST(root.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBST sol = new ValidateBST();
        if (sol.isValidBST(root)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        if (sol.isValidBST(root2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        if (sol.isValidBST(null)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(-1);

        if (sol.isValidBST(root3)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(5);
        root4.right = new TreeNode(15);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(20);

        if (sol.isValidBST(root4)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        TreeNode root5 = new TreeNode(3);
        root5.right = new TreeNode(30);
        root5.right.left = new TreeNode(10);
        root5.right.left.right = new TreeNode(15);
        root5.right.left.right.right = new TreeNode(45);

        if (sol.isValidBST(root5)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        TreeNode root6 = new TreeNode(10);
        root6.left = new TreeNode(5);
        root6.right = new TreeNode(15);
        root6.right.left = new TreeNode(6);
        root6.right.right = new TreeNode(20);

        if (sol.isValidBST(root6)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

}

