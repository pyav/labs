/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Output:
 * ------
 * lee(t(c)o)de
 *
 * ab(c)d
 * 
 * 
 * 
 * a(b(c)d)
 */

package leetcode;

import java.util.Stack;

class Node {
	Character val;
	int index;

	Node(Character val, int index) {
		this.val = val;
		this.index = index;
	}
}

public class MinimumRemoveToMakeValidParentheses {

	public String minRemoveToMakeValid(String s) {
		Stack<Node> nodeStack = new Stack<Node>();
		int idx = -1;

		for (Character c : s.toCharArray()) {
			idx++;
			if (c == '(') {
				nodeStack.push(new Node(c, idx));
			} else if (c == ')') {
				if (!nodeStack.isEmpty() && nodeStack.peek().val == '(') {
					nodeStack.pop();
				} else {
					nodeStack.push(new Node(c, idx));
				}
			}
		}

		StringBuilder str = new StringBuilder();
		for (idx = s.length() - 1; idx >= 0; idx--) {
			if (!nodeStack.isEmpty() && idx == nodeStack.peek().index) {
				nodeStack.pop();
			} else {
				str.append(s.charAt(idx));
			}
		}

		return str.reverse().toString();
	}

	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s));
		System.out.println();
		s = "a)b(c)d";
		System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s));
		System.out.println();
		s = "))((";
		System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s));
		System.out.println();
		s = "(a(b(c)d)";
		System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s));
	}

}
