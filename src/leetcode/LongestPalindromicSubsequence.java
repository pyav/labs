/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 * 
 * Output:
 * ------
 * 4
 * 2
 */

public class LongestPalindromicSubsequence {
	
	public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (i+1 == j) dp[i][j] = 2;
                    else dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }

	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
		System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("cbbd"));
	}

}
