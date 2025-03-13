/**
 * https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/?envType=problem-list-v2&envId=linked-list
 *
 * Otuput:
 * ------
 * 3 7 8 
 */

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class DoubleLinkedList {
    private ListNode origHead = null;

    private int calcDouble(ListNode node) {
        if (node == null) {
            return 0;
        }
        int carry = calcDouble(node.next);
        int val = carry + (node.val<<1);
        node.val = val % 10;
        carry = val / 10;
        if (origHead == node && carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = origHead;
            origHead = newHead;
            carry = 0;
        }
        return carry;
    }

    public ListNode doubleIt(ListNode head) {
        origHead = head;
        calcDouble(head);
        return origHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(9);
        head = new DoubleLinkedList().doubleIt(head);
        ListNode tmp = head;
        while(tmp != null) {
            System.out.printf("%d ", tmp.val);
            tmp = tmp.next;
        }
    }
}

