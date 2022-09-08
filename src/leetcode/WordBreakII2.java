/**
 * https://leetcode.com/problems/word-break-ii/
 *
 * Output:
 * ------
 * cat sand dog
 * cats and dog
 * pineapple pen apple
 * pine applepen apple
 * pine apple pen apple
 */

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WordBreakII2 {

    private List<String> result = new ArrayList<String>();
    private Set<String> resultSet = new HashSet<String> ();

    private boolean calcWordBreak(String str, String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i)) &&
                    calcWordBreak(str+" " +s.substring(0,i),s.substring(i, s.length()), wordDict)) {
                resultSet.add((str+" "+s.substring(0,i)).trim());
            }
        }

        return false;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        calcWordBreak("", s, wordDict);
        result.addAll(resultSet);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII2 obj = new WordBreakII2();
        List<String> list1 = new ArrayList<String>(Arrays.asList("cat","cats","and","sand","dog"));
        List<String> result1 = obj.wordBreak("catsanddog", list1);
        for (Object str : result1) {
            System.out.println(str);
        }
        WordBreakII2 obj2 = new WordBreakII2();
        List<String> list2 = new ArrayList<String>(Arrays.asList("apple","pen","applepen","pine","pineapple"));
        List<String> result2 = obj2.wordBreak("pineapplepenapple", list2);
        for (Object str : result2) {
            System.out.println(str);
        }
        WordBreakII2 obj3 = new WordBreakII2();
        List<String> list3 = new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        List<String> result3 = obj3.wordBreak("catsandog", list3);
        for (Object str : result3) {
            System.out.println(str);
        }
    }

}

