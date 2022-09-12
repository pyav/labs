/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * Output:
 * ------
 * 1 
 * 3 2 4 
 * 5 6 
 */

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;

public class NaryLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (null == root) {
            return result;
        }
        q1.add(root);
        while(true && !q1.isEmpty()) {
            List<Integer> list1 = new ArrayList<Integer>();
            while(!q1.isEmpty()) {
                Node node = q1.poll();
                list1.add(node.val);
                if (null == node.children) {
                    continue;
                }
                for (Node child : node.children) {
                    q2.add(child);
                }
            }
            if (list1.size() > 0) {
                result.add(list1);
            }
            List<Integer> list2 = new ArrayList<Integer>();
            while(!q2.isEmpty()) {
                Node node = q2.poll();
                list2.add(node.val);
                if (null == node.children) {
                    continue;
                }
                for (Node tmp : node.children) {
                    q1.add(tmp);
                }
            }
            if (list2.size() > 0) {
                result.add(list2);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<Node>();
        root.children.add(new Node(3, new ArrayList<Node>(Arrays.asList(new Node(5), new Node(6)))));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        List<List<Integer>> result = new NaryLevelOrderTraversal().levelOrder(root);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }

    }

}

