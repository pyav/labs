/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Output:
 * ------
 * a a a 
 * a aa 
 * aa a 
 * aaa 
 * a 
 * a a b c 
 * aa b c 
 */

import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {

    private List<List<String>> result = new ArrayList<List<String>>();

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

    public void getMinPartCount(List<String> list, String input, int i, int j) {
        for (int k = i; k < j; k++) {
            if (isPalindrome(input, i, k)) {
                if (k+1 == j) {
                    list.add(input.substring(i, k+1));
                    result.add(list);
                }
            } else {
                continue;
            }
            List<String> list2 = new ArrayList<String>();
            list2.addAll(list);
            list2.add(input.substring(i, k+1));
            getMinPartCount(list2, input, k+1, j);
        }
    }


    public List<List<String>> partition(String s) {
        getMinPartCount(new ArrayList<String>(), s, 0, s.length());
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = new PalindromePartitioning().partition("aaa");
        for (List<String> item : result) {
            for (String str : item) {
                System.out.printf("%s ", str);
            }
            System.out.println();
        }
        List<List<String>> result2 = new PalindromePartitioning().partition("a");
        for (List<String> item : result2) {
            for (String str : item) {
                System.out.printf("%s ", str);
            }
            System.out.println();
        }
        List<List<String>> result3 = new PalindromePartitioning().partition("aabc");
        for (List<String> item : result3) {
            for (String str : item) {
                System.out.printf("%s ", str);
            }
            System.out.println();
        }
    }

}

