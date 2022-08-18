/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Output:
 * ------
 * true
 * false
 */

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        int len1 = s.length();
        int len2 = t.length();

        if (len1 != len2) {
            return false;
        }
        for (int i = 0 ; i < len1; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0 ; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
        System.out.println(new ValidAnagram().isAnagram("rat", "car"));
    }

}

