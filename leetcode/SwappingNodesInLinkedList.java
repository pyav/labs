/**
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 *
 * Output:
 * ------
 * 1
 * 4
 * 3
 * 2
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

public class SwappingNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        int n = k-1;
        ListNode first = head;
        ListNode last = head;
        ListNode follower = head;
        while(n > 0) {
            n--;
            follower = follower.next;
            last = last.next;
        }
        while(last.next != null) {
            last = last.next;
            first = first.next;
        }
        int tmp = first.val;
        first.val = follower.val;
        follower.val = tmp;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = new SwappingNodesInLinkedList().swapNodes(head, 2);
        ListNode temp = newHead;

        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }       
    }

}

