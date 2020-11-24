/**
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 * 
 * Output:
 * ------
 * 7
 */

package leetcode;

class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2(int x) {
		val = x;
	}
}

public class TargetCopyNode {

	public final TreeNode2 getTargetCopy(final TreeNode2 original, final TreeNode2 cloned, final TreeNode2 target) {
		if (target == null || cloned == null) {
			return null;
		}
		if (target.val == cloned.val) {
			return cloned;
		}

		TreeNode2 tmp = getTargetCopy(original, cloned.left, target);
		if (tmp != null) {
			return tmp;
		}
		tmp = getTargetCopy(original, cloned.right, target);
		if (tmp != null) {
			return tmp;
		}

		return null;
	}

	public static void main(String[] args) {
		TreeNode2 root = new TreeNode2(10);
		root.left = new TreeNode2(5);
		root.right = new TreeNode2(15);
		root.left.left = new TreeNode2(3);
		root.left.right = new TreeNode2(7);
		root.right.right = new TreeNode2(18);

		TreeNode2 root2 = new TreeNode2(10);
		root2.left = new TreeNode2(5);
		root2.right = new TreeNode2(15);
		root2.left.left = new TreeNode2(3);
		root2.left.right = new TreeNode2(7);
		root2.right.right = new TreeNode2(18);

		TargetCopyNode tgt = new TargetCopyNode();
		TreeNode2 copyNode = tgt.getTargetCopy(root, root2, root.left.right);
		System.out.println(copyNode.val);
	}

}
