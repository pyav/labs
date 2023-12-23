/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-interview-150
 *
 * Output:
 * ------
 * 1 2 3 4 9 10 5 6 7 8 
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

public class FlattenTree {

    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        flatten(root.left);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode itr = root;
        while(itr.right != null) {
            itr = itr.right;
        }
        itr.right = tmp;
        flatten(itr.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        new FlattenTree().flatten(root);
        TreeNode tmp = root;
        while(tmp != null){
            System.out.printf("%d ", tmp.val);
            tmp = tmp.right;
        }
        System.out.println();
    }
}

