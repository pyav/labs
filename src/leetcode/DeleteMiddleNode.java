/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
 *
 * Output:
 * ------
 * 1->3->4->1->2->6->
 * 1->2->4->
 * 2->
 * head is null
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if (null == head.next) {
            head = null;
            return head;
        }
        ListNode preOneStep = null;
        ListNode oneStep = head;
        ListNode twoStep = head;
        while(null != twoStep && null != twoStep.next) {
            preOneStep = oneStep;
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        preOneStep.next = oneStep.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);
        root.next.next = new ListNode(4);
        root.next.next.next = new ListNode(7);
        root.next.next.next.next = new ListNode(1);
        root.next.next.next.next.next = new ListNode(2);
        root.next.next.next.next.next.next = new ListNode(6);
        new DeleteMiddleNode().deleteMiddle(root);
        ListNode tmp = root;
        while(null != tmp) {
            System.out.printf("%d->", tmp.val);
            tmp = tmp.next;
        }
        System.out.println();
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(3);
        root2.next.next.next = new ListNode(4);
        new DeleteMiddleNode().deleteMiddle(root2);
        tmp = root2;
        while(null != tmp) {
            System.out.printf("%d->", tmp.val);
            tmp = tmp.next;
        }
        System.out.println();
        ListNode root3 = new ListNode(2);
        root3.next = new ListNode(1);
        new DeleteMiddleNode().deleteMiddle(root3);
        tmp = root3;
        while(null != tmp) {
            System.out.printf("%d->", tmp.val);
            tmp = tmp.next;
        }
        System.out.println();
        ListNode root4 = new ListNode(2);
        tmp = new DeleteMiddleNode().deleteMiddle(root4);
        if (null == tmp) {
            System.out.println("head is null");
        }
    }
}
