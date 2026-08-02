/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/?envType=problem-list-v2&envId=queue
 *
 * Output:
 * ------
 * 0
 * 2
 */

import java.util.*;

public class FirstUnique {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
        for (char t : s.toCharArray()) {
            lhm.put(t, lhm.getOrDefault(t, 0)+1);
        }
        for (Map.Entry<Character, Integer> entry : lhm.entrySet()) {
            if (1 == entry.getValue()) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUnique().firstUniqChar("leetcode"));
        System.out.println(new FirstUnique().firstUniqChar("loveleetcode"));
    }
}
