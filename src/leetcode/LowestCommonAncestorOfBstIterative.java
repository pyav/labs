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

public class LowestCommonAncestorOfBstIterative {
    public TreeNodee lowestCommonAncestor(TreeNodee root, TreeNodee p, TreeNodee q) {
        while (null != root) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
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

        TreeNodee valNode = new LowestCommonAncestorOfBstIterative().lowestCommonAncestor(
                            root, root.left.left, root.left.right
                           );
        if (valNode == null) {
            System.out.println("No common ancestor found!");
        } else {
            System.out.println(valNode.val);
        }
    }
}

