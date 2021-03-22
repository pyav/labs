/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Output:
 * ------
 * 1 2 2 3 4 4 
 */

package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode head = new ListNode(), tmp = null;
        boolean isInitial = true;
        while (t1 != null && t2 != null) {
            if (isInitial) {
                isInitial = !isInitial;
                if (t1.val<t2.val) {
                    head.val = t1.val;
                    t1 = t1.next;
                } else {
                    head.val = t2.val;
                    t2 = t2.next;
                }
                tmp = head;
            } else {
                if (t1.val<t2.val) {
                    tmp.next = new ListNode(t1.val);
                    tmp = tmp.next;
                    t1 = t1.next;
                } else {
                    tmp.next = new ListNode(t2.val);
                    tmp = tmp.next;
                    t2 = t2.next;
                }
            }
        }

        if (t1==null) {
            if (tmp == null) {
                head = t2;
            } else {
                while (t2 != null) {
                    tmp.next = new ListNode(t2.val);
                    tmp = tmp.next;
                    t2 = t2.next;
                }
            }
        } else if (t2 == null) {
            if (tmp == null) {
                head = t1;
            } else {
                while (t1 != null) {
                    tmp.next = new ListNode(t1.val);
                    tmp = tmp.next;
                    t1 = t1.next;
                }
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode head = new MergeTwoSortedLists().mergeTwoLists(head1, head2);
        System.out.println();
        ListNode tmp = head;
        while (tmp != null) {
            System.out.printf("%d ", tmp.val);
            tmp = tmp.next;
        }
    }

}

