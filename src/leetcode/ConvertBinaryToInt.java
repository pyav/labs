/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/?envType=problem-list-v2&envId=linked-list
 *
 * Output:
 * ------
 * 5
 * 0
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class ConvertBinaryToInt {
    private double sum = 0;
    private int power = 0;

    private int getDecCalc(ListNode node, int power) {
        if (null == node) {
            return 0;
        }
        int tmpPower = getDecCalc(node.next, power);
        sum += node.val * Math.pow(2, tmpPower);
        return ++tmpPower;
    }

    public int getDecimalValue(ListNode node) {
        getDecCalc(node, 0);
        return (int) sum;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(new ConvertBinaryToInt().getDecimalValue(head));
        ListNode head2 = new ListNode(0);
        System.out.println(new ConvertBinaryToInt().getDecimalValue(head2));
    }

}

