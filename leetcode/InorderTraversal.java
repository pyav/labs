/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Output:
 * ------
 * 1
 * 2
 * 3
 */ 

package leetcode;

import java.util.List;
import java.util.ArrayList;

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

public class InorderTraversal {

    private List<Integer> list = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        List<Integer> list = new InorderTraversal().inorderTraversal(root);
        for (int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

