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
        Set<String> current = new HashSet<>();
        current.add("()");
        n--;

        while(n > 0) {
            Set<String> next = new HashSet<>();
            for (String val : current) {
                for (int i = 0; i <= val.length(); i++) {
                    String creation = val.substring(0, i) + "()" + val.substring(i, val.length());
                    next.add(creation);
                }
            }
            current = next;
            n--;
        }

        return new ArrayList<>(current);
    }

    public static void main(String[] args) {
        List<String> result = new GenerateParentheses().generateParenthesis(3);
        for (String val : result) {
            System.out.println(val);
        }
    }
}

