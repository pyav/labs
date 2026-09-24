/**
 * https://leetcode.com/problems/decode-string/description/
 *
 * Output:
 * ------
 * accaccacc
 * abcabccdcdcdef
 * aaabcbc
 * aaaaaaaaaaaaabcbc
 * zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
 */

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!(stack.peek().equals("["))) {
                    sb.insert(0, stack.pop());
                }
                stack.pop();

                StringBuilder countStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    countStr.insert(0, stack.pop());
                }
                int count = Integer.parseInt(countStr.toString());
                String repeat = sb.toString();
                StringBuilder tmp = new StringBuilder();

                while (count > 0) {
                    tmp.append(repeat);
                    count--;
                }
                stack.push(tmp.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
        System.out.println(new DecodeString().decodeString("13[a]2[bc]"));
        System.out.println(new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}

