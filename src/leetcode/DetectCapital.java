/**
 * https://leetcode.com/problems/detect-capital/
 *
 * Output:
 * ------
 * true
 * true
 * true
 * true
 * false
 */

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int lowerCount = 0;
        int upperCount = 0;
        boolean isFirstUpper = false;

        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            isFirstUpper = true;
            upperCount++;
        } else {
            lowerCount++;
        }

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                upperCount++;
            } else {
                lowerCount++;
            }
        }
        if (lowerCount == 0 || upperCount == 0) {
            return true;
        }
        if ((upperCount == 1) && isFirstUpper) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUse("India"));
        System.out.println(new DetectCapital().detectCapitalUse("USA"));
        System.out.println(new DetectCapital().detectCapitalUse("Google"));
        System.out.println(new DetectCapital().detectCapitalUse("leetcode"));
        System.out.println(new DetectCapital().detectCapitalUse("LeetCode"));
    }
}

