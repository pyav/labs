/**
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * Output:
 * ------
 * 7
 * 1
 * 5
 * 983
 */

import java.util.Arrays;

public class LongestPalindrome {

	public int longestPalindrome(String s) {
        int[] count = new int[52];
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
        	char chr = s.charAt(i);
        	if (chr >= 'a') {
        		count[chr - 'a']++;
        	} else {
        		count[chr - 'A' + 26]++;
        	}
        }
        
        int result = 0;
        boolean hasOdd = false;
        
        for (int i = 0; i < 52; i++) {
        	if ((count[i] % 2 != 0)) {
        		result += count[i]-1;
        		hasOdd = true;
        	} else if (count[i] % 2 == 0) {
        		result += count[i];
        	}
        }
        return (hasOdd)? result + 1: result;
    }
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
		System.out.println(new LongestPalindrome().longestPalindrome("a"));
		System.out.println(new LongestPalindrome().longestPalindrome("abcccdd"));
		System.out.println(new LongestPalindrome().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

}
