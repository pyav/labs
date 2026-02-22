/**
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
 * 
 * Output:
 * ------
 * 0
 * 2
 * 5
 * 0
 */

public class MinInsertStringPalindrome {

	public int minInsertions(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        
        for (int len = 2; len <= n; len++) {
        	for (int l = 0; l <= n - len; l++) {
        		int h = l+len-1;
        		if (s.charAt(l) == s.charAt(h)) {
        			memo[l][h] = memo[l+1][h-1];
        		} else {
        			memo[l][h] = 1 + Math.min(memo[l+1][h], memo[l][h-1]); 
        		}
        	}
        }
        return memo[0][n-1];
    }
	
	public static void main(String[] args) {
		System.out.println(new MinInsertStringPalindrome().minInsertions("zzazz"));
		System.out.println(new MinInsertStringPalindrome().minInsertions("mbadm"));
		System.out.println(new MinInsertStringPalindrome().minInsertions("leetcode"));
		System.out.println(new MinInsertStringPalindrome().minInsertions("e"));
	}

}
