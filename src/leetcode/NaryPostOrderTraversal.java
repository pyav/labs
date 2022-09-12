/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 *
 * Output:
 * ------
 * 5 6 3 2 4 1
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NaryPostOrderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> calcPostOrder(Node root, List<Integer> result) {
        if (null == root) {
            return new ArrayList<Integer>();
        }
        if (null == root.children) {
            result.add(root.val);
            return result;
        }
        for (Node node: root.children) {
            calcPostOrder(node, result);
        }
        result.add(root.val);
        return result;
    }

    public List<Integer> postorder(Node root) {
        return calcPostOrder(root, new ArrayList<Integer>());
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<Node>();
        root.children.add(new Node(3, new ArrayList<Node>(Arrays.asList(new Node(5), new Node(6)))));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        List<Integer> result = new NaryPostOrderTraversal().postorder(root);
        for (Integer item : result) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }
    
}

