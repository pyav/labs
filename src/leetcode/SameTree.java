/**
 * https://leetcode.com/problems/same-tree/
 *
 * Output:
 * ------
 * false
 */

package leetcode;

import java.util.Stack;

public class SameTree {

    static public class TreeNode {
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

    private void addPreOrder(Stack<Integer> stack, TreeNode node) {
        if (null == node) {
            stack.add(10001);
            return;
        }
        stack.add(node.val);
        addPreOrder(stack, node.left);
        addPreOrder(stack, node.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<Integer> first = new Stack<Integer>();
        Stack<Integer> second = new Stack<Integer>();
        addPreOrder(first, p);
        addPreOrder(second, q);
        while(!first.isEmpty() && !second.isEmpty()) {
            int a = first.pop();
            int b = second.pop();
            if (a != b) {
                return false;
            }
        }
        if (!first.isEmpty() || !second.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        //root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(new SameTree().isSameTree(root, root2));
    }

}

