/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * Output:
 * ------
 * true
 * false
 */

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

public class TwoSumIV {
    class LinkedNode {
        int data;
        LinkedNode prev;
        LinkedNode next;
        LinkedNode(int data) {
            this.data = data;
        }
    }
    LinkedNode head = null;
    LinkedNode tail = null;

    private void convertTreeToLinkedList(TreeNode root) {
        if (null == root) {
            return;
        }
        convertTreeToLinkedList(root.left);
        if (null == head) {
            head = new LinkedNode(root.val);
            tail = head;
            head.prev = null;
            tail.next = null;
        } else {
            LinkedNode tmp = new LinkedNode(root.val);
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
        convertTreeToLinkedList(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        convertTreeToLinkedList(root);
        LinkedNode temp = head;
        while(temp != tail) {
            if (temp.data + tail.data == k) {
                return true;
            } else if (temp.data + tail.data < k) {
                temp = temp.next;
            } else if (temp.data + tail.data > k) {
                tail = tail.prev;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(new TwoSumIV().findTarget(root, 9));
        System.out.println(new TwoSumIV().findTarget(root, 28));
    }
}

