/**
 * Following code demonstrates the addition of a node level-wise in a
 * Binary Tree and printing the tree inorder.
 * 
 * Output
 * ------
 * Level 3 node 1
 * Level 2 node 1
 * Level 3 node 2
 * Root at level 1
 * Level 2 node 2
 * Level 3 node 1
 * Level 2 node 1
 * Level 3 node 2
 * Root at level 1
 * Level 3 node 3
 * Level 2 node 2
 *
 * 
 * @author pyav
 */

import java.util.LinkedList;
import java.util.Queue;

class Node2 {

    String data;
    Node2 left;
    Node2 right;

    Node2(String val) {
        data = val;
        left = null;
        right = null;
    }
}

public class LevelOrderInsertInBinaryTree {

    public static void main(String[] args) {

        Node2 root = new Node2("Root at level 1");
        root.left = new Node2("Level 2 node 1");
        root.right = new Node2("Level 2 node 2");
        root.left.left = new Node2("Level 3 node 1");
        root.left.right = new Node2("Level 3 node 2");

        printTreeInorder(root);
        addNode(root, "Level 3 node 3");
        printTreeInorder(root);
    }

    private static void printTreeInorder(Node2 node) {

        if (node == null) {
            return;
        }

        printTreeInorder(node.left);
        System.out.println(node.data);
        printTreeInorder(node.right);
    }

    private static void addNode(Node2 root, String val) {

        if (val == null) {
            System.out.println("Given value to add is null, can't add a node for it.");
            return;
        }

        Node2 node = new Node2(val);
        Queue<Node2> queue = new LinkedList<Node2>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node2 tempNode = queue.remove();
            if (tempNode.left == null) {
                tempNode.left = node;
                break;
            } else {
                queue.add(tempNode.left);
            }

            if (tempNode.right == null) {
                tempNode.right = node;
                break;
            } else {
                queue.add(tempNode.right);
            }
        }
    }

}
