/**
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 *
 * Output:
 * ------
 *
 */

public class EditDistance {

    public int lenDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] len = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            len[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            len[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    len[i][j] = len[i-1][j-1];
                } else {
                    len[i][j] = 1 + Math.min(Math.min(len[i-1][j], len[i][j-1]), len[i-1][j-1]);
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%d ", len[i][j]);
            }
            System.out.println();
        }
        return len[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().lenDistance("sunday", "satday"));
    }

}

