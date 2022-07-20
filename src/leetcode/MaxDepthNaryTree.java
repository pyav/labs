/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 *
 * Output:
 * ------
 * 2
 */

package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class MaxDepthNaryTree {

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

    private int maxHt = 0;

    private int calcMaxDepth(Node node, int ht) {
        if (null == node) {
            return 0;
        }
        if (ht > maxHt) {
            maxHt = ht;
        }
        if (null != node.children) {
            Iterator<Node> children = node.children.iterator();
            while(children.hasNext()) {
                Node child = children.next();
                calcMaxDepth(child, ht+1);
            }
        }
        return maxHt;
    }

    public int maxDepth(Node root) {
        return calcMaxDepth(root, 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<Node>();
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));
        System.out.println(new MaxDepthNaryTree().maxDepth(root));
    }

}

