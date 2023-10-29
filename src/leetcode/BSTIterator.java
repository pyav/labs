/**
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * Output:
 * ------
 * 3
 * 7
 * true
 * 9
 * true
 * 15
 * true
 * 20
 * false
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

public class BSTIterator {
    private List<Integer> list;
    private int idx;

    private void initList(TreeNode root) {
        if (null == root) {
            return;
        }
        initList(root.left);
        list.add(root.val);
        initList(root.right);
    }
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        initList(root);
        idx = -1;
    }

    public int next() {
        return list.get(++idx);
    }

    public boolean hasNext() {
        return (idx+1) < list.size()? true: false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
    }
}
