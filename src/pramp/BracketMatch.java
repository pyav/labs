package pramp;

import java.util.Stack;

public class BracketMatch {
	static int bracketMatch(String text) {
		Stack<Character> stack = new Stack<Character>();
		for (Character item : text.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(item);
			} else {
				if (stack.peek() == '(' && item == ')') {
					stack.pop();
				} else {
					stack.push(item);
				}
			}
		}
		return stack.size();
	}

	public static void main(String[] args) {
		System.out.println(new BracketMatch().bracketMatch("(())("));
		System.out.println(new BracketMatch().bracketMatch("(())(("));
		System.out.println(new BracketMatch().bracketMatch("(())"));
		System.out.println(new BracketMatch().bracketMatch("(()"));
		System.out.println(new BracketMatch().bracketMatch("(("));
		System.out.println(new BracketMatch().bracketMatch(")))"));
	}
}
