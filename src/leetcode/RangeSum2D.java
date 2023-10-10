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
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j-1] + matrix[i][j];
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val = this.matrix[row2][col2];
        if (0 == row1) {
            if (col1 != 0) {
                val = val - this.matrix[row2][col1-1];
            }
        } else if (0 == col1) {
            if (row1 != 0) {
                val = val - this.matrix[row1-1][col2];
            }
        } else {
            val = val - this.matrix[row2][col1-1] - this.matrix[row1-1][col2] +
                    this.matrix[row1-1][col1-1];
        }
        return val;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
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
        obj.printMatrix(matrix);
        System.out.println(obj.sumRegion(2,1,4,3));
        System.out.println(obj.sumRegion(1,1,2,2));
        System.out.println(obj.sumRegion(1,2,2,4));
    }
}

