/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 *
 * Output:
 * ------
 * ca
 * ay
 * a
 */

import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (!stack.peek().equals(c)) {
                stack.push(c);
            } else {
                while (!stack.isEmpty() && stack.peek().equals(c)) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.insert(0, String.valueOf(stack.pop()));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveAdjacentDuplicates().removeDuplicates("abbaca"));
        System.out.println(new RemoveAdjacentDuplicates().removeDuplicates("azxxzy"));
        System.out.println(new RemoveAdjacentDuplicates().removeDuplicates("a"));
    }
}

