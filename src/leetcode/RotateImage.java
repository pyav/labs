/**
 * https://leetcode.com/problems/rotate-image/
 *
 * Output:
 * ------
 * 7 4 1 
 * 8 5 2 
 * 9 6 3 
 * 15 13 2 5 
 * 14 3 4 1 
 * 12 6 8 9 
 * 16 7 10 11
 */

public class RotateImage {
    public void rotate(int[][] matrix) {
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

    public static void main(String[] args) {
        int[][] matrix = { {1,2,3},
            {4,5,6},
            {7,8,9} };
        new RotateImage().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
        int[][] matrix2 = { {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}};
        new RotateImage().rotate(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.printf("%d ", matrix2[i][j]);
            }
            System.out.println();
        }
 
    }
}

