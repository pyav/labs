/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 *
 * Output:
 * ------
 * sweet sour 
 * banana 
 * 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UncommonWords {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        String[] strArr1 = s1.split(" ");
        String[] strArr2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String t1 : strArr1) {
            set1.add(t1);
            map.put(t1, map.getOrDefault(t1, -2)+1);
        }
        for (String t2 : strArr2) {
            set2.add(t2);
            map.put(t2, map.getOrDefault(t2, -2)+1);
        }

        Set<String> outcome = new HashSet<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (-1 == entry.getValue()
                && ((set1.contains(entry.getKey()) && !set2.contains(entry.getKey()))
                    || (!set1.contains(entry.getKey()) && set2.contains(entry.getKey()))))
            {
                outcome.add(entry.getKey());
            }
        }

        return outcome.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] result = new UncommonWords().uncommonFromSentences("this apple is sweet", "this apple is sour");
        java.util.Arrays.stream(result).forEach(x -> System.out.printf("%s ", x));
        System.out.println();
        String[] result2 = new UncommonWords().uncommonFromSentences("apple apple", "banana");
        java.util.Arrays.stream(result2).forEach(x -> System.out.printf("%s ", x));
        System.out.println();
        String[] result3 = new UncommonWords().uncommonFromSentences("apple apple", "apple");
        java.util.Arrays.stream(result3).forEach(x -> System.out.printf("%s ", x));
        System.out.println();
    }
}

