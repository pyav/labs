/**
 * https://leetcode.com/problems/removing-stars-from-a-string/description/
 *
 * Output:
 * ------
 * lecoe
 *
 */

import java.util.Stack;

public class RemoveStarsFromString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(Character t : s.toCharArray()) {
            if (t == '*') {
                stack.pop();
            } else {
                stack.push(t);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new RemoveStarsFromString().removeStars("leet**cod*e"));
        System.out.println(new RemoveStarsFromString().removeStars("erase*****"));
    }

}

