/**
 * https://leetcode.com/problems/sort-list/
 * 
 *  Output:
 *  ------
 *  1 2 3 4 
 *  -1 0 3 4 5 
 *  1
 */

import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortList {
	
	public ListNode sortList(ListNode head) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        ListNode tmp = head;
        
        while(tmp != null) {
        	map.put(tmp.val, map.getOrDefault(tmp.val, 0)+1);
        	tmp = tmp.next;
        }
        
        ListNode newHead = null;
        		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int val = entry.getValue();
			while (val-- > 0) {
				if (newHead == null) {
					newHead = new ListNode(entry.getKey());
					tmp = newHead;
					continue;
				}
				tmp.next = new ListNode(entry.getKey());
				tmp = tmp.next;
			}
		}
        head = newHead;
        
        return head;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		head = new SortList().sortList(head);
		ListNode tmp = head;
		while(tmp != null) {
			System.out.printf("%d ", tmp.val);
			tmp = tmp.next;
		}
		System.out.println();
		ListNode head2 = new ListNode(-1);
		head2.next = new ListNode(5);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(4);
		head2.next.next.next.next = new ListNode(0);
		head2 = new SortList().sortList(head2);
		tmp = head2;
		while(tmp != null) {
			System.out.printf("%d ", tmp.val);
			tmp = tmp.next;
		}
		System.out.println();
		ListNode head3 = new ListNode(1);
		head3 = new SortList().sortList(head3);
		System.out.printf("%d\n", head3.val);
	}

}
