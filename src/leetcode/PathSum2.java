/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Output:
 * ------
 * 5 4 11 2 
 * 5 8 4 5 
 *
 *
 *
 *
 *
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

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

    private List<List<Integer>> checkSumExists(TreeNode root, int sum, int targetSum,
            List<Integer> runningList, List<List<Integer>> finalList) {
        if (null == root) {
            return finalList;
        }
        List<Integer> tmpList = new ArrayList<Integer>();
    	tmpList.addAll(runningList);
    	tmpList.add(root.val);
        if ((sum = sum + root.val) == targetSum && root.left == null && root.right == null) {
            finalList.add(tmpList);
            return finalList;
        }
        checkSumExists(root.left, sum, targetSum, tmpList, finalList);
        List<Integer> tmpList2 = new ArrayList<Integer>();
    	tmpList2.addAll(runningList);
    	tmpList2.add(root.val);
        return checkSumExists(root.right, sum, targetSum, tmpList2, finalList);
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return checkSumExists(root, 0, targetSum, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> finalList = new PathSum2().pathSum(root, 22);
        for (List<Integer> list : finalList) {
            for (Integer item : list) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
        System.out.println();
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        List<List<Integer>> finalList2 = new PathSum2().pathSum(root2, 5);
        for (List<Integer> list2 : finalList2) {
            for (Integer item2 : list2) {
                System.out.printf("%d ", item2);
            }
            System.out.println();
        }
        System.out.println();
        TreeNode root3 = null;
        List<List<Integer>> finalList3 = new PathSum2().pathSum(root3, 0);
        for (List<Integer> list3 : finalList3) {
            for (Integer item3 : list3) {
                System.out.printf("%d ", item3);
            }
            System.out.println();
        }
        System.out.println();
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        List<List<Integer>> finalList4 = new PathSum2().pathSum(root4, 0);
        for (List<Integer> list4 : finalList4) {
            for (Integer item4 : list4) {
                System.out.printf("%d ", item4);
            }
            System.out.println();
        }
        System.out.println();
    }

}

