/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Output:
 * ------
 * 9
 */

import java.util.*;

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

public class ConstructBinaryTree {
    private int preOrderIdx;

    private TreeNode calcBuildTree(Map<Integer, Integer> map, int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preOrderIdx++];
        TreeNode root = new TreeNode(rootVal);
        int position = map.get(rootVal);
        root.left = calcBuildTree(map, preorder, inorder, left, position-1);
        root.right = calcBuildTree(map, preorder, inorder, position+1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        preOrderIdx = 0;

        return calcBuildTree(map, preorder, inorder, 0, inorder.length-1);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode head = new ConstructBinaryTree().buildTree(preorder, inorder);
        System.out.println(head.left.val);
    }
}

