/**
 * Following program shows the storage of a tree in array format.
 * 
 * Output
 * ------
 * Root LeftChildOfRoot RightChildOfRoot null null null null 
 * 
 * @author pyav
 */

class NodeArray {

	static final int size = 7;
	String[] nodeArray = new String[size];

	public void setRoot(String rootKey) {

		nodeArray[0] = rootKey;
	}

	public void printNodeArray() {

		for (int i = 0; i < size; i++) {
			System.out.printf("%s ", nodeArray[i]);
		}
	}

	public void setLeftChild(int parent, String key) {

		nodeArray[(parent * 2) + 1] = key;
	}

	public void setRightChild(int parent, String key) {

		nodeArray[(parent * 2) + 2] = key;
	}

}

public class BinaryTreeArrayRepresentation {

	public static void main(String[] args) {

		NodeArray nodeArray = new NodeArray();
		nodeArray.setRoot("Root");
		nodeArray.setLeftChild(0, "LeftChildOfRoot");
		nodeArray.setRightChild(0, "RightChildOfRoot");
		nodeArray.printNodeArray();
	}

}
