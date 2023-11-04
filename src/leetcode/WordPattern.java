package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] splitStr = s.split(" ");
        if (pattern.length() != splitStr.length) {
            return false;
        }
        Map<Character, String> mapPatterntoS = new HashMap<Character, String>();
        Map<String, Character> mapStoPattern = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length(); i++) {
            Character charPattern = pattern.charAt(i);
            String strS = splitStr[i];
            if (!mapPatterntoS.containsKey(charPattern)) {
                if (mapStoPattern.containsKey(strS)) {
                    return false;
                }
                mapPatterntoS.put(charPattern, strS);
                mapStoPattern.put(strS, charPattern);
            } else {
                if (!strS.equals(mapPatterntoS.get(charPattern)) ||
                        !charPattern.equals(mapStoPattern.get(strS))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new WordPattern().wordPattern("aaaa", "dog cat cat dog"));
    }
}
