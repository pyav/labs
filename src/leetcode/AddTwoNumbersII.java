/**
 * https://leetcode.com/problems/add-two-numbers-ii/description/?envType=problem-list-v2&envId=linked-list
 *
 * Output:
 * ------
 * 7 8 0 7 
 * 0
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class AddTwoNumbersII {
    private ListNode reverseList(ListNode head) {
        ListNode first = null;
        ListNode mid = head;
        ListNode next;
        while(mid != null) {
            next = mid.next;
            mid.next = first;
            first = mid;
            mid = next;
        }
        return first;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode res = new ListNode();
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode tmpRes = res;
        ListNode prevTmpRes = null;
        int carry = 0;

        while(tmp1 != null && tmp2 != null) {
            tmpRes.val = (carry + tmp1.val + tmp2.val) % 10;
            carry = (carry + tmp1.val + tmp2.val)/10;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
            prevTmpRes = tmpRes;
            tmpRes.next = new ListNode();
            tmpRes = tmpRes.next;
        }
        if (tmp1 == null && tmp2 != null) {
            while(tmp2 != null) {
                tmpRes.val = (carry + tmp2.val) % 10;
                carry = (carry + tmp2.val)/10;
                prevTmpRes = tmpRes;
                tmpRes.next = new ListNode();
                tmpRes = tmpRes.next;
                tmp2 = tmp2.next;
            }
            if (carry > 0) {
                tmpRes.val = carry;
            } else {
                prevTmpRes.next = null;
                tmpRes = null;
            }
        } else if (tmp2 == null && tmp1 != null) {
            while(tmp1 != null) {
                tmpRes.val = (carry + tmp1.val) % 10;
                carry = (carry + tmp1.val)/10;
                prevTmpRes = tmpRes;
                tmpRes.next = new ListNode();
                tmpRes = tmpRes.next;
                tmp1 = tmp1.next;
            }
            if (carry > 0) {
                tmpRes.val = carry;
            } else {
                prevTmpRes.next = null;
                tmpRes = null;
            }
        } else {
            if (carry > 0) {
                tmpRes.val = carry;
            } else {
                prevTmpRes.next = null;
                tmpRes = null;
            }
        }

        return reverseList(res);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = new AddTwoNumbersII().addTwoNumbers(l1, l2);
        ListNode tmp = res;
        while(tmp != null) {
            System.out.printf("%d ", tmp.val);
            tmp = tmp.next;
        }
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        System.out.println();
        ListNode res2 = new AddTwoNumbersII().addTwoNumbers(l1, l2);
        tmp = res2;
        while(tmp != null) {
            System.out.printf("%d ", tmp.val);
            tmp = tmp.next;
        }
    }
}

