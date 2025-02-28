/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
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

public class LowestCommonAncestor {
    public TreeNodee lowestCommonAncestor(TreeNodee root, TreeNodee p, TreeNodee q) {
        if (null == root) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNodee leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNodee rightLca = lowestCommonAncestor(root.right, p, q);

        if (leftLca != null && rightLca != null) {
            return root;
        }
        return (leftLca != null)? leftLca : rightLca;
    }

    public static void main(String[] args) {
        TreeNodee root = new TreeNodee(1);
        root.left = new TreeNodee(2);
        root.right = new TreeNodee(3);
        root.left.left = new TreeNodee(4);
        root.left.right = new TreeNodee(5);
        root.right.left = new TreeNodee(6);
        root.right.right = new TreeNodee(7);

        TreeNodee valNode = new LowestCommonAncestor().lowestCommonAncestor(
                            root, root.left.left, root.right.right
                           );
        if (valNode == null) {
            System.out.println("No common ancestor found!");
        } else {
            System.out.println(valNode.val);
        }
    }
}

