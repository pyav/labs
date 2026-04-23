/**
 * https://leetcode.com/problems/percentage-of-letter-in-string/
 * 
 * Output:
 * ------
 * 33
 * 0
 * 0
 * 100
 */

public class LetterPercentage {

	public int percentageLetter(String s, char letter) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == letter) {
        		count++;
        	}
        }
        return count*100/s.length();
    }
	
	public static void main(String[] args) {
		System.out.println(new LetterPercentage().percentageLetter("foobar", 'o'));
		System.out.println(new LetterPercentage().percentageLetter("jjjj", 'k'));
		System.out.println(new LetterPercentage().percentageLetter("j", 'k'));
		System.out.println(new LetterPercentage().percentageLetter("j", 'j'));
	}

}
