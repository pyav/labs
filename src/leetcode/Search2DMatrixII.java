/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * Output:
 * ------
 * true
 */

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int startCol = matrix[0].length-1;
        while (startRow < matrix.length && startCol >= 0) {
            int val = matrix[startRow][startCol];
            if (target < val) {
                startCol--;
            } else if (target > val) {
                startRow++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        System.out.println(new Search2DMatrixII().searchMatrix(matrix1, 5));
    }
}

