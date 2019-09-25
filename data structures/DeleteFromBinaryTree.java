/**
 * Following code deletes a node in a Binary Tree;
 * 
 * Output
 * ------
 * B 
 * A 
 * F 
 * K 
 * H 
 * nodeForDelete = H
 * rightmost node.data = K
 * B 
 * A 
 * F 
 * K 
 *
 * 
 * @author pyav
 */

class NodeForDelete {

    String data;
    NodeForDelete left;
    NodeForDelete right;

    NodeForDelete(String val) {
        data = val;
        left = null;
        right = null;
    }
}

public class DeleteFromBinaryTree {

    static NodeForDelete getRightMostNode(NodeForDelete node) {

        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getRightMostNode(node.right);
        }
        if (node.left != null) {
            return getRightMostNode(node.left);
        }

        return node;
    }

    static NodeForDelete getNodeHavingKey(NodeForDelete node, String key) {

        if (node == null) {
            return null;
        } else {
            if (node.data.equals(key)) {
                return node;
            }

            NodeForDelete nonNullNode = getNodeHavingKey(node.left, key);
            if (nonNullNode != null) {
                return nonNullNode;
            }

            NodeForDelete nonNullNode2 = getNodeHavingKey(node.right, key);
            if (nonNullNode2 != null) {
                return nonNullNode2;
            }
        }

        return null;
    }

    static void printTree(NodeForDelete node) {

        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.println(node.data + " ");
        printTree(node.right);
    }

    public static void main(String[] args) {

        NodeForDelete root = new NodeForDelete("A");
        root.left = new NodeForDelete("B");
        root.right = new NodeForDelete("F");
        root.right.right = new NodeForDelete("H");
        root.right.right.left = new NodeForDelete("K");
        printTree(root);

        NodeForDelete nodeForDelete = getNodeHavingKey(root, "H");
        System.out.println("nodeForDelete = " + nodeForDelete.data);

        NodeForDelete rightMostNode = getRightMostNode(root);
        System.out.println("rightmost node.data = " + rightMostNode.data);

        nodeForDelete.data = rightMostNode.data;
        setRightMostNodeToNull(root, rightMostNode);
        rightMostNode.data = "";
        printTree(root);
    }

    private static int setRightMostNodeToNull(NodeForDelete node, NodeForDelete rightMostNode) {

        if (node == null) {
            return 1;
        }
        if (node.left == rightMostNode) {
            node.left = null;
            return 2;
        }
        if (node.right == rightMostNode) {
            node.right = null;
            return 2;
        }
        if (setRightMostNodeToNull(node.left, rightMostNode) == 2 || setRightMostNodeToNull(node.right, rightMostNode) == 2) {
            return 2;
        }
        return 1;
    }

}
