/**
 * This program finds the length of longest common subsequence using dynamic
 * programming techniques.
 *
 * Output:
 * ------
 * 4
 */

public class LongestCommonSubsequence {

    public int getLcsLen(char[] X, char[] Y, int m, int n) {
        int[][] lcsLen = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            lcsLen[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            lcsLen[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i-1] == Y[j-1]) {
                    lcsLen[i][j] = 1 + lcsLen[i-1][j-1];
                } else {
                    lcsLen[i][j] = Math.max(lcsLen[i-1][j], lcsLen[i][j-1]);
                }
            }
        }
        return lcsLen[m][n];
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(new
        LongestCommonSubsequence().getLcsLen(X.toCharArray(), Y.toCharArray(),
        X.length(), Y.length()));
    }

}

