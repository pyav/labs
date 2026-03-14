/*
 * https://leetcode.com/problems/reverse-string-ii/
 * 
 * Output:
 * ------
 * bacdfeg
 * bacd
 * cbadefg
 * a
 * a
 */

public class ReverseStringII {

	public String reverseStr(String s, int k) {
		StringBuilder finalSb = new StringBuilder();
		boolean flip = false;
		
        while (s.length() > 0) {
        	int i = 0;
        	StringBuilder sb = new StringBuilder();
        	sb.append(s.substring(i, (k>s.length())?s.length():k));
        	s = s.substring((k>s.length())?s.length():k, s.length());
        	
        	if (!flip) {
            	finalSb.append(sb.reverse().toString());
        		flip = true;
        	} else {
        		finalSb.append(sb.toString());
        		flip = false;
        	}
        }
        return finalSb.toString();
    }

	public static void main(String[] args) {
		System.out.println(new ReverseStringII().reverseStr("abcdefg", 2));
		System.out.println(new ReverseStringII().reverseStr("abcd", 2));
		System.out.println(new ReverseStringII().reverseStr("abcdefg", 3));
		System.out.println(new ReverseStringII().reverseStr("a", 2));
		System.out.println(new ReverseStringII().reverseStr("a", 1));
	}

}
