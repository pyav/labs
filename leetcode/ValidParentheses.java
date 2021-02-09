/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Output:
 * ------
 * true
 * true
 * false
 * false
 * false
 * false
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (map.get(s.charAt(i)) != stack.pop()) {
					return false;
				}
			}
		}

		if (!stack.empty()) {
			return false;
		} else {
			return true;
		}
		
	}

	public static void main(String[] args) {
		String s = "()";
		System.out.print(new ValidParentheses().isValid(s));
		System.out.println();
		s = "(){}[]";
		System.out.print(new ValidParentheses().isValid(s));
		System.out.println();
		s = "(){}[{]";
		System.out.print(new ValidParentheses().isValid(s));
		System.out.println();
		s = "{";
		System.out.print(new ValidParentheses().isValid(s));
		System.out.println();
		s = "{}[";
		System.out.print(new ValidParentheses().isValid(s));
		System.out.println();
		s = "]";
		System.out.print(new ValidParentheses().isValid(s));
		System.out.println();
	}

}
