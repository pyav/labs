/**
 * Following program demonstrates the calculation of the length of the longest
 * palindromic subsequence.
 * 
 * Output
 * ------
 * The longest palindromic subsequence has length = 7
 * 
 * @author pyav
 */

public class LongestPalindromicSubsequenceRecursive {
    
    public static int lpsr(String str, int start, int end) {
        if (start == end) {
            return 1;
        }
        if (start + 1 == end && str.charAt(start) == str.charAt(end)) {
            return 2;
        }
        if (str.charAt(start) == str.charAt(end)) {
            return 2 + lpsr(str, start + 1, end - 1);
        } else {
            return max(lpsr(str, start, end - 1), lpsr(str, start + 1, end));
        }
    }
    
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    public static void main(String[] args) {
        String str = "BBABCBCAB";
        int longestLen = lpsr(str, 0, str.length() - 1);
        
        System.out.println("The longest palindromic subsequence has length = "
                + Integer.toString(longestLen));
    }
    
}
