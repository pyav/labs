/**
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * Output:
 * ------
 * ()()
 * (())
 */

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("()");
        n--;

        while(n > 0) {
            int size = q.size();
            Set<String> set = new HashSet<>();
            while(size > 0) {
                String val = q.poll();
                for (int i = 0; i <= val.length(); i++) {
                    String creation = val.substring(0, i) + "()" + val.substring(i, val.length());
                    if (set.contains(creation)) {
                        continue;
                    }
                    set.add(creation);
                    q.add(creation);
                }
                size--;
            }
            n--;
        }

        return new ArrayList<>(q);
    }

    public static void main(String[] args) {
        List<String> result = new GenerateParentheses().generateParenthesis(2);
        for (String val : result) {
            System.out.println(val);
        }
    }
}

