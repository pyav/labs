/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Output:
 * ------
 * 1
 * 3
 * 4
 */

import java.util.*;

public class BinaryTreeRightSideView {
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

    private void calcRightView(TreeNode node, int ht,
            Map<Integer, Integer> rightViewMap, List<Integer> rightViewList) {
        if (null == node) {
            return;
        }

        rightViewMap.put(ht, node.val);

        calcRightView(node.left, ht+1, rightViewMap, rightViewList);
        calcRightView(node.right, ht+1, rightViewMap, rightViewList);
    }

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightViewMap = new HashMap<Integer, Integer>();
        List<Integer> rightViewList = new ArrayList<Integer>();
        calcRightView(root, 0, rightViewMap, rightViewList);
        for (Integer key : rightViewMap.keySet()) {
            rightViewList.add(rightViewMap.get(key));
        }
        return rightViewList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> result = new BinaryTreeRightSideView().rightSideView(root);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

}

