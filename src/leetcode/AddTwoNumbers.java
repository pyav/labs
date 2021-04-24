/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Output:
 * ------
 * l3.val = 7 
 * l3.val = 0 
 * l3.val = 8 
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

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode t1 = l1;
		ListNode t2 = l2;
		ListNode t3 = null;
		ListNode t4 = null;
		int carry = 0;

		while (t1 != null && t2 != null) {
			int sum = t1.val + t2.val + carry;

			if (t3 == null) {
				t3 = new ListNode();
				t4 = t3;
			} else {
				t3.next = new ListNode();
				t3 = t3.next;
			}

			t3.val = sum % 10;
			carry = sum / 10;
			t1 = t1.next;
			t2 = t2.next;
		}
		if (t1 == null && t2 != null) {
			while (t2 != null) {
				int sum = t2.val + carry;

				if (t3 == null) {
					t3 = new ListNode();
					if (t4 == null) {
						t4 = t3;
					}
				} else {
					t3.next = new ListNode();
					t3 = t3.next;
				}

				t3.val = sum % 10;
				carry = sum / 10;
				t2 = t2.next;
			}
		} else if (t2 == null && t1 != null) {
			while (t1 != null) {
				int sum = t1.val + carry;

				if (t3 == null) {
					t3 = new ListNode();
					if (t4 == null) {
						t4 = t3;
					}
				} else {
					t3.next = new ListNode();
					t3 = t3.next;
				}

				t3.val = sum % 10;
				carry = sum / 10;
				t1 = t1.next;
			}
		}

		if (carry != 0) {
			t3.next = new ListNode();
			t3 = t3.next;
			t3.val = carry;
		}

		return t4;
	}

	public static void main(String[] args) {
		 ListNode l1 = new ListNode(2);
		 l1.next = new ListNode(4);
		 l1.next.next = new ListNode(3);
		 ListNode l2 = new ListNode(5);
		 l2.next = new ListNode(6);
		 l2.next.next = new ListNode(4);

		 /*ListNode l1 = new ListNode(0); 
		 ListNode l2 = new ListNode(0);*/

		/*ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);*/

		ListNode l3 = new AddTwoNumbers().addTwoNumbers(l1, l2);
		System.out.println();
		while (l3 != null) {
			System.out.printf("l3.val = %d ", l3.val);
			System.out.println();
			l3 = l3.next;
		}
	}

}
