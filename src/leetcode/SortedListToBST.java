/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Output:
 * ------
 * 3
 */

package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

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

public class SortedListToBST {
    private ListNode getMidPrev(ListNode head, ListNode tail){
        ListNode A = head;
        ListNode B = head;

        while (B != null && B.next != tail) {
            B = B.next;
            if (B.next != tail) {
                B = B.next;
                A = A.next;
            }
        }
        return A;
    }

    private TreeNode createBST(ListNode head, ListNode tail) {
        if (tail == null || tail.next == head) {
            return null;
        }
        if (head == tail) {
            return new TreeNode(head.val);
        }
        //ListNode mid = getMid(head, tail);
        ListNode midPrev = getMidPrev(head, tail);
        ListNode mid = midPrev.next;
        TreeNode root = new TreeNode(mid.val);
        root.left = createBST(head, midPrev);
        root.right = createBST(mid.next, tail);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        return createBST(head, tail);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(new SortedListToBST().sortedListToBST(head).val);
    }
}

