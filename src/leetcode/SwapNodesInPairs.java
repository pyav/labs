/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Output:
 * ------
 * 5
 * 2
 * 4
 * 3
 * 2
 * 6
 * 2
 */

package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;
        ListNode tmp = newHead.next;
        ListNode tmp2 = null;
        while (null != tmp && null != tmp.next && null != tmp.next.next) {
            tmp2 = tmp.next;
            tmp.next = tmp2.next;
            tmp2.next = tmp.next.next;
            tmp.next.next = tmp2;
            tmp = tmp2;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        ListNode newHead = new SwapNodesInPairs().swapPairs(head);
        ListNode temp = newHead;

        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }       
    }

}

