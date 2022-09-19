/**
 * https://leetcode.com/problems/letter-case-permutation/
 *
 * Output:
 * ------
 * a1b2 a1B2 A1b2 A1B2 
 * 3z4 3Z4 
 * z Z 
 * 12
 */

import java.util.*;

public class LetterCasePermutation {

    private void calcPermutation(Set<String> set, String input, int i, int j) {
        if (i == j || i+1 == j) {
            set.add(input);
        }
        for (int k = i; k < j; k++) {
            if (input.charAt(k) >= 'a' && input.charAt(k) <= 'z') {
                calcPermutation(set, input, k+1, j);
                String updatedStr = "";
                if (k == j - 1) {
                    updatedStr = input.substring(0,k) + Character.toUpperCase(input.charAt(k));
                } else {
                    updatedStr = input.substring(0,k) + Character.toUpperCase(input.charAt(k)) + 
                                 input.substring(k+1, j);
                }

                calcPermutation(set, updatedStr, k+1, j);
            } else {
                calcPermutation(set, input, k+1, j);
            }
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        calcPermutation(set, s.toLowerCase(), 0, s.length());
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = new LetterCasePermutation().letterCasePermutation("a1b2");
        for (String item : result) {
            System.out.printf("%s ", item);
        }
        System.out.println();
        List<String> result2 = new LetterCasePermutation().letterCasePermutation("3z4");
        for (String item : result2) {
            System.out.printf("%s ", item);
        }
        System.out.println();
        List<String> result3 = new LetterCasePermutation().letterCasePermutation("z");
        for (String item : result3) {
            System.out.printf("%s ", item);
        }
        System.out.println();
        List<String> result4 = new LetterCasePermutation().letterCasePermutation("12");
        for (String item : result4) {
            System.out.printf("%s ", item);
        }
        System.out.println();
    }

}

