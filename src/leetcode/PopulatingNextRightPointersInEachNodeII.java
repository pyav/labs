/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * Output:
 * ------
 * 7
 */

import java.util.Queue;
import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(root);
        Queue<Node> q2 = new LinkedList<Node>();
        while(true) {
            Node node = new Node();
            while(!q1.isEmpty()) {
                node = q1.remove();
                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
                node.next = q1.peek();
            }
            while(!q2.isEmpty()) {
                node = q2.remove();
                if (node.left != null) {
                    q1.add(node.left);
                }
                if (node.right != null) {
                    q1.add(node.right);
                }
                node.next = q2.peek();
            }
            if (q1.isEmpty() && q2.isEmpty()) {
                break;
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        new PopulatingNextRightPointersInEachNodeII().connect(root);
        System.out.println(root.left.left.next.next.val);
    }

}

