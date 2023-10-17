/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * Output:
 * ------
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = new ReverseLinkedList().reverseList(head);
        System.out.println(newHead.val);
        System.out.println(newHead.next.val);
        System.out.println(newHead.next.next.val);
        System.out.println(newHead.next.next.next.val);
        System.out.println(newHead.next.next.next.next.val);
    }

}

