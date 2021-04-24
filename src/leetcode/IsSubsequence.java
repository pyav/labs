/**
 * https://leetcode.com/problems/is-subsequence/
 *
 * Output:
 * ------
 * true
 */

package leetcode;

public class  IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length() && j < s.length(); i++) {
            if (t.charAt(i)==s.charAt(j)) {
                j++;
            }
        }
        if (j < s.length()) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.printf("%s", new IsSubsequence().isSubsequence(s, t));
    }

}

