/**
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * Output:
 * ------
 * true
 * false
 * true
 * true
 * true
 * false
 */

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		int len = s.length();

		for (int i = 0, j = len - 1; i < j;) {
			int first = Integer.valueOf(s.charAt(i));
			int second = Integer.valueOf(s.charAt(j));

			if ((first >= 65 && first <= 90) || (first >= 97 && first <= 122) || (first >= 48 && first <= 57)) {
				if ((second >= 65 && second <= 90) || (second >= 97 && second <= 122) || (second >= 48 && second <= 57)) {
                    if (first >= 48 && first <= 57) {
                        if (second >= 48 && second <= 57) {
                            if (first != second) {
                                return false;
                            } else {
                                i++;
                                j--;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        if (second >= 48 && second <= 57){
                            return false;
                        } else {
                            if ((first - second != 0) && Math.abs(first - second) != 32) {
                                return false;
                            } else {
                                i++;
                                j--;
                            }
                        }
                    }
                } else {
                    j--;
                }
			} else {
                i++;
            }
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(new ValidPalindrome().isPalindrome("race a car"));
		System.out.println(new ValidPalindrome().isPalindrome(" "));
		System.out.println(new ValidPalindrome().isPalindrome(";:;:aa"));
		System.out.println(new ValidPalindrome().isPalindrome("aa;;;;;;"));
		System.out.println(new ValidPalindrome().isPalindrome("ab aa;;;;;;"));
	}

}
