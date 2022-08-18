/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Output:
 * ------
 * true
 * true
 * false
 * true
 * true
 * true
 */

public class ValidPalindrome2 {

    private boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int len = s.length();
        int i = 0;
        for (; i < len/2;) {
            if (s.charAt(i) == s.charAt(len - i - 1)) {
                i++;
            } else {
                break;
            }
        }
        if (i == len/2) {
            return true;
        } else {
            return isPalindrome(s.substring(i, len - i - 1)) ||
                    isPalindrome(s.substring(i+1, len - i));
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome2().validPalindrome("aba"));
        System.out.println(new ValidPalindrome2().validPalindrome("abca"));
        System.out.println(new ValidPalindrome2().validPalindrome("abc"));
        System.out.println(new ValidPalindrome2().validPalindrome("a"));
        System.out.println(new ValidPalindrome2().validPalindrome("aa"));
        System.out.println(new ValidPalindrome2().validPalindrome("dbbd"));
    }

}

