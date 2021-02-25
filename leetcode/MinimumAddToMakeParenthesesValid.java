/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 *
 * Output:
 * ------
 * 0
 * 0
 * 3
 * 0
 * 1
 * 4
 * 5
 */

package leetcode;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        if (S == null || S.isEmpty()) {
            return 0;
        }

        Stack<Character> stack = new Stack<Character> (); 
        int count = 0;

        for (Character c : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                count++;
            } else {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                    count--;
                } else {
                    stack.push(c);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s));
        s = "()";
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s));
        s = "(((";
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s));
        s = "()";
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s));
        s = "())";
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s));
        s = "()))((";
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s));
        s = ")))((";
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid(s));
    }
}

