/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Output:
 * ------
 * 1 1 2 3 4 4 5 6 
 */

package leetcode;

import java.util.PriorityQueue;

public class MergeKSortedLists2 {

	static class ListNode {
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

	public ListNode mergeKLists(ListNode[] lists) {
		if (null == lists) {
			return null;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < lists.length; i++) {
			ListNode tmp = lists[i];
			while (tmp != null) {
				pq.add(tmp.val);
				tmp = tmp.next;
			}
		}
		if (pq.size() == 0) {
			return null;
		}
		ListNode result = new ListNode();
		ListNode tmp = result;
		while (pq.size() > 1) {
			tmp.val = pq.poll();
			tmp.next = new ListNode();
			tmp = tmp.next;
		}
		if (pq.size() == 1) {
			tmp.val = pq.poll();
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		lists[0] = new ListNode(1);
		lists[0].next = new ListNode(4);
		lists[0].next.next = new ListNode(5);
		lists[1] = new ListNode(1);
		lists[1].next = new ListNode(3);
		lists[1].next.next = new ListNode(4);
		lists[2] = new ListNode(2);
		lists[2].next = new ListNode(6);
		ListNode newHead = new MergeKSortedLists2().mergeKLists(lists);
		ListNode tmp = newHead;
		while (tmp != null) {
			System.out.printf("%d ", tmp.val);
			tmp = tmp.next;
		}
		ListNode[] lists2 = new ListNode[2];
		lists2[0] = null;
		lists2[1] = null;
		ListNode newHead2 = new MergeKSortedLists2().mergeKLists(lists2);
		tmp = newHead2;
		while (tmp != null) {
			System.out.printf("%d ", tmp.val);
			tmp = tmp.next;
		}
	}

}
