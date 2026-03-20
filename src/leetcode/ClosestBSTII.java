/*
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/description/
 *  
 * Output:
 * ------
 * 4 3 5 2 1 
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

class DiffNode {
	double diff;
	int val;
	DiffNode(){}
	DiffNode(double diff, int val){
		this.diff = diff;
		this.val = val;
	}
}

public class ClosestBSTII {

	private PriorityQueue<DiffNode> pq = new PriorityQueue<DiffNode>(
			new Comparator<DiffNode>() {
				public int compare(DiffNode o1, DiffNode o2) {
					if (o2.diff > o1.diff) {
						return -1;
					} else if (o2.diff < o1.diff) {
						return 1;
					} else {
						return 0;
					}
				}
			});
	
	private List<Integer> result = new ArrayList<>();
	
	private List<Integer> calcResult(int k) {
		while(k > 0) {
			k--;
			DiffNode node = pq.poll();
			if (node == null) {
				continue;
			}
			result.add(node.val);
		}
		return result;
	}
	
	private void calcPQ(TreeNode root, double target, int k){
		if (root == null) {
			return;
		}
		
		DiffNode dn = new DiffNode(Math.abs(root.val - target), root.val);
		pq.offer(dn);
		
		calcPQ(root.left, target, k);
		calcPQ(root.right, target, k);
	}
	
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		calcPQ(root, target, k);
		return calcResult(k);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		List<Integer> result = new ClosestBSTII().closestKValues(root, 3.714286, 5);
		result.stream().forEach(x -> System.out.printf("%d ", x));
	}

}
