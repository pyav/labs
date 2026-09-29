/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
 *
 * Output:
 * ------
 * dcba
 * iloveu
 * leetcode
 * ataabc
 */

import java.util.Stack;

public class ReverseSubstring {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == ')') {
                StringBuilder sb = new StringBuilder();
                while(!stack.peek().equals("(")) {
                    StringBuilder tmp = new StringBuilder(stack.pop());
                    sb.append(tmp.reverse());
                }
                stack.pop();
                stack.push(sb.toString());
            } else {
                stack.push(Character.toString(ch));
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSubstring().reverseParentheses("(abcd)"));
        System.out.println(new ReverseSubstring().reverseParentheses("(u(love)i)"));
        System.out.println(new ReverseSubstring().reverseParentheses("(ed(et(oc))el)"));
        System.out.println(new ReverseSubstring().reverseParentheses("(a)(cba(ta))"));
    }
}

