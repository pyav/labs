/**
 * https://leetcode.com/problems/reverse-string-prefix/description/
 * 
 * Output:
 * ------
 * bac
 * abc
 * cba
 * a
 */

public class ReverseStringPrefix {
	
	public String reversePrefix(String s, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, k)).reverse();
        return sb.toString() + s.substring(k, s.length());
    }

	public static void main(String[] args) {
		System.out.println(new ReverseStringPrefix().reversePrefix("abc", 2));
		System.out.println(new ReverseStringPrefix().reversePrefix("abc", 1));
		System.out.println(new ReverseStringPrefix().reversePrefix("abc", 3));
		System.out.println(new ReverseStringPrefix().reversePrefix("a", 1));
	}

}
