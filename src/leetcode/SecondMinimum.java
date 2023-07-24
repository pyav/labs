/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 *
 * Output:
 * ------
 * 5
 * -1
 * 6
 * 2147483647
 * -1
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

public class SecondMinimum {
    
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    boolean foundHighest = false;

    private int calcFindSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return second;
        }

        if (root.val == Integer.MAX_VALUE) {
            foundHighest = true;
        }

        if (root.val < first) {
            second = first;
            first = root.val;
        } else if (root.val < second && root.val != first) {
            second = root.val;
        }

        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);
        return second;
    }

    public int findSecondMinimumValue(TreeNode root) {
        calcFindSecondMinimumValue(root);
        return (second == Integer.MAX_VALUE)? ((foundHighest == true && first != Integer.MAX_VALUE)? second: -1): second;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(new SecondMinimum().findSecondMinimumValue(root));
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(new SecondMinimum().findSecondMinimumValue(root2));
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(6);
        System.out.println(new SecondMinimum().findSecondMinimumValue(root3));
        TreeNode root4 = new TreeNode(2);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(2147483647);
        System.out.println(new SecondMinimum().findSecondMinimumValue(root4));
        TreeNode root5 = new TreeNode(2147483647);
        root5.left = new TreeNode(2147483647);
        root5.right = new TreeNode(2147483647);
        System.out.println(new SecondMinimum().findSecondMinimumValue(root5));
    }

}

