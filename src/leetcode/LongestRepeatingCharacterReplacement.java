/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * Output:
 * ------
 * 4
 * 4
 */

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int ans = 0;
        int left = 0;
        int freq[] = new int[26];

        for (int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            while(right-left+1-maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
    }
}
