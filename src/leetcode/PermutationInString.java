/**
 * https://leetcode.com/problems/permutation-in-string/
 *
 * Output:
 * ------
 * true
 * false
 */

public class PermutationInString {
    private boolean arrayEquals(int[] first, int[] second) {
       for (int i = 0; i <  first.length; i++) {
           if (first[i] != second[i]) {
               return false;
           }
       }
       return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] countS1 = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            countS1[s1.charAt(i)-'a']++;
        }

        int[] tmp = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            tmp[s2.charAt(i) - 'a']++;
        }
        if (arrayEquals(countS1, tmp)) {
            return true;
        }

        for (int i = 1; i < s2.length()-s1.length()+1; i++) {
            tmp[s2.charAt(i-1)-'a']--;
            tmp[s2.charAt(i+s1.length()-1)-'a']++;
            if (arrayEquals(countS1, tmp)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
        System.out.println(new PermutationInString().checkInclusion("ab", "eidboaoo"));
    }
}

