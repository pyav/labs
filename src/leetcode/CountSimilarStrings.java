/**
 * https://leetcode.com/problems/count-pairs-of-similar-strings/description/
 *
 * Output:
 * ------
 * 2
 * 3
 */

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.HashMap;

public class CountSimilarStrings {

    private void calcStrUpdateMap(boolean[] str, Map<String, Integer> mapStrCount) {
    	String val = "";
        for (int i = 0; i < str.length; i++) {
            val = (str[i])? val+"1": val+"0";
        }
        mapStrCount.put(val, mapStrCount.getOrDefault(val, 0)+1);        
    }

    private boolean[] getBoolArr(String word) {
    	boolean[] chars = new boolean[26];
    	for (int i = 0; i < word.length(); i++) {
    		chars[word.charAt(i)-'a'] = true;
    	}
    	return chars;
    }

    public int similarPairs(String[] words) {
        Map<String, Integer> mapStrCount = new HashMap<String, Integer>();
        for (String word : words) {
        	boolean[] chars = getBoolArr(word);
        	calcStrUpdateMap(chars, mapStrCount);
        }
        int sum = 0;
        for (Entry<String, Integer> entry : mapStrCount.entrySet()) {
        	sum += (entry.getValue()>1)? (entry.getValue()*(entry.getValue()-1))/2: 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] words1 = {"aba","aabb","abcd","bac","aabc"};
        System.out.println(new CountSimilarStrings().similarPairs(words1));
        String[] words2 = {"aabb","ab","ba"};
        System.out.println(new CountSimilarStrings().similarPairs(words2));
    }

}

