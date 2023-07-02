/**
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * Output:
 * ------
 * 5
 * 4
 * 1
 * 1
 */

public class LenLastWord {

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;        
        int len = 0;
        while(s.charAt(i) == ' ' && i > 0) {
            i--;
        }
        while(i>=0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new LenLastWord().lengthOfLastWord("Hello World"));
        System.out.println(new LenLastWord().lengthOfLastWord("Hello World moon  "));
        System.out.println(new LenLastWord().lengthOfLastWord("  a "));
        System.out.println(new LenLastWord().lengthOfLastWord("a"));
    }

}
