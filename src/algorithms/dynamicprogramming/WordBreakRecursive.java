/**
 * Following program shows word break problem using recursion.
 *
 * Output:
 * ------
 * true
 * false
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class WordBreakRecursive {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))  &&
                (wordBreak(s.substring(i, s.length()), wordDict))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> list2 = new ArrayList<String>(Arrays.asList("apple", "pen"));
        System.out.println(new WordBreakRecursive().wordBreak("applepenapple", list2));
        List<String> list3 = new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(new WordBreakRecursive().wordBreak("catsandog", list3));
    }

}

