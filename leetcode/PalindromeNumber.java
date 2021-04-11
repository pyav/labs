/**
 * https://leetcode.com/problems/palindrome-number/
 * 
 * Output:
 * ------
 * false
 */

package leetcode;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		
		int orig = x, rev = 0;
		while (x > 0) {
			rev = rev * 10 + (x % 10);
			x = x / 10;
		}

		return (orig == rev);
	}

	public static void main(String[] args) {
		System.out.printf("%s", new PalindromeNumber().isPalindrome(1234567899));
	}

}
