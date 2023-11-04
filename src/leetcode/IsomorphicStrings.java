package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapStoT = new HashMap<Character, Character>();
        Map<Character, Character> mapTtoS = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);
            if (!mapStoT.containsKey(charS)) {
                if (mapTtoS.containsKey(charT)) {
                    return false;
                }
                mapStoT.put(charS, t.charAt(i));
                mapTtoS.put(charT, s.charAt(i));
            } else {
                if (t.charAt(i) != mapStoT.get(charS) || s.charAt(i) != mapTtoS.get(charT)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
        System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
        System.out.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
        System.out.println(new IsomorphicStrings().isIsomorphic("badc", "baba"));
    }
}
