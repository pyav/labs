/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Output:
 * ------
 * 2
 * 1
 */

import java.util.Map;
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Map<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();
        ListNode tmp = head;
        while (tmp.next != null && !map.containsKey(tmp)) {
            map.put(tmp, true);
            tmp = tmp.next;
        }
        if (map.containsKey(tmp)) {
            return tmp;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode result = new LinkedListCycleII().detectCycle(head);
        if (result != null) {
            System.out.println(result.val);
        }
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;
        ListNode result2 = new LinkedListCycleII().detectCycle(head2);
        if (result2 != null) {
            System.out.println(result2.val);
        }
    }
}

