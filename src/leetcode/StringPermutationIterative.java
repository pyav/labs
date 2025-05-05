/**
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * Output:
 * ------
 * true
 * false
 * false
 */

class StringPermutationIterative {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // Create a frequency array for s1
        int[] s1Freq = new int[26];
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }
        // Create a frequency array for the first window of s2
        int[] s2Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s2Freq[s2.charAt(i) - 'a']++;
        }
        // Check if the first window matches
        if (isPermutation(s1Freq, s2Freq)) {
            return true;
        }
        // Slide the window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add the next character to the window
            s2Freq[s2.charAt(i) - 'a']++;
            // Remove the first character of the previous window
            s2Freq[s2.charAt(i - s1.length()) - 'a']--;
            // Check if the current window matches
            if (isPermutation(s1Freq, s2Freq)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPermutation(int[] s1Freq, int[] s2Freq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StringPermutationIterative().checkInclusion("ab", "eidbaooo"));
        System.out.println(new StringPermutationIterative().checkInclusion("ab", "eidboaoo"));
        System.out.println(new StringPermutationIterative().checkInclusion("dinitrophenylhydrazine", "acetylphenylhydrazine"));
    }
}

