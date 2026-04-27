/**
 * https://leetcode.com/problems/find-common-characters/
 * 
 *  Output:
 *  ------
 *  e l l 
 *  c o 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CommonCharacters {

	public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, 0);
        
        for (char c : words[0].toCharArray()) {
       		count[c - 'a']++;
       	}
        
        for (int i = 1; i < words.length; i++) {
        	int[] tmp = new int[26];
        	Arrays.fill(tmp, 0);
        	
        	for (char c : words[i].toCharArray()) {
        		tmp[c - 'a']++;
        	}
        	
        	for (int j = 0; j < 26; j++) {
        		count[j] = Math.min(count[j], tmp[j]);
        	}
        }
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
        	for (int j = 0; j < count[i]; j++) {
        		result.add(String.valueOf((char) ('a' + i)));
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String[] words = {"bella", "label", "roller"};
		List<String> result = new CommonCharacters().commonChars(words);
		result.stream().forEach(x -> System.out.printf("%s ", x));
		System.out.println();
		String[] words2 = {"cool", "lock", "cook"};
		List<String> result2 = new CommonCharacters().commonChars(words2);
		result2.stream().forEach(x -> System.out.printf("%s ", x));
		System.out.println();
	}

}
