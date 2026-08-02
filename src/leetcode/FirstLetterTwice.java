/**
 * https://leetcode.com/problems/first-letter-to-appear-twice/description/
 *
 * Output:
 * ------
 * c
 * d
 */

public class FirstLetterTwice {
    public char repeatedCharacter(String s) {
        int[] count = new int[26];
        for (char t : s.toCharArray()) {
            if (count[t-'a'] == 1) {
                return t;
            }
            count[t-'a'] += 1;
        }
        return 'a';
    }

    public static void main(String[] args) {
        System.out.println(new FirstLetterTwice().repeatedCharacter("abccbaacz"));
        System.out.println(new FirstLetterTwice().repeatedCharacter("abcdd"));
    }
}
