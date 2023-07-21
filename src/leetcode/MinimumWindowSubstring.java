/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * Output:
 * ------
 * BANC
 * a
 *  
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class MinimumWindowSubstring {

    private Map<Character, Integer> getCountMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }
        return map;
    }

    private boolean isExistMap(Map<Character, Integer> strMap, Map<Character, Integer> map) {
        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (strMap.containsKey(entry.getKey())) {
                if (strMap.get(entry.getKey()) >= entry.getValue()) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        String resultStr = "", minStr = "";

        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> mapOfT = getCountMap(t);
        resultStr = s.substring(0, t.length()-1);
        Map<Character, Integer> mapOfS = getCountMap(resultStr);
        int curr = t.length()-2, minLen = Integer.MAX_VALUE, i = curr;

        while(curr < s.length()) {
            i++;
            resultStr += String.valueOf(s.charAt(i));
            mapOfS.put(s.charAt(i), mapOfS.getOrDefault(s.charAt(i), 0)+1);

            while(isExistMap(mapOfS, mapOfT)) {
                if (resultStr.length() < minLen) {
                    minLen = resultStr.length();
                    minStr = resultStr;
                }
                char prev = resultStr.charAt(0);
                mapOfS.put(prev, mapOfS.get(prev)-1);
                resultStr = resultStr.substring(1, resultStr.length());
                curr++;
            }
            if (i == s.length() - 1) {
                while(curr < s.length()) {
                    if (!isExistMap(mapOfS, mapOfT)) {
                        break;
                    }
                    if (isExistMap(mapOfS, mapOfT) && resultStr.length() < minLen) {
                        minLen = resultStr.length();
                        minStr = resultStr;
                    }
                    char prev = resultStr.charAt(0);
                    mapOfS.put(prev, mapOfS.get(prev)-1);
                    resultStr = resultStr.substring(1, resultStr.length());
                    curr++;
                }
                break;
            }
        }

        return minStr;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "aa"));
    }

}

