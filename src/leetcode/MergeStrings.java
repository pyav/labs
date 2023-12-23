/**
 * https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 * 
 * Output:
 * ------
 * apbqcr
 * apbqrs
 * apbqcd
 */

public class MergeStrings {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int i = 0, j = 0;
        for (; i < word1.length() && j < word2.length(); i++, j++) {
            result += word1.charAt(i);
            result += word2.charAt(j);
        }
        if (i == word1.length() && j < word2.length()) {
            result += word2.substring(j, word2.length());
        } else if (j == word2.length() && i < word1.length()) {
            result += word1.substring(i, word1.length());
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new MergeStrings().mergeAlternately("abc", "pqr"));
        System.out.println(new MergeStrings().mergeAlternately("ab", "pqrs"));
        System.out.println(new MergeStrings().mergeAlternately("abcd", "pq"));
    }
}

