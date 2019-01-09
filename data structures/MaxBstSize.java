/**
 * Find the size of the largest BST subtree in a given Binary Tree.
 *
 * Output
 * ------
 * 
 * Size of the largest BST: 6
 * 
 * 
 * @Author pyav
 */

// The Node class which represents a node in the tree
class Node {
  int data;
  Node left;
  Node right;

  Node(int d) {
    data = d;
    left = null;
    right = null;
  }
}

// The Value class to store the values
class Value {
  int maxSize = 0;
  boolean isBst = false;
  int leftMax = Integer.MIN_VALUE;
  int rightMin = Integer.MAX_VALUE;
}

public class MaxBstSize {

  Node root;
  Value val = new Value();

  int largestBst(Node root) {
    largestBstSize(root, val, val, val, val);
    return val.maxSize;
  }

  int largestBstSize(Node node, Value maxSizeObj, Value isBstObj, 
      Value leftMaxObj, Value rightMinObj)
  {
    if (node == null) {
      isBstObj.isBst = true;
      return 0;
    }

    boolean isLeftBst = false; 
    boolean isRightBst = false;
    int min = Integer.MAX_VALUE;
    int leftSubTreeSize = 0;
    int rightSubTreeSize = 0;
    int calcSize = 0;

    maxSizeObj.leftMax = Integer.MIN_VALUE;
    leftSubTreeSize = largestBstSize(node.left, maxSizeObj, isBstObj, 
                                     leftMaxObj, rightMinObj);

    if (isBstObj.isBst == true && node.data > maxSizeObj.leftMax)
    {
      isLeftBst = true;
    }

    min = rightMinObj.rightMin;
    rightMinObj.rightMin = Integer.MAX_VALUE;

    rightSubTreeSize = largestBstSize(node.right, maxSizeObj, isBstObj,
                                      leftMaxObj, rightMinObj); 

    if (isBstObj.isBst == true && node.data < rightMinObj.rightMin)
    {
      isRightBst = true;
    }

    if (min < rightMinObj.rightMin) {
      rightMinObj.rightMin = min;
    }
    if (node.data < rightMinObj.rightMin) {
      rightMinObj.rightMin = node.data;
    }
    if (node.data > leftMaxObj.leftMax) {
      leftMaxObj.leftMax = node.data;
    }

    if (isRightBst && isLeftBst) {
      calcSize = rightSubTreeSize + leftSubTreeSize + 1;

      if (calcSize > maxSizeObj.maxSize)
      {
        maxSizeObj.maxSize = calcSize;
      }

      return calcSize;
    } else {
      isBstObj.isBst = false;
      return 0;
    }
  }

  public static void main(String[] args) {
    // Construct the Binary Tree
    MaxBstSize tree = new MaxBstSize();
    tree.root = new Node(50);
    tree.root.left = new Node(10);
    tree.root.right = new Node(60);
    tree.root.left.left = new Node(5);
    tree.root.left.right = new Node(20);
    tree.root.right.left = new Node(55);
    tree.root.right.left.left = new Node(45);
    tree.root.right.right = new Node(70);
    tree.root.right.right.left = new Node(65);
    tree.root.right.right.right = new Node(80);

    // Print the size of the largest Binary Search Tree 
    // within the given Binary Tree 
    System.out.println("Size of the largest BST: " + tree.largestBst(tree.root));
  }
}
