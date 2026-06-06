/**
 * https://leetcode.com/problems/group-anagrams/
 * 
 * Output:
 * ------
 * tan nat 
 * tea ate eat 
 * bat 
 */

import java.util.*;

public class GroupAnagramsII {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> list = map.getOrDefault(new String(chars), new ArrayList<String>());
            list.add(str);
            map.put(new String(chars), list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        List<List<String>> result = new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List<String> list : result) {
            list.stream().forEach(x -> System.out.printf("%s ", x));
            System.out.println();
        }
    }
}

