/**
 * https://leetcode.com/problems/root-equals-sum-of-children/
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

public class RootEqualsSumOfChildren {

    public boolean checkTree(TreeNode root) {
        return (root.val == (root.left.val + root.right.val))? true: false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        System.out.println(new RootEqualsSumOfChildren().checkTree(root));
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(1);
        System.out.println(new RootEqualsSumOfChildren().checkTree(root2));
    }

}

