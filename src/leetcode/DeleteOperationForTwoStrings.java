/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * Output:
 * ------
 * 2
 * 4
 * 4
 * 12
 * 4
 */

import java.util.Arrays;

public class DeleteOperationForTwoStrings {

    private int getLCS(char[] X, char[] Y, int m, int n) {
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

    public int minDistance(String word1, String word2) {
        int lcsLen = getLCS(word1.toCharArray(), word2.toCharArray(),
                        word1.length(), word2.length());
        return word1.length()+word2.length()-2*lcsLen;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteOperationForTwoStrings().minDistance("sea", "eat"));
        System.out.println(new DeleteOperationForTwoStrings().minDistance("leetcode", "etco"));
        System.out.println(new DeleteOperationForTwoStrings().minDistance("etco", "leetcode"));
        System.out.println(new DeleteOperationForTwoStrings().minDistance("pyav", "leetcode"));
        System.out.println(new DeleteOperationForTwoStrings().minDistance("sea", "ate"));
    }

}

