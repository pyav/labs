/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
 *
 * Output:
 * ------
 * 2
 * 7
 * 4
 */

public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] count = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            count[allowed.charAt(i)-'a'] = true;
        }
        int sum = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!count[word.charAt(i)-'a']) {
                    break;
                }
                if (i == word.length()-1) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String allowed1 = "ab";
        String[] words1 = {"ad","bd","aaab","baa","badab"};
        System.out.println(new CountConsistentStrings().countConsistentStrings(allowed1, words1));
        String allowed2 = "abc";
        String[] words2 = {"a","b","c","ab","ac","bc","abc"};
        System.out.println(new CountConsistentStrings().countConsistentStrings(allowed2, words2));
        String allowed3 = "cad";
        String[] words3 = {"cc","acd","b","ba","bac","bad","ac","d"};
        System.out.println(new CountConsistentStrings().countConsistentStrings(allowed3, words3));
    }

}

