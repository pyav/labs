/**
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Output:
 * ------
 * 1->2->5
 * 1->3
 * 1
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

public class BinaryTreePaths {
    private List<String> calcBinaryTreePaths(TreeNode root, List<String> resultPaths, String path) {
        if (null == root) {
            return resultPaths;
        }
        path += String.valueOf(root.val) + "->";
        if (null == root.left && null == root.right) {
            path = path.substring(0, path.length()-2);
            resultPaths.add(path);
        }
        calcBinaryTreePaths(root.left, resultPaths, path);
        calcBinaryTreePaths(root.right, resultPaths, path);
        return resultPaths;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultPaths = new ArrayList<String>();
        return calcBinaryTreePaths(root, resultPaths, "");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> resultPaths = new BinaryTreePaths().binaryTreePaths(root);
        resultPaths.forEach(System.out::println);
        TreeNode root2 = new TreeNode(1);
        List<String> resultPaths2 = new BinaryTreePaths().binaryTreePaths(root2);
        resultPaths2.forEach(System.out::println);
    }

}
