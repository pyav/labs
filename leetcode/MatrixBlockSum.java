/**
 * https://leetcode.com/problems/matrix-block-sum/
 * 
 * Output:
 * ------
 * 12 12 
 * 27 27 
 * 43 43 
 * 34 34
 */

package leetcode;

public class MatrixBlockSum {

	public int[][] matrixBlockSum(int[][] mat, int k) {
		int[][] interMat = new int[mat.length + 1][mat[0].length + 1];
		for (int i = 0; i < interMat.length; i++) {
			interMat[i][0] = 0;
		}
		for (int j = 0; j < interMat[0].length; j++) {
			interMat[0][j] = 0;
		}
		for (int j = 1; j < interMat[0].length; j++) {
			for (int i = 1; i < interMat.length; i++) {
				interMat[i][j] = interMat[i - 1][j] + mat[i - 1][j - 1];
			}
		}

		int[][] interMat2 = new int[interMat.length][interMat[0].length];
		for (int i = 0; i < interMat2.length; i++) {
			interMat2[i][0] = 0;
		}
		for (int j = 0; j < interMat2[0].length; j++) {
			interMat2[0][j] = 0;
		}
		for (int i = 1; i < interMat2.length; i++) {
			for (int j = 1; j < interMat2[0].length; j++) {
				interMat2[i][j] = interMat[i][j] + interMat2[i][j - 1];
			}
		}

		int[][] finalMat = new int[mat.length][mat[0].length];
		for (int i = 0; i < finalMat.length; i++) {
			for (int j = 0; j < finalMat[0].length; j++) {
				finalMat[i][j] = getFirstVal(interMat2, i + 1, j + 1, k) - getSecondVal(interMat2, i + 1, j + 1, k)
						- getThirdVal(interMat2, i + 1, j + 1, k) + getFourthVal(interMat2, i + 1, j + 1, k);
			}
		}

		return finalMat;
	}

	private int getFirstVal(int[][] interMat2, int i, int j, int k) {
		int finalRow = (i + 1 + k > interMat2.length) ? interMat2.length - 1 : i + k;
		int finalCol = (j + 1 + k > interMat2[0].length) ? interMat2[0].length - 1 : j + k;
		return interMat2[finalRow][finalCol];
	}

	private int getSecondVal(int[][] interMat2, int i, int j, int k) {
		if (j - k <= 1) {
			return 0;
		}
		int finalCol = j - k - 1;
		int finalRow = interMat2.length - 1;

		if (i + k < interMat2.length) {
			finalRow = i + k;
		}
		return interMat2[finalRow][finalCol];
	}

	private int getThirdVal(int[][] interMat2, int i, int j, int k) {
		if (i - k <= 1) {
			return 0;
		}
		int finalRow = i - k - 1;
		int finalCol = j + k;
		if (finalCol >= interMat2[0].length) {
			finalCol = interMat2[0].length - 1;
		}

		return interMat2[finalRow][finalCol];
	}

	private int getFourthVal(int[][] interMat2, int i, int j, int k) {
		int finalRow = i - k - 1;
		if (finalRow < 1) {
			return 0;
		}

		int finalCol = j - k - 1;
		if (finalCol < 1) {
			return 0;
		}

		return interMat2[finalRow][finalCol];
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2 }, { 4, 5 }, { 7, 8 }, { 9, 10 } };
		int[][] result = new MatrixBlockSum().matrixBlockSum(mat, 1);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.printf("%d ", result[i][j]);
			}
			System.out.println();
		}
	}

}
