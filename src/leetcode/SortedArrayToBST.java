/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Output:
 * ------
 * 0
 */

package leetcode;

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

public class SortedArrayToBST {

    private TreeNode createBST(int start, int end, int[] nums) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(start, mid-1, nums);
        root.right = createBST(mid+1, end, nums);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(0, nums.length - 1, nums);
    }

    public static void main(String[] args) {
        int nums[] = {-10,-3,0,5,9};
        System.out.println(new SortedArrayToBST().sortedArrayToBST(nums).val);
    }
}

