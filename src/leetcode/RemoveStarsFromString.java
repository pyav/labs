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
        Stack<Character> stack1 = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(s.charAt(i));
            }
        }
        String result = "";
        while (!stack1.isEmpty()) {
            result += stack1.pop();
        }
        return new StringBuilder(result).reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(new RemoveStarsFromString().removeStars("leet**cod*e"));
        System.out.println(new RemoveStarsFromString().removeStars("erase*****"));
    }

}

