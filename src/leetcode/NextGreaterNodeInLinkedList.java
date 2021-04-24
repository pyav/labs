/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 * 
 * Output:
 * ------
 * 7
 * 9
 * 9
 * 9
 * 0
 * 5
 * 0
 * 0
 */

package leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class NextGreaterNodeInLinkedList {
    int count = 0;
    int[] nextMaxArr = null;
    int overallMax = Integer.MIN_VALUE;

    private int getNextHigh(ListNode head) {
        if (null == head) {
            return Integer.MIN_VALUE;
        }
        int k = head.val;
        while(head.next != null) {
            if (head.next.val > k) {
                return head.next.val;
            }
            head = head.next;
        }
        return Integer.MIN_VALUE;
    }

	public int[] nextLargerNodes(ListNode head) {
        int k = Integer.MIN_VALUE;
        if (head == null || head.next == null) {
            if (head!=null && head.next==null) {
                overallMax = (overallMax < head.val)? head.val: overallMax;
            }
            nextMaxArr = new int[count+1];
            nextMaxArr[count] = 0;
            return nextMaxArr;
        }
        count++;
        nextLargerNodes(head.next);
        overallMax = (overallMax < head.val)? head.val: overallMax;
        count--;
        nextMaxArr[count] = (head.next.val > head.val)? head.next.val: ((k = getNextHigh(head)) == Integer.MIN_VALUE)? 0: k;
        return nextMaxArr;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(7);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next.next = new ListNode(1);
		int[] arr = new NextGreaterNodeInLinkedList().nextLargerNodes(head);
		
		for (int i : arr) {
			System.out.println(i);
		}
	}

}

