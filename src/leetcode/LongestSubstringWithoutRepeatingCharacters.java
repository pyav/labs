/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Output:
 * ------
 * 3
 * 1
 * 3
 * 0
 */

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int len = 0, max = 0, i = 0, curr = i;
        Set<Character> set = new HashSet<>();

        while(i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                len++;
                i++;
                if (len > max) {
                    max = len;
                }
            } else {
                int k = curr;
                while(k < i) {
                    set.remove(s.charAt(k));
                    len--;
                    k++;
                    if (!set.contains(s.charAt(i))) {
                        break;
                    }
                }
                curr = k;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
    }

}

