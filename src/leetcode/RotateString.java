/**
 * https://leetcode.com/problems/rotate-string/description/
 * 
 * Output:
 * ------
 * true
 * false
 * false
 */

public class RotateString {
	
	public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
        	return false;
        }
        String newS = s+s;
        return newS.contains(goal);
    }

	public static void main(String[] args) {
		System.out.println(new RotateString().rotateString("abcde", "cdeab"));
		System.out.println(new RotateString().rotateString("abced", "cdeab"));
		System.out.println(new RotateString().rotateString("aa", "a"));
	}

}
