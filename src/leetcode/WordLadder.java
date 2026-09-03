/**
 * https://leetcode.com/problems/word-ladder/
 *
 * Output:
 * ------
 * 5
 * 0
 */

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int ans = 1;
        
        while (!q.isEmpty()) {
            ans++;
            for (int i = q.size(); i > 0; i--) {
                String s = q.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[j] = k;
                        String t = new String(chars);
                        if (!words.contains(t)) {
                            continue;
                        }
                        if (endWord.equals(t)) {
                            return ans;
                        }
                        q.offer(t);
                        words.remove(t);
                    }
                    chars[j] = ch;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}

