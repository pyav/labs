/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Output:
 * ------
 * 1
 * 2
 */

package leetcode;

public class RemoveDuplicatesFromSortedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode tmp = head;
        while(tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head =  new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head = new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
        ListNode tmp = head;
        while(tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

}

