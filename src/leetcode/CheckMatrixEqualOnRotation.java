/**
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 *
 * Output:
 * ------
 * true
 * true
 * false
 */

public class CheckMatrixEqualOnRotation {
    private boolean isMatrixEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void rotateMatrix(int[][] matrix) {
        int tempRow = matrix.length;
        int tempCol = matrix[0].length - 1;
        int n = matrix.length;
        for (int i = 0; i < tempRow; i++) {
            for (int j = i; j < tempCol; j++) {
                int temp = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = temp;
            }

            tempCol = tempCol - 1;
            tempRow = tempRow - 1;
        }
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        if (isMatrixEqual(mat, target)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            rotateMatrix(mat);
            if (isMatrixEqual(mat, target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0}, {0,1,0}, {1,1,1}};
        int[][] target = {{1,1,1}, {0,1,0}, {0,0,0}};
        System.out.println(new CheckMatrixEqualOnRotation().findRotation(mat, target));
        int[][] mat2 = {{0,1}, {1,0}};
        int[][] target2 = {{1,0}, {0,1}};
        System.out.println(new CheckMatrixEqualOnRotation().findRotation(mat2, target2));
        int[][] mat3 = {{0,1}, {1,1}};
        int[][] target3 = {{1,0}, {0,1}};
        System.out.println(new CheckMatrixEqualOnRotation().findRotation(mat3, target3));
    }
}

