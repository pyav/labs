/**
 * https://leetcode.com/problems/remove-nodes-from-linked-list/description/
 * 
 * Output:
 * ------
 * 13
 * 8
 */

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNodesFromLL {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        while(null != tmp) {
            if (stack.isEmpty()) {
                stack.push(tmp.val);
            } else {
                while(!stack.isEmpty() && stack.peek() < tmp.val) {
                    stack.pop();
                }
                stack.push(tmp.val);
            }
            tmp = tmp.next;
        }

        head = null;
        while(!stack.isEmpty()) {
            int val = stack.pop();
            tmp = new ListNode(val);
            if (null == head) {
                head = tmp;
            } else {
                tmp.next = head;
                head = tmp;
            }
        }


        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        head = new RemoveNodesFromLL().removeNodes(head);
        System.out.println(head.val);
        System.out.println(head.next.val);
    }
}

