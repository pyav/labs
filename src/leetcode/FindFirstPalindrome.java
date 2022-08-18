/**
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 *
 * Output:
 * ------
 * ada
 * 
 * racecar
 */

public class FindFirstPalindrome {

    private boolean isPalindrome(String word) {
        int len = word.length();
        for (int i = 0; i < len/2; i++) {
            if (word.charAt(i) != word.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(new FindFirstPalindrome().firstPalindrome(words));
        String[] words2 = {"def", "ghi"};
        System.out.println(new FindFirstPalindrome().firstPalindrome(words2));
        String[] words3 = {"notapalindrome","racecar"};
        System.out.println(new FindFirstPalindrome().firstPalindrome(words3));
    }

}

