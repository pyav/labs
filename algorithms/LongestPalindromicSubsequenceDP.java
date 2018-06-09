/**
 * Following program demonstrates the calculation of the length of the longest
 * palindromic subsequence using dynamic programming.
 * 
 * Output
 * ------
 * The longest palindromic subsequence has length = 7
 * 
 * @author pyav
 */

public class LongestPalindromicSubsequenceDP {

	static int max(int a, int b) {
		return (a > b)? a : b;
	}
	
	public static int lpsdp(String sequence) {
        int len = sequence.length();
        int bigArr[][] = new int[len][len];
        int i;
        int j;
        
        for (i = 0; i < len; i++) {
        	for (j=0; j<len; j++) {
        		if (i == j) {
        			bigArr[i][j] = 1;
        		}
        	}
        }
        
        for (j = 1; j < len; j++) {
        	for (i = (j-1); i >= 0; i--) {
        		if ((j == (i+1)) && (sequence.charAt(i) == sequence.charAt(j))) {
        			bigArr[i][j] = 2;
        		}
        		else if (sequence.charAt(i) == sequence.charAt(j)) {
        			bigArr[i][j] = 2 + bigArr[i+1][j-1];
        		}
        		else {
        			bigArr[i][j] = max(bigArr[i+1][j], bigArr[i][j-1]);
        		}
        	}
        }
        
        return bigArr[0][len - 1];
    }

	public static void main(String[] args) {
		String sequence = "BBABCBCAB";
		System.out.println("The longest palindromic subsequence has length = " 
		                   + lpsdp(sequence));
	}

}
