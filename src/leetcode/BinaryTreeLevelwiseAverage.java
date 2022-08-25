/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * Output:
 * ------
 * 3.000000 14.500000 10.666667
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelwiseAverage {

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> queue1 = new ArrayList<TreeNode>();
        queue1.add(root);
        List<TreeNode> tmpList = new ArrayList<TreeNode>();
        List<Double> result = new ArrayList<Double>();

        while (true) {
            if (queue1.isEmpty()) {
                break;
            }
            Double sum = 0.0;
            for (int i = 0; i < queue1.size(); i++) {
                sum += queue1.get(i).val;
            }
            if (queue1.size() > 0) {
                result.add(sum / queue1.size());
            }
            sum = 0.0;
            while (!queue1.isEmpty()) {
                TreeNode tmp = queue1.remove(0);
                if (tmp.left != null) {
                    tmpList.add(new TreeNode(tmp.left.val, tmp.left.left, tmp.left.right));
                    sum += tmp.left.val;
                }
                if (tmp.right != null) {
                    tmpList.add(new TreeNode(tmp.right.val, tmp.right.left, tmp.right.right));
                    sum += tmp.right.val;
                }
            }
            if (tmpList.size() > 0) {
                result.add(sum / tmpList.size());
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
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(10);
        List<Double> result = new BinaryTreeLevelwiseAverage().averageOfLevels(root);
        for (Double d : result) {
            System.out.printf("%f ", d);
        }
        System.out.println();
    }

}

