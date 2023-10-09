/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * Output:
 * ------
 *
 */

public class RangeSum2D {
	int[][] matrix;

	public RangeSum2D(int[][] matrix) {
		this.matrix = matrix;
		for (int i = 0; i < matrix.length; i++) {
			for () {
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {

	}

	public static void main(String[] args) {
		int[][] matrix = {
				  {3,0,1,4,2},
				  {5,6,3,2,1},
				  {1,2,0,1,5},
				  {4,1,0,1,7},
				  {1,0,3,0,5}
				 };
		RangeSum2D obj = new RangeSum2D(matrix);
		System.out.println(obj.sumRegion(2,1,4,3));
		System.out.println(obj.sumRegion(1,1,2,2));
		System.out.println(obj.sumRegion(1,2,2,4));
	}
}

