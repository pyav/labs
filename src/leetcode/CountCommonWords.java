/**
 * https://leetcode.com/problems/count-common-words-with-one-occurrence/description/
 *
 * Output:
 * ------
 * 2
 * 0
 * 1
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCommonWords {
    public int countWords(String[] words1, String[] words2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        for (String word : words1) {
            set1.add(word);
            map.put(word, map.getOrDefault(word, -2)+1);
        }
        for (String word : words2) {
            set2.add(word);
            map.put(word, map.getOrDefault(word, -2)+1);
        }
        int result = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (0 == entry.getValue() && set1.contains(entry.getKey()) && set2.contains(entry.getKey())) {
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new CountCommonWords().countWords(new String[]{"leetcode","is","amazing","as","is"}, new String[]{"amazing","leetcode","is"}));
        System.out.println(new CountCommonWords().countWords(new String[]{"b","bb","bbb"}, new String[]{"a","aa","aaa"}));
        System.out.println(new CountCommonWords().countWords(new String[]{"a","ab"}, new String[]{"a","a","a","ab"}));
    }
}


