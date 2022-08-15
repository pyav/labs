/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 *
 * Output:
 * ------
 * 1
 * 3
 * 9
 * 1
 * 3
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class LargestInRow {

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

    private Map<Integer, Integer> maxMap = new HashMap<Integer, Integer>();
    private List<Integer> result = new ArrayList<Integer>();

    private void calcLargestHtWise(TreeNode root, int ht) {
        if (null == root) {
            return;
        }
        if (!maxMap.containsKey(ht)) {
            maxMap.put(ht, root.val);
        } else {
            int existingVal = maxMap.get(ht);
            if (root.val > existingVal) {
                maxMap.put(ht, root.val);
            }
        }
        calcLargestHtWise(root.left, ht+1);
        calcLargestHtWise(root.right, ht+1);
    }
 
    public List<Integer> largestValues(TreeNode root) {
        calcLargestHtWise(root, 0); 
        if (maxMap.size() == 0) {
            return result;
        }
        for (Integer key : maxMap.keySet()) {
            result.add(maxMap.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        List<Integer> result = new LargestInRow().largestValues(root);
        for (Integer val : result) {
            System.out.println(val);
        }
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        List<Integer> result2 = new LargestInRow().largestValues(root2);
        for (Integer val : result2) {
            System.out.println(val);
        }
    }

}

