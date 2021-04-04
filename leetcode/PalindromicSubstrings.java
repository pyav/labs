/**
 * https://leetcode.com/problems/palindromic-substrings/
 * 
 * Output:
 * ------
 * 7
 * 5
 * 1
 * 2
 * 3
 * 3
 * 24
 * 6
 */

package leetcode;

public class PalindromicSubstrings {

	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public int countSubstrings(String s) {
		int countPalindrome = s.length();

		for (int i = 2; i <= s.length(); i++) {
			int k = 0;

			while ((k + i - 1 < s.length())) {
				if (isPalindrome(s.substring(k, k + i))) {
					countPalindrome++;
				}
				k = k + 1;
			}
		}

		return countPalindrome;
	}

	public static void main(String[] args) {
		System.out.println(new PalindromicSubstrings().countSubstrings("babad"));
		System.out.println(new PalindromicSubstrings().countSubstrings("cbbd"));
		System.out.println(new PalindromicSubstrings().countSubstrings("a"));
		System.out.println(new PalindromicSubstrings().countSubstrings("ac"));
		System.out.println(new PalindromicSubstrings().countSubstrings("abc"));
		System.out.println(new PalindromicSubstrings().countSubstrings("ztw"));
		System.out.println(new PalindromicSubstrings().countSubstrings("asdfasdffdsafdsa"));
		System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));
	}

}
