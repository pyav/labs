/**
 * In-order convert a binary tree to sum tree
 *
 * Output:
 * ------
 *
 */

public class ConvertBinaryTreeToSumTree {

    static class Node {
        int val;
        Node left;
        Node right;
        Node(int _val) {
            val = _val;
        }
    }

    public int convertTree(Node root) {
        if (null == root) {
            return 0;
        }
        int k = root.val;
        root.val = convertTree(root.left) + convertTree(root.right);
        return k + root.val;
    }

    private void printTree(Node node){
        if (null == node) {
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        ConvertBinaryTreeToSumTree obj = new ConvertBinaryTreeToSumTree();
        obj.convertTree(root);
        obj.printTree(root);
    }

}

