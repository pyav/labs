/**
 * https://leetcode.com/problems/design-linked-list/description/?envType=problem-list-v2&envId=linked-list
 *
 * Otuput:
 * ------
 * 4
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyNode {
    int val;
    MyNode next;
    MyNode() { }
    MyNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    private MyNode head = null;

    public MyLinkedList() { }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        int val = head.val;
        MyNode tmp = head;
        int i = 0;

        while(tmp != null && i <= index) {
            val = tmp.val;
            if (i == index) {
                return val;
            }
            i++;
            tmp = tmp.next;
        }
        if (tmp == null && i <= index) {
            return -1;
        }

        return val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new MyNode(val);
            return;
        }
        MyNode tmp = new MyNode(val);
        tmp.next = head;
        head = tmp;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new MyNode(val);
            return;
        }
        MyNode tmp = head;
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new MyNode(val);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        int idx = 0;
        MyNode tmp = head;
        while(idx < (index - 1) && tmp != null) {
            tmp = tmp.next;
            idx++;
        }
        if (tmp == null) {
            return;
        }
        MyNode tmpNext = tmp.next;
        tmp.next = new MyNode(val);
        tmp.next.next = tmpNext;
        return;
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        int tmpIdx = 0;
        MyNode tmp = head;
        while(tmpIdx < (index - 1) && tmp != null) {
            tmp = tmp.next;
            tmpIdx++;
        }
        if (tmp == null) {
            return;
        }
        if (tmp != null && tmp.next != null) {
            tmp.next = tmp.next.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        System.out.println(myLinkedList.get(4));
    }
}

