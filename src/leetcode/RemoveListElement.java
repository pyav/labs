/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * Output:
 * ------
 *
 */

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveListElement {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        while(null != head && head.val == val) {
            head = head.next;
        }
        ListNode tmp = head;
        while(null != tmp) {
            if (null != tmp.next && tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(6);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next = new ListNode(6);
        new RemoveListElement().removeElements(root, 6);
        ListNode tmp = root;
        while (null != tmp) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}
