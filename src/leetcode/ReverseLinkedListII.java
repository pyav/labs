/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 */

public class ReverseLinkedListII {
	
	private ListNode reverseList(ListNode head) {
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
	
	public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode beforeStart = null;
        ListNode start = head;
        ListNode end = null;
        ListNode afterEnd = null;
        int count = 1;
        while(count < left) {
            beforeStart = start;
            start = start.next;
            count++;
        }
        end = start;
        while(count < right && end != null) {
            end = end.next;
            count++;
        }
        afterEnd = end.next;
        end.next = null;
        ListNode newBeforeEnd = start;
        ListNode newStart = reverseList(start);
        if (beforeStart != null) {
            beforeStart.next = newStart;
        } else {
            head = newStart;
        }
        newBeforeEnd.next = afterEnd;

        return head;
    }
	
	public static void main(String[] args) {
	
	}
}