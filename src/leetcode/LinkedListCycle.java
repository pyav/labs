/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Output:
 * ------
 * true
 * true
 * false
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

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Map<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();
        ListNode tmp = head;
        while (tmp.next != null && !map.containsKey(tmp)) {
            map.put(tmp, true);
            tmp = tmp.next;
        }
        if (map.containsKey(tmp)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(new LinkedListCycle().hasCycle(head));
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;
        System.out.println(new LinkedListCycle().hasCycle(head2));
        ListNode head3 = new ListNode(1);
        System.out.println(new LinkedListCycle().hasCycle(head3));
    }
}

