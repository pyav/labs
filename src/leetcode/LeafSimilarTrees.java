/**
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * Output:
 * ------
 * true
 * false
 * false
 */

import java.util.ArrayList;
import java.util.List;

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

public class LeafSimilarTrees {

    private List<Integer> getLeafNums(TreeNode root, List<Integer> list) {
        if (null == root) {
            return list;
        }
        getLeafNums(root.left, list);
        if (null == root.left && null == root.right) {
            list.add(root.val);
        }
        getLeafNums(root.right, list);
        return list;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstLeafNums = getLeafNums(root1, new ArrayList<Integer>());
        List<Integer> secondLeafNums = getLeafNums(root2, new ArrayList<Integer>());

        if (firstLeafNums.size() != secondLeafNums.size()) {
            return false;
        }
        while(!firstLeafNums.isEmpty() && !secondLeafNums.isEmpty()) {
            int first = firstLeafNums.remove(0); 
            int second = secondLeafNums.remove(0); 
            if (first != second) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        System.out.println(new LeafSimilarTrees().leafSimilar(root1, root2));
        TreeNode root11 = new TreeNode(3);
        root11.left = new TreeNode(2);
        root11.right = new TreeNode(1);
        TreeNode root22 = new TreeNode(3);
        root22.left = new TreeNode(5);
        root22.right = new TreeNode(1);
        System.out.println(new LeafSimilarTrees().leafSimilar(root11, root22));
        TreeNode root111 = new TreeNode(18);
        root111.left = new TreeNode(35);
        root111.right = new TreeNode(22);
        root111.left.right = new TreeNode(103);
        root111.left.right.left = new TreeNode(58);
        root111.right.left = new TreeNode(43);
        root111.right.left.left = new TreeNode(97);
        root111.right.right = new TreeNode(101);
        TreeNode root222 = new TreeNode(94);
        root222.left = new TreeNode(102);
        root222.right = new TreeNode(17);
        root222.left.left = new TreeNode(122);
        root222.left.left.left = new TreeNode(58);
        root222.left.left.right = new TreeNode(101);
        root222.right.right = new TreeNode(54);
        root222.right.right.left = new TreeNode(97);
        System.out.println(new LeafSimilarTrees().leafSimilar(root111, root222));
    }
}

