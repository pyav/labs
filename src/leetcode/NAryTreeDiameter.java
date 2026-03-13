/**
 * https://leetcode.com/problems/diameter-of-n-ary-tree/description/
 * 
 * Output:
 * ------
 * 3
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NAryTreeDiameter {

	private int diameter = 0;
	
	private int calcHeight(Node root) {
		if (null == root) {
			return 0;
		}
		int max1 = 0;
		int max2 = 0;
		
		for (Node child : root.children) {
			int h = calcHeight(child);
			if (h > max1) {
				max2 = max1;
				max1 = h;
			} else if (h > max2) {
				max2 = h;
			}
		}
		
		diameter = Math.max(diameter, max1 + max2);
				
		return 1 + max1;
	}
	
	public int diameter(Node root) {
		calcHeight(root);
		return diameter;
    }

	public static void main(String[] args) {
		Node child1 = new Node(3);
		Node child2 = new Node(2);
		Node child3 = new Node(4);
		Node child4 = new Node(5);
		Node child5 = new Node(6);
		
		child1.children = Arrays.asList(child4, child5);
		ArrayList<Node> list = new ArrayList<Node>();
		list.add(child1);
		list.add(child2);
		list.add(child3);
		Node root = new Node(1, list);
		
		System.out.println(new NAryTreeDiameter().diameter(root));
	}

}
