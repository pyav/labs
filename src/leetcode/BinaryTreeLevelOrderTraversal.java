/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Output:
 * ------
 * 3 
 * 9 20 
 * 15 7 
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class BinaryTreeLevelOrderTraversal {

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
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    int maxHt = 0;

    private void addListLevelWise(TreeNode node, int ht) {
        if (null == node) {
            return;
        }
        if (ht > maxHt) {
            maxHt = ht;
        }
        List<Integer> list;
        if (map.containsKey(ht)) {
            list = map.get(ht);
        } else {
            list = new ArrayList<Integer>();
        }
        list.add(node.val);
        map.put(ht, list);
        addListLevelWise(node.left, ht+1);
        addListLevelWise(node.right, ht+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<List<Integer>>();
        }
        addListLevelWise(root, 0);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= maxHt; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        Iterator<List<Integer>> itr = result.iterator();
        while(itr.hasNext()) {
            List<Integer> list = itr.next();
            Iterator<Integer> item = list.iterator();
            while(item.hasNext()) {
                System.out.printf("%d ", item.next());
            }
            System.out.println();
        }
    }

}
