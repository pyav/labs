/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description
 *
 * Output:
 * ------
 * null
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ListIntersection {
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while(tmpA != tmpB) {
            tmpA = (tmpA == null)? headB: tmpA.next;
            tmpB = (tmpB == null)? headA: tmpB.next;
        }
        return tmpA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(2);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(4);
        ListNode headB = new ListNode(1);
        headB.next = new ListNode(5);
        System.out.println(new ListIntersection().getIntersectionNode(headA, headB));
    }
}

