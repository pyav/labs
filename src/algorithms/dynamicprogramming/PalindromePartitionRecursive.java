/**
 * This program is for finding the minimum number of partitions needed to cut a
 * string in palindromic sub-strings.
 *
 * Output:
 * ------
 * 3
 */

public class PalindromePartitionRecursive {

    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int getMinPartCount(String input, int i, int j) {
        if (i >= j || isPalindrome(input, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = 1 + getMinPartCount(input, i, k) + getMinPartCount(input, k+1, j);
            if (count < min) {
                min = count;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(new PalindromePartitionRecursive().getMinPartCount(str, 0, str.length()-1));
    }

}

