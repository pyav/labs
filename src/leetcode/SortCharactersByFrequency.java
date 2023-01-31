/**
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * Output:
 * ------
 * eetr
 * cccaaa
 * bbaA
 */

import java.util.*;
import java.util.Map.Entry;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        int[] count = new int[62];
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='A' && s.charAt(i)<='Z') {
                count[s.charAt(i)-'A']++;
            } else if (s.charAt(i)>='a' && s.charAt(i)<='z') {
                count[(s.charAt(i)-'a')+26]++;
            } else {
                count[(s.charAt(i)-'0')+52]++;
            }
        }
        SortedMap<Integer, List<Character>> map = new TreeMap<Integer, List<Character>>();
	    for (int i = 0; i < count.length; i++) {
	        if (count[i]>0) {
	            List<Character> list = null;
                if (map.containsKey(count[i])) {
                    list = map.get(count[i]);
                } else {
                    list = new LinkedList<Character>();
                }
	            if (i>=0 && i<=25) {
		            list.add((char)('A'+i));
	            } else if (i>=26 && i <= 51) {
		            list.add((char)('a'+(i-26)));
	            } else {
		            list.add((char)('0'+(i-52)));
	            }
                map.put(count[i], list);
	        }
	    }
        String result = "";
        for(Entry<Integer, List<Character>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Character> list = entry.getValue();
            for (Character item : list) {
                for (int i = 0; i < key; i++) {
                    result += item;
                }
            }
        }
        return new StringBuilder().append(result).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
        System.out.println(new SortCharactersByFrequency().frequencySort("cccaaa"));
        System.out.println(new SortCharactersByFrequency().frequencySort("Aabb"));
    }

}

