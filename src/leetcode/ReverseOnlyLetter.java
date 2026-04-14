/**
 * https://leetcode.com/problems/reverse-only-letters/
 * 
 *  Output:
 *  ------
 *  
 */

public class ReverseOnlyLetter {
	
	public String reverseOnlyLetters(String s) {
		char[] sChar = s.toCharArray();
        for (int i = 0, j = sChar.length-1; i < j;) {
        	if (!((sChar[i] >= 'a' && sChar[i] <= 'z') || (sChar[i] >= 'A' && sChar[i] <= 'Z'))) {
        		i++;
        	} else if (!((sChar[j] >= 'a' && sChar[j] <= 'z') || (sChar[j] >= 'A' && sChar[j] <= 'Z'))) {
        		j--;
        	} else {
        		char tmp = sChar[i];
        		sChar[i] = sChar[j];
        		sChar[j] = tmp;
        		i++;
        		j--;
        	}
        }
        
        return String.valueOf(sChar);
    }

	public static void main(String[] args) {
		System.out.println(new ReverseOnlyLetter().reverseOnlyLetters("ab-cd"));
		System.out.println(new ReverseOnlyLetter().reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println(new ReverseOnlyLetter().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}

}
