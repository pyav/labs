/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Output:
 * ------
 * 1
 * 2
 * 4
 * 5
 */

package leetcode;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = n-1;
        ListNode first = head;
        ListNode last = head;
        ListNode follower = null;
        while(k > 0) {
            k--;
            last = last.next;
        }
        while(last.next != null) {
            follower = first;
            last = last.next;
            first = first.next;
        }
        if (follower == null) {
            return first.next;
        }
        follower.next = first.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 3);
        ListNode temp = newHead;

        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}

