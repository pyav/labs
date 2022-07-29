/**
 * https://leetcode.com/problems/edit-distance/
 *
 * Output:
 * ------
 * 2
 * 3
 * 5
 */

package leetcode;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] len = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            len[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            len[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    len[i][j] = len[i-1][j-1];
                } else {
                    len[i][j] = 1 + Math.min(Math.min(len[i-1][j], len[i][j-1]), len[i-1][j-1]);
                }
            }
        }
        return len[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("sunday", "satday"));
        System.out.println(new EditDistance().minDistance("horse", "ros"));
        System.out.println(new EditDistance().minDistance("intention", "execution"));
    }

}

