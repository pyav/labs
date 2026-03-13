/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/description
 * 
 * Output:
 * ------
 * [[9], [3, 15], [20], [7]]
 * [[4], [2, 5], [1, 10, 9, 6], [3], [11]]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class BinaryTreeVerticalOrder {

	private SortedMap<Integer, SortedMap<Integer, List<Integer>>> totalMap = new TreeMap<>();
	
	private void calcHeight(TreeNode root, int dist, int ht) {
		if (root == null) {
        	return;
        }
		
		SortedMap<Integer, List<Integer>> rowSortedMap = totalMap.getOrDefault(dist, new TreeMap<Integer, List<Integer>>());
        
        List<Integer> list = rowSortedMap.getOrDefault(ht, new ArrayList<Integer>());
        
        list.add(root.val);   
        rowSortedMap.put(ht, list);
        totalMap.put(dist, rowSortedMap);
        
        calcHeight(root.left, dist-1, ht+1);
        calcHeight(root.right, dist+1, ht+1);
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
        calcHeight(root, 0, 0);
        
        List<List<Integer>> resultList = new ArrayList<>();

        for (Entry<Integer, SortedMap<Integer, List<Integer>>> topEntry : totalMap.entrySet()) {
        	List<Integer> list = new ArrayList<>();
        	
        	for (Entry<Integer, List<Integer>> valEntry : topEntry.getValue().entrySet()) {
        		list.addAll(valEntry.getValue());
        	}
        	resultList.add(list);
        }
        
        return resultList;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> list = new BinaryTreeVerticalOrder().verticalOrder(root);
		System.out.println(list.toString());
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(10);
		root2.left.left.right = new TreeNode(5);
		root2.left.left.right.right = new TreeNode(6);
		root2.right.left = new TreeNode(9);
		root2.right.right = new TreeNode(11);
		
		List<List<Integer>> list2 = new BinaryTreeVerticalOrder().verticalOrder(root2);
		System.out.println(list2.toString());
	}

}
