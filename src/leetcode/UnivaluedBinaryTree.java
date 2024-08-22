/**
 * https://leetcode.com/problems/univalued-binary-tree/
 *
 * Output:
 * ------
 * true
 * false
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

public class UnivaluedBinaryTree {
    private boolean result = true;

    public boolean isUnivalTree(TreeNode root) {
        if (null == root) {
            return this.result;
        }
        if (null != root.left) {
            if (root.val != root.left.val) {
                result = false;
            }
        }
        if (null != root.right) {
            if (root.val != root.right.val) {
                result = false;
            }
        }
        if (false == result) {
            return result;
        }
        isUnivalTree(root.left);
        isUnivalTree(root.right);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(0);
        System.out.println(new UnivaluedBinaryTree().isUnivalTree(root2));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        System.out.println(new UnivaluedBinaryTree().isUnivalTree(root));
    }
}

