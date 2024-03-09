/*
   https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/

   Output:
   ------
   22
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

public class SumRootToLeafBinary {
    private Integer calcSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        sum = (sum<<1) | root.val;
        if (null == root.left && null == root.right) {
            return sum;
        }
        return calcSum(root.left, sum) + calcSum(root.right, sum);
    }

    public int sumRootToLeaf(TreeNode root) {
        return calcSum(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        System.out.println(new SumRootToLeafBinary().sumRootToLeaf(root));
    }
}
