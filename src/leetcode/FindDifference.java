/**
 * https://leetcode.com/problems/find-the-difference/description/
 *
 * Output:
 * ------
 * e
 * y
 */

import java.util.Arrays;

public class FindDifference {

    public char findTheDifference(String s, String t) {
        int[] sCount = new int[26];
        Arrays.fill(sCount, 0);
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i)-'a']++;
        }
        char result = '\0';
        for (int i = 0; i < t.length(); i++) {
            if (sCount[t.charAt(i)-'a'] == 0) {
                result = t.charAt(i);
                break;
            } else {
                sCount[t.charAt(i)-'a']--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindDifference().findTheDifference("abcd", "abcde"));
        System.out.println(new FindDifference().findTheDifference("", "y"));
    }

}

