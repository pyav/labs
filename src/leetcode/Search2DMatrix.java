/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Output:
 * ------
 * true
 * false
 * true
 * true
 * true
 * true
 * false
 * true
 * false
 * true
 * true
 */

public class Search2DMatrix {
    private boolean isPresent(int[][]matrix, int row, int target) {
        int startCol = 0;
        int endCol = matrix[row].length-1;

        if (startCol == endCol) {
            if (matrix[row][endCol] == target) {
                return true;
            }
            return false;
        }

        while (startCol <= endCol) {
            if (startCol == endCol) {
                if (matrix[row][endCol] == target) {
                    return true;
                }
                return false;
            }
            int mid = (startCol + endCol)/2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                startCol = mid + 1;
            } else {
                endCol = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int endRow = matrix.length-1;
        while (startRow <= endRow) {
            if (startRow == endRow) {
                return isPresent(matrix, startRow, target);
            }
            int mid = (startRow + endRow)/2;
            if (target < matrix[mid][matrix[0].length-1]) {
                if (target > matrix[mid][0]) {
                    return isPresent(matrix, mid, target);
                } else if (target == matrix[mid][0]) {
                    return true;
                }
                endRow = mid - 1;
            } else if (target > matrix[mid][matrix[0].length-1]) {
                startRow = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix1, 3));
        int[][] matrix2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix2, 13));
        int[][] matrix3 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix3, 30));
        int[][] matrix4 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix4, 16));
        int[][] matrix5 = {{1}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix5, 1));
        int[][] matrix6 = {{1,3}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix6, 1));
        int[][] matrix7 = {{1,3}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix7, 11));
        int[][] matrix8 = {{1}, {3}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix8, 3));
        int[][] matrix9= {{1}, {3}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix9, 11));
        int[][] matrix10= {{1,3}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix10, 3));
        int[][] matrix11 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix11, 10));
    }
}

