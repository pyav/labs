/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description
 *
 * Output:
 * ------
 * 0 6 
 * 0 1 2
 */

import java.util.*;

public class FindAllAnagrams {
    private boolean arrayEquals(int[] first, int[] second) {
       for (int i = 0; i <  first.length; i++) {
           if (first[i] != second[i]) {
               return false;
           }
       }
       return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] countP = new int[26];
        
        for (int i = 0; i < p.length(); i++) {
            countP[p.charAt(i)-'a']++;
        }

        int[] tmp = new int[26];

        for (int i = 0; i < p.length(); i++) {
            tmp[s.charAt(i) - 'a']++;
        }
        if (arrayEquals(countP, tmp)) {
            result.add(0);
        }

        for (int i = 1; i < s.length()-p.length()+1; i++) {
            tmp[s.charAt(i-1)-'a']--;
            tmp[s.charAt(i+p.length()-1)-'a']++;
            if (arrayEquals(countP, tmp)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new FindAllAnagrams().findAnagrams("cbaebabacd", "abc");
        result.stream().forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        List<Integer> result2 = new FindAllAnagrams().findAnagrams("abab", "ab");
        result2.stream().forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}

