/**
 * https://leetcode.com/problems/backspace-string-compare/description/
 *
 * Output:
 * ------
 * true
 * true
 * false
 */

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(t.charAt(i));
            }
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Character c1 = stack1.pop();
            Character c2 = stack2.pop();
            if (c1 != c2) {
                return false;
            }
        }
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare(new String("ab#c"), new String("ad#c")));
        System.out.println(new BackspaceStringCompare().backspaceCompare(new String("ab##"), new String("ad##")));
        System.out.println(new BackspaceStringCompare().backspaceCompare(new String("ab#c"), new String("adc")));
    }

}

