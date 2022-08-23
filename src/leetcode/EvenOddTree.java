/**
 * https://leetcode.com/problems/even-odd-tree/
 *
 * Output:
 * ------
 * true
 * false
 * false
 * true
 */

import java.util.List;
import java.util.ArrayList;

public class EvenOddTree {

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

    public boolean isEvenOddTree(TreeNode root) {
        List<TreeNode> queue1 = new ArrayList<TreeNode>();
        queue1.add(root);
        List<TreeNode> tmpList = new ArrayList<TreeNode>();

        while (true) {
            if (queue1.isEmpty()) {
                break;
            }
            List<Integer> q1List = new ArrayList<Integer>();
            for (int i = 0; i < queue1.size()-1; i++) {
            	if ((queue1.get(i).val >= queue1.get(i+1).val) || (queue1.get(i).val%2 != 1)) {
                    return false;
                };
            }
            if (queue1.get(queue1.size()-1).val%2 != 1) {
                return false;
            }
            while (!queue1.isEmpty()) {
                TreeNode tmp = queue1.remove(0);
                if (tmp.left != null) {
                    tmpList.add(new TreeNode(tmp.left.val, tmp.left.left, tmp.left.right));
                }
                if (tmp.right != null) {
                    tmpList.add(new TreeNode(tmp.right.val, tmp.right.left, tmp.right.right));
                }
            }
            List<Integer> q2List = new ArrayList<Integer>();
            for (int i = 0; i < tmpList.size()-1; i++) {
            	if ((tmpList.get(i).val <= tmpList.get(i+1).val) || (tmpList.get(i).val%2 != 0)) {
                    return false;
                };
        	}
            if (tmpList.size() > 0 && tmpList.get(tmpList.size()-1).val%2 != 0) {
                return false;
            }
            while (!tmpList.isEmpty()) {
                TreeNode tmp2 = tmpList.remove(0);
                if (tmp2.left != null) {
                    queue1.add(new TreeNode(tmp2.left.val, tmp2.left.left, tmp2.left.right));
                }
                if (tmp2.right != null) {
                    queue1.add(new TreeNode(tmp2.right.val, tmp2.right.left, tmp2.right.right));
                }
            }
            
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(2);
        System.out.println(new EvenOddTree().isEvenOddTree(root));
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(7);
        System.out.println(new EvenOddTree().isEvenOddTree(root2));
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(1);
        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(5);
        root3.right.left = new TreeNode(7);
        System.out.println(new EvenOddTree().isEvenOddTree(root3));
        TreeNode root4 = new TreeNode(1);
        System.out.println(new EvenOddTree().isEvenOddTree(root4));
    }

}

