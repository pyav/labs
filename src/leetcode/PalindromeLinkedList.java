/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Output:
 * ------
 * true
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

public class PalindromeLinkedList {

	ListNode origHead = null;
	
	private boolean checkRecursePalindrome(ListNode node) {
		if (node == null) {
			return true;
		}
		if (!checkRecursePalindrome(node.next)) {
			return false;
		}
		if (node.val != origHead.val) {
			return false;
		} else {
			if (node.next == origHead) {
				return true;
			}
			origHead = origHead.next;
		}
		return true;
	}
	private ListNode getMid(ListNode head) {
		ListNode mid = head;
		ListNode last = head;
		while (last.next != null && last.next.next != null) {
			last = last.next.next;
			mid = mid.next;
		}
		return mid;
	}
	public boolean isPalindrome(ListNode head) {
        origHead = head;
        return checkRecursePalindrome(getMid(head));
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		System.out.println(new PalindromeLinkedList().isPalindrome(head));
	}

}
