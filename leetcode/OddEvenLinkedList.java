/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * 
 * Output:
 * ------
 * 1 3 5 2 4 
 */

package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode headOdd = head;
        ListNode headEven = head.next;

        ListNode tmpOdd = headOdd;
        ListNode tmpEven = headEven;

        while(null != tmpOdd && null != tmpEven){
            tmpOdd.next = tmpEven.next;
            if (tmpEven.next == null) {
                break;
            } else {
                tmpEven.next = tmpEven.next.next;
            }
            tmpOdd = tmpOdd.next;
            tmpEven = tmpEven.next;
        }

        tmpOdd.next = headEven;
        return headOdd;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode listNew = new OddEvenLinkedList().oddEvenList(list1);
        ListNode tmp = listNew;
        while (null != tmp) {
            System.out.printf("%d ", tmp.val);
            tmp = tmp.next;
        }
    }

}

