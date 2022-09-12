/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 *
 * Output:
 * ------
 * 1 3 5 6 2 4 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NaryPreOrderTraversal {

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

    private List<Integer> calcPreOrder(Node root, List<Integer> result) {
        if (null == root) {
            return new ArrayList<Integer>();
        }
        result.add(root.val);
        if (null != root.children) {
            for (Node node: root.children) {
                calcPreOrder(node, result);
            }
        }
        return result;
    }

    public List<Integer> preorder(Node root) {
        return calcPreOrder(root, new ArrayList<Integer>());
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<Node>();
        root.children.add(new Node(3, new ArrayList<Node>(Arrays.asList(new Node(5), new Node(6)))));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        List<Integer> result = new NaryPreOrderTraversal().preorder(root);
        for (Integer item : result) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }
    
}

