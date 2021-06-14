/**
 * Following program demonstrates a sample binary tree construction and traversal.
 * 
 * Output
 * ------
 * 1
 * 2
 * Node is null.
 * Node is null.
 * 3
 * Node is null.
 * Node is null.
 *
 * 
 * @author pyav
 */

class OneNode {
    int data;
    OneNode left;
    OneNode right;

    OneNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class TreeStructure {

    OneNode node;

    TreeStructure() {
        node = null;
    }

    public static void printTreeStructure(OneNode node) {

        if (node == null) {
            System.out.println("Node is null.");
            return;
        }

        System.out.println(node.data);
        printTreeStructure(node.left);
        printTreeStructure(node.right);
    }

}

public class BinaryTree {

    public static void main(String[] args) {

        TreeStructure root = new TreeStructure();
        root.node = new OneNode(1);
        root.node.left = new OneNode(2);
        root.node.right = new OneNode(3);

        TreeStructure.printTreeStructure(root.node);
    }

}
