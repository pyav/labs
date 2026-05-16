/**
 * https://leetcode.com/problems/linked-list-random-node/
 *
 * Output:
 * ------
 * 2
 * 2
 * 2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LLRandomNode {
    private List<Integer> list = null;
    private Random rand = null;

    public LLRandomNode(ListNode head) {
        list = new ArrayList<>();
        ListNode tmp = head;

        while(null != tmp) {
            list.add(tmp.val);
            tmp = tmp.next;
        }

        rand = new Random();
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LLRandomNode obj = new LLRandomNode(head);
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }
}

