/**
 * Demonstation of left view of a binary tree
 * 
 * Output:
 * ------
 * 1 2 4 7 
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeftView {

    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) { this.val = val; }
    }

    private int htMax = Integer.MIN_VALUE;
    private List<Integer> leftViewElems = new ArrayList<Integer>();

    private List<Integer> calcLeftViewElems(Node node, int ht) {
        if (null == node) {
            return null;
        }
        if (ht > htMax) {
            htMax = ht;
            leftViewElems.add(node.val);
        }
        calcLeftViewElems(node.left, ht+1);
        calcLeftViewElems(node.right, ht+1);
        return leftViewElems;
    }

    public List<Integer> leftView(Node root) {
        return calcLeftViewElems(root, 0);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        BinaryTreeLeftView obj = new BinaryTreeLeftView();
        List<Integer> leftElems = obj.leftView(root);

        if (leftElems != null) {
            for (Integer val : leftElems) {
                System.out.printf("%d ", val);
            }
        }
        System.out.println();
    }

}

