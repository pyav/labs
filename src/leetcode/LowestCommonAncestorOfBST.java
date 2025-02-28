/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * Output:
 * ------
 *
 *
 *
 */

class TreeNodee {
    int val;
    TreeNodee left;
    TreeNodee right;
    TreeNodee(int x) { val = x; }
}

public class LowestCommonAncestorOfBST {
    public TreeNodee lowestCommonAncestor(TreeNodee root, TreeNodee p, TreeNodee q) {
        if (null == root) {
            return root;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNodee root = new TreeNodee(6);
        root.left = new TreeNodee(2);
        root.right = new TreeNodee(8);
        root.left.left = new TreeNodee(0);
        root.left.right = new TreeNodee(4);
        root.right.left = new TreeNodee(7);
        root.right.right = new TreeNodee(9);

        TreeNodee valNode = new LowestCommonAncestorOfBST().lowestCommonAncestor(
                            root, root.left.left, root.right.right
                           );
        if (valNode == null) {
            System.out.println("No common ancestor found!");
        } else {
            System.out.println(valNode.val);
        }
    }
}

