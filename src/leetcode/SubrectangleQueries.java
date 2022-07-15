/**
 * https://leetcode.com/problems/subrectangle-queries/
 * 
 * Output:
 * ------
 * 1
 * 5
 * 5
 * 10
 * 5
 */

package leetcode;

public class SubrectangleQueries {

	int[][] rectangle;

	public SubrectangleQueries(int[][] rectangle) {
		this.rectangle = rectangle;
	}

	public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
		for (int i = row1; i <= row2; i++) {
			for (int j = col1; j <= col2; j++) {
				this.rectangle[i][j] = newValue;
			}
		}
	}

	public int getValue(int row, int col) {
		return this.rectangle[row][col];
	}

	public static void main(String[] args) {
		int[][] rectangle = { { 1, 2, 1 }, { 4, 3, 4 }, { 3, 2, 1 }, { 1, 1, 1 } };
		SubrectangleQueries obj = new SubrectangleQueries(rectangle);
		System.out.println(obj.getValue(0, 2));
		obj.updateSubrectangle(0, 0, 3, 2, 5);
		System.out.println(obj.getValue(0, 2));
		System.out.println(obj.getValue(3, 1));
		obj.updateSubrectangle(3, 0, 3, 2, 10);
		System.out.println(obj.getValue(3, 1));
		System.out.println(obj.getValue(0, 2));
	}

}

