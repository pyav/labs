/**
 * https://leetcode.com/problems/word-break/
 *
 * Output:
 * ------
 * true
 * true
 * false
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class WordBreak2 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] check = new boolean[len+1];
        Arrays.fill(check, false);

        for (int i = 1; i <= len; i++) {
            if (check[i] == false && wordDict.contains(s.substring(0, i))) {
                check[i] = true;
            }
            if (check[i] == true) {
                if (i == len){ 
                    return true;
                }
                for (int j = i+1; j <= len; j++){
                    if (check[j] == false && wordDict.contains(s.substring(i, j))) {
                        check[j] = true;
                    }
                    if (check[j] == true && j == len) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>(Arrays.asList("leet", "code"));
        System.out.println(new WordBreak2().wordBreak("leetcode", list1));
        List<String> list2 = new ArrayList<String>(Arrays.asList("apple", "pen"));
        System.out.println(new WordBreak2().wordBreak("applepenapple", list2));
        List<String> list3 = new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(new WordBreak2().wordBreak("catsandog", list3));
    }

}

