/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Output:
 * ------
 * bab
 * bb
 * a
 * a
 * ddddadddd
 * z
 * asdfasdffdsafdsa
 * aaaaaaaaaaaa
 */

package leetcode;

public class LongestPalindromicSubstring {

	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public String longestPalindrome(String s) {
		String longestPalindromeStr = s.substring(0, 1);
		int maxLen = 1;

		for (int i = 2; i <= s.length(); i++) {
			int k = 0;
			String subStr = s.substring(k, k + i);

			while ((k + i - 1 < s.length()) && !isPalindrome(subStr)) {
				subStr = s.substring(k, k + i);
				k = k + 1;
			}
			if (isPalindrome(subStr)) {
				if (maxLen < subStr.length()) {
					maxLen = subStr.length();
					longestPalindromeStr = subStr;
				}
			}
		}
		return longestPalindromeStr;
	}

	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("ddddadddd"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("ztw"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("asdfasdffdsafdsa"));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaaaaaaaaaaa"));
	}

}
