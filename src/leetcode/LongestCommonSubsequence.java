/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Output:
 * ------
 * 4
 * 3
 * 0
 */

package leetcode;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] lcsLen = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            lcsLen[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            lcsLen[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
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
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(X, Y));
        String X2 = "abcde";
        String Y2 = "ace";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(X2, Y2));
        String X3 = "abc";
        String Y3 = "de";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(X3, Y3));
    }

}

